package secretproject.user.service;

import java.util.List;

import secretproject.user.vo.UserVO;

public interface UserService {
	
	List<UserVO> selectUserList(UserVO userVO) throws Exception;
	
	public UserVO selectDetail(String userId) throws Exception;

	public void insertUser(UserVO userVO) throws Exception;
	
	public int idCheck(UserVO userVO) throws Exception;
	
	public UserVO getUserData(UserVO userVO) throws Exception;

	public void updateUser(UserVO userVO) throws Exception;

	public void deleteUser(String userId) throws Exception;

}
