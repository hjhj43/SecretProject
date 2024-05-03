package secretproject.admin.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import secretproject.admin.serviceimpl.AdminMapper;
import secretproject.user.vo.UserVO;

@Repository("adminDAO")
public class AdminDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private AdminMapper mapper;
	
	@PostConstruct
	public void init() {
		mapper = sqlSession.getMapper(AdminMapper.class);
	}

	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		return mapper.selectUserList(userVO);
	}
	
	public void deleteUser(String userId) throws Exception {
		mapper.deleteUser(userId);
	}
	
	public int getTotCntUser() throws Exception {
		return mapper.getTotCntUser();
	}
}
