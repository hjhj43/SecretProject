package secretproject.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import secretproject.user.service.UserService;
import secretproject.user.vo.UserVO;

@Validated
@Controller
public class UserController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(UserController.class);    //로거 생성
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Autowired(required=false)
	@Qualifier("bcryptPasswordEncoder")
	private BCryptPasswordEncoder pwdEncoder;
	
	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	//회원정보 조회
	@RequestMapping(value = "/UserList.do")
	public String selectUserList(@ModelAttribute("userVO") UserVO userVO, Model model) throws Exception {
		
		List<UserVO> userList = userService.selectUserList(userVO);
		model.addAttribute("userList", userList);
		
		return "user/userList";
	}
	
	// 회원정보 상세페이지
	@RequestMapping(value="/UserDetail.do")
	public String viewUser (Model model, HttpServletRequest request) throws Exception{
		String userId = request.getParameter("userId");
		
		UserVO userVO = userService.selectDetail(userId);
		model.addAttribute("userList", userVO);
		return "user/userDetail";
	}
	
	// 회원가입 페이지
	@RequestMapping(value="/UserRegister.do")
	public String userRegister() {
		return "user/userRegister";
	}
	
	// 회원가입
	@RequestMapping(value="/insertUser.do")
	public String write(@NotEmpty @ModelAttribute("userVO") @Valid UserVO userVO, Model model) throws Exception {
		int result = userService.idCheck(userVO);
		try {
			if (result == 1) {
				return "user/userRegister";
			} else if (result == 0) {

				String inputPw = userVO.getUserPw();
				String pwd = pwdEncoder.encode(inputPw);
				userVO.setUserPw(pwd);
				
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
