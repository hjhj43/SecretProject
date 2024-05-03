package secretproject.admin.serviceimpl;

import java.util.List;


import egovframework.rte.psl.dataaccess.mapper.Mapper;
import secretproject.user.vo.UserVO;

@Mapper
public interface AdminMapper {
	
	public List<UserVO> selectUserList(UserVO userVO) throws Exception;
	
	public void deleteUser(String userId) throws Exception;

	public int getTotCntUser() throws Exception;
}
