package secretproject.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
//import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import lombok.extern.slf4j.Slf4j;
import secretproject.cmmn.StringUtils;
import secretproject.cmmn.service.CryptoService;
import secretproject.cmmn.vo.DefaultVO;
import secretproject.user.service.UserService;
import secretproject.user.vo.UserVO;

@Slf4j
@Validated
@Controller
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Autowired(required=false)
	@Qualifier("bcryptPasswordEncoder")
	private BCryptPasswordEncoder pwEncoder;
	
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@Resource(name = "cryptoService")
	private CryptoService cryptoService;
	
	// 회원정보 상세페이지 (user, admin 접근 가능)
	@RequestMapping(value="/UserDetail.do")
	public String viewUser (Model model, HttpServletRequest request) throws Exception{
		String userId = request.getParameter("userId");
		
		UserVO userVO = userService.selectDetail(userId);
		String userPhone = userVO.getUserPhone();
		String decryptedPhone = cryptoService.decryptData(userPhone);
		userVO.setUserPhone(decryptedPhone);
		
		model.addAttribute("userList", userVO);
		return "user/userDetail";
	}
	
	// 회원가입 페이지 (모든 사용자 접근 가능)
	@RequestMapping(value="/UserRegister.do")
	public String userRegister() {
		return "user/userRegister";
	}
	
	// 회원가입 (모든 사용자 접근 가능)
	@RequestMapping(value="/insertUser.do")
	public String write( @ModelAttribute("userVO") @Valid UserVO userVO, BindingResult bindingResult, Model model) throws Exception {
		int result = userService.idCheck(userVO);
		try {
			if (result == 1) {
				return "user/userRegister";
			} else if (result == 0) {
				
				if (bindingResult.hasErrors()) {
			        log.info("errors={}", bindingResult);

			        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			        List<String> errorMessages = new ArrayList<>();
			        
			        if(fieldErrors.size()>0) {
			        	for(FieldError error: fieldErrors) {
			        		errorMessages.add(error.getDefaultMessage());
			        		model.addAttribute("errors", errorMessages);
			        	}
			        }
					return "user/userRegister";
			    }

				String inputPw = userVO.getUserPw();
				String pw = pwEncoder.encode(inputPw);
				userVO.setUserPw(pw);
				
				String userPhone = userVO.getUserPhone();    	
		    	String encryptedPhone = cryptoService.encryptData(userPhone);
		    	userVO.setUserPhone(encryptedPhone);
		    	
				userService.insertUser(userVO);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:LoginPage.do";
	}
	
	// 아이디 중복 검사 (모든 사용자 접근 가능)
	@RequestMapping(value="/idCheck.do")
	@ResponseBody
	public int idCheck(UserVO userVO) throws Exception {
		int result = userService.idCheck(userVO);
		return result;
	}
	
	// 로그인 페이지 (모든 사용자 접근 가능)
	@RequestMapping(value="/LoginPage.do")
	public String userLogin() {
		return "user/userLogin";
	}
	
	// 로그인 (모든 사용자 접근 가능)
	@RequestMapping(value="/login.do")
	public String login(UserVO userVO, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		
		log.info("로그인 - start");
		log.info("userVO {}", userVO);
		
		session.getAttribute("sessionUserData");
		UserVO userData = userService.getUserData(userVO);
		boolean isPwMatch = pwEncoder.matches(userVO.getUserPw(), userData.getUserPw());
		
		log.info("isPwMatch {}", isPwMatch);
		
		if(isPwMatch==true) {
			userData.setUserPw(null);
			session.setAttribute("sessionUserData", userData);
			log.info("로그인 성공 {}", userData);
		} else {
			session.setAttribute("sessionUserData", null);
			log.info("로그인 실패 {}", userData);
			return "user/userLogin";
		}
		return "redirect:BoardList.do";
	}
	
	// 로그아웃 (user, admin 접근 가능)
	@RequestMapping(value="/logout.do")
	public String logout (HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}
	
	// 회원정보 수정 (비밀번호가 일치해야 정보 수정 가능, user/admin 접근 가능)
	@RequestMapping(value="/updateUser.do")
	public String updateUser(@ModelAttribute("userVO") @Valid UserVO userVO) throws Exception {
		
		UserVO userData = userService.getUserData(userVO);
		boolean isPwMatch = pwEncoder.matches(userVO.getUserPw(), userData.getUserPw());
		
		log.info("isPwMatch {}", isPwMatch);
		
		if(isPwMatch==true) {
			String userPhone = userVO.getUserPhone();    	
	    	String encryptedPhone = cryptoService.encryptData(userPhone);
	    	userVO.setUserPhone(encryptedPhone);
			
			userService.updateUser(userVO);
		} else {
			return "redirect:UserDetail.do?userId="+userVO.getUserId();
		}
		return "redirect:UserDetail.do?userId="+userVO.getUserId();
	}
}
