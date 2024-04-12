package secretproject.user.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import secretproject.board.vo.BoardVO;
import secretproject.user.serviceimpl.UserMapper;
import secretproject.user.vo.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private UserMapper mapper;
	
	@PostConstruct
	public void init() {
		mapper = sqlSession.getMapper(UserMapper.class);
	}
		
		public List<UserVO> selectUserList(UserVO userVO) throws Exception {
			return mapper.selectUserList(userVO);
		}
		
		public UserVO selectDetail(String userId) throws Exception {
			return mapper.selectDetail(userId);
		}
		
		public void insertUser(UserVO userVO) throws Exception {
			mapper.insertUser(userVO);
		}
		
		public int idCheck(UserVO userVO) throws Exception {
			int result = mapper.idCheck(userVO);
			return result;
		}
		
		public UserVO getUserData(UserVO userVO) throws Exception {
			return mapper.getUserData(userVO);
		}
		
		public void updateUser(UserVO userVO) throws Exception {
			mapper.updateUser(userVO);
		}
		
		public void deleteUser(String userId) throws Exception {
			mapper.deleteUser(userId);
		}
	}
