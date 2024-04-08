package secretproject.user.serviceimpl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import secretproject.user.vo.UserVO;

@Mapper
public interface UserMapper {
	
	public List<UserVO> selectUserList(UserVO userVO) throws Exception;
	
	public UserVO selectDetail(String userId) throws Exception;
	
	public void insertUser(UserVO userVO) throws Exception;
	
	public int selectOne(UserVO userVO) throws Exception;
	 
	public void updateUser(UserVO userVO) throws Exception;
	
	public void deleteUser(String userId) throws Exception;

}
