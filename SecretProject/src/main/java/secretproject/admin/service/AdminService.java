package secretproject.admin.service;

import java.util.List;

import secretproject.user.vo.UserVO;

public interface AdminService {
	
	List<UserVO> selectUserList(UserVO userVO) throws Exception;

	public void deleteUser(String userId) throws Exception;

	public int getTotCntUser() throws Exception;
}
