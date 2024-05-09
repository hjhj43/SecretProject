package secretproject.comment.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import secretproject.comment.serviceimpl.CommentMapper;
import secretproject.comment.vo.CommentVO;

@Repository("commentDAO")
public class CommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private CommentMapper mapper;

	@PostConstruct
	public void init() {
		mapper = sqlSession.getMapper(CommentMapper.class);
	}
	
	public List<CommentVO> selectCommentList(CommentVO commentVO) throws Exception {
		return mapper.selectCommentList(commentVO);
	}
	
	public void insertComment(CommentVO commentVO) throws Exception {
		mapper.insertComment(commentVO);
	}

	public void updateComment(CommentVO commentVO) throws Exception {
		mapper.updateComment(commentVO);
	}

	public void deleteComment(int commentSn) throws Exception {
		mapper.deleteComment(commentSn);
	}
}
