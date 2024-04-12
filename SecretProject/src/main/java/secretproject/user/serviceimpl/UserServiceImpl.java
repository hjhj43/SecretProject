package secretproject.user.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import secretproject.user.dao.UserDAO;
import secretproject.user.service.UserService;
import secretproject.user.vo.UserVO;

@Service("userService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {
	
	@Resource(name = "userDAO")
	private UserDAO userDAO;

	@Override
	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		return userDAO.selectUserList(userVO);
	}
	
	@Override
	public UserVO selectDetail(String userId) throws Exception {
		return userDAO.selectDetail(userId);
	}

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userDAO.insertUser(userVO);
	}
	
	@Override
	public int idCheck(UserVO userVO) throws Exception {
		int result = userDAO.idCheck(userVO);
		return result;
	}
	
	@Override
	public UserVO getUserData(UserVO userVO) throws Exception {
		return userDAO.getUserData(userVO);
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		userDAO.deleteUser(userId);
	}

}
