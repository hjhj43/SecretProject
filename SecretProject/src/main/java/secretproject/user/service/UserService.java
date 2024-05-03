package secretproject.user.service;

import secretproject.user.vo.UserVO;

public interface UserService {
	
	public UserVO selectDetail(String userId) throws Exception;

	public void insertUser(UserVO userVO) throws Exception;
	
	public int idCheck(UserVO userVO) throws Exception;
	
	public UserVO getUserData(UserVO userVO) throws Exception;

	public void updateUser(UserVO userVO) throws Exception;

}
