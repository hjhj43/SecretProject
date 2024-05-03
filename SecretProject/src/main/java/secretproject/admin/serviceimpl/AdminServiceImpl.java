package secretproject.admin.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import lombok.extern.slf4j.Slf4j;
import secretproject.admin.dao.AdminDAO;
import secretproject.admin.service.AdminService;
import secretproject.user.vo.UserVO;

@Slf4j
@Service("adminService")
public class AdminServiceImpl extends EgovAbstractServiceImpl implements AdminService{

	@Resource(name = "adminDAO")
	private AdminDAO adminDAO;

	@Override
	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		return adminDAO.selectUserList(userVO);
	}
	
	@Override
	public void deleteUser(String userId) throws Exception {
		adminDAO.deleteUser(userId);
	}

	@Override
	public int getTotCntUser() throws Exception {
		int totalCountOfUser = 0;
		
		totalCountOfUser = adminDAO.getTotCntUser();
		log.info("totalCountOfUser ==>{}",totalCountOfUser);
		
		return totalCountOfUser;
	}
}
