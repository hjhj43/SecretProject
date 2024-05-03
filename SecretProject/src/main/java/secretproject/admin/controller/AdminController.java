package secretproject.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import secretproject.admin.service.AdminService;
import secretproject.cmmn.StringUtils;
import secretproject.cmmn.service.CryptoService;
import secretproject.cmmn.vo.DefaultVO;
import secretproject.user.vo.UserVO;

@Validated
@Controller
public class AdminController {
	
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "cryptoService")
	private CryptoService cryptoService;
	
	//회원정보 조회 (admin만 접근 가능)
	@RequestMapping(value = "/UserList.do")
	public String selectUserList(@ModelAttribute("userVO") UserVO userVO, Model model) throws Exception {
		
		int userCnt = adminService.getTotCntUser();
		
		userVO.setTotalRowCount(userCnt);
		userVO.setUpPagination();
		
		List<UserVO> userList = adminService.selectUserList(userVO);
		
		for(UserVO userVo : userList) {
			String userPhone = userVo.getUserPhone();
			String decryptedPhone = cryptoService.decryptData(userPhone);
			String maskPhone = StringUtils.phoneMasking(decryptedPhone);
			userVo.setUserPhone(maskPhone);
		}
		
		DefaultVO pagingVO = userVO;
		
		model.addAttribute("userList", userList);
		model.addAttribute("userPagingVO", pagingVO);
		
		return "user/userList";
	}
	
	// 회원정보 삭제 (admin만 접근 가능)
	@RequestMapping(value="/deleteUser.do")
	public String deleteUser(HttpServletRequest request) throws Exception {
		String userId = request.getParameter("userId");
		adminService.deleteUser(userId);
		return "redirect:UserList.do";
	}
}
