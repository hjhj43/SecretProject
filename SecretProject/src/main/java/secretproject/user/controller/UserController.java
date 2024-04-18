package secretproject.user.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
//import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import lombok.extern.slf4j.Slf4j;
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
	private BCryptPasswordEncoder pwdEncoder;
	
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@Resource(name = "cryptoService")
	private CryptoService cryptoService;
	
	//회원정보 조회
	@RequestMapping(value = "/UserList.do")
	public String selectUserList(@ModelAttribute("userVO") UserVO userVO, Model model) throws Exception {
		
		int userCnt = userService.getTotCntUser();
		
		userVO.setTotalRowCount(userCnt);
		userVO.setUpPagination();
		
		List<UserVO> userList = userService.selectUserList(userVO);
		for(UserVO userVo : userList) {
			String userPhone = userVo.getUserPhone();
			String decryptedPhone = cryptoService.decryptData(userPhone);
			String maskPhone = phoneMasking(decryptedPhone);
			userVo.setUserPhone(maskPhone);
		}
		
		DefaultVO pagingVO = userVO;
		
		model.addAttribute("userList", userList);
		model.addAttribute("userPagingVO", pagingVO);
		
		return "user/userList";
	}
	
	// 회원정보 상세페이지
	@RequestMapping(value="/UserDetail.do")
	public String viewUser (Model model, HttpServletRequest request) throws Exception{
		String userId = request.getParameter("userId");
		
		UserVO userVO = userService.selectDetail(userId);
		String userPhone = userVO.getUserPhone();
		String decryptedPhone = cryptoService.decryptData(userPhone);
		String maskPhone = phoneMasking(decryptedPhone);
		userVO.setUserPhone(maskPhone);
		
		model.addAttribute("userList", userVO);
		return "user/userDetail";
	}
	
	// 전화번호 마스킹
	public static String phoneMasking(String userPhone) throws Exception {
	    String regex = "(\\d{2,3})-?(\\d{3,4})-?(\\d{4})$";

	    Matcher matcher = Pattern.compile(regex).matcher(userPhone);
	    if(matcher.find()) {
	        String target = matcher.group(2);
	        int length = target.length();
	        char[] c = new char[length];
	        Arrays.fill(c, '*');

	        return userPhone.replace(target, String.valueOf(c));
	    }
	    return userPhone;
	}
	
	// 회원가입 페이지
	@RequestMapping(value="/UserRegister.do")
	public String userRegister() {
		return "user/userRegister";
	}
	
	// 회원가입
	@RequestMapping(value="/insertUser.do")
	public String write( @NotEmpty(message = ".") @ModelAttribute("userVO") @Valid UserVO userVO) throws Exception {
		int result = userService.idCheck(userVO);
		try {
			if (result == 1) {
				return "user/userRegister";
			} else if (result == 0) {

				String inputPw = userVO.getUserPw();
				String pw = pwdEncoder.encode(inputPw);
				userVO.setUserPw(pw);
				
				String userPhone = userVO.getUserPhone();    	
		    	String encryptedPhone = cryptoService.encryptData(userPhone);
		    	userVO.setUserPhone(encryptedPhone);
				
				userService.insertUser(userVO);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:UserList.do";
	}
	
	// 아이디 중복 검사
	@RequestMapping(value="/idCheck.do")
	@ResponseBody
	public int idCheck(UserVO userVO) throws Exception {
		int result = userService.idCheck(userVO);
		return result;
	}
	
	// 로그인 페이지
	@RequestMapping(value="/LoginPage.do")
	public String userLogin() {
		return "user/userLogin";
	}
	
	// 로그인
	@RequestMapping(value="/login.do")
	public String login(UserVO userVO, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		log.info("로그인 - start");
		
		log.info("userVO {}", userVO);
		session.getAttribute("sessionUserData");
		UserVO userData = userService.getUserData(userVO);
		boolean isPwMatch = pwdEncoder.matches(userVO.getUserPw(), userData.getUserPw());
		
		log.info("isPwMatch {}", isPwMatch);
		if(isPwMatch==true) {
			userData.setUserPw(null);
			session.setAttribute("sessionUserData", userData);
			
		} else {
			session.setAttribute("sessionUserData", null);
			return "user/userLogin";
		}
		return "redirect:/";
	}
	
/*	// 로그아웃
	@RequestMapping(value="/logout.do")
	public String logout (HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}*/

	
	// 회원정보 수정
	@RequestMapping(value="/updateUser.do")
	public String updateUser(@ModelAttribute("userVO") UserVO userVO) throws Exception {
		String inputPw = userVO.getUserPw();
		String pwd = pwdEncoder.encode(inputPw);
		userVO.setUserPw(pwd);
		
		String userPhone = userVO.getUserPhone();    	
    	String encryptedPhone = cryptoService.encryptData(userPhone);
    	userVO.setUserPhone(encryptedPhone);
		
		userService.updateUser(userVO);
		return "redirect:UserDetail.do?userId="+userVO.getUserId();
	}
	
	// 회원정보 삭제
	@RequestMapping(value="/deleteUser.do")
	public String deleteUser(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");
		userService.deleteUser(userId);
		return "redirect:UserList.do";
	}

}
