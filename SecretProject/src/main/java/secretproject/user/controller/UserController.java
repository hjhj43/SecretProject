package secretproject.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import secretproject.user.service.UserService;
import secretproject.user.vo.UserVO;

@Controller
public class UserController {
	
	@Resource(name = "userService")
	private UserService userService;
	
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
	public String write(@ModelAttribute("userVO") UserVO userVO) throws Exception {
		int result = userService.idCheck(userVO);
		try {
			if (result == 1) {
				return "user/userRegister";
			} else if (result == 0) {
				userService.insertUser(userVO);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:UserList.do";
	}
	
	// 아이디 중복 검사
	@RequestMapping(value="/idCheck.do")
	public int idCheck(UserVO userVO) throws Exception {
		int result = userService.idCheck(userVO);
		return result;
	}
	
	// 회원정보 수정
	@RequestMapping(value="/updateUser.do")
	public String updateUser(@ModelAttribute("userVO") UserVO userVO) throws Exception {
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
