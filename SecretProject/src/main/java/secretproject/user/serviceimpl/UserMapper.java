package secretproject.user.serviceimpl;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import secretproject.user.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public UserVO selectDetail(String userId) throws Exception;
	
	public void insertUser(UserVO userVO) throws Exception;
	
	public int idCheck(UserVO userVO) throws Exception;
	
	public UserVO getUserData(UserVO userVO) throws Exception;
	 
	public void updateUser(UserVO userVO) throws Exception;

}
