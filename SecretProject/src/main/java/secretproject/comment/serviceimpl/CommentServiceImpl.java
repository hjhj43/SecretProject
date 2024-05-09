package secretproject.comment.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import secretproject.comment.dao.CommentDAO;
import secretproject.comment.service.CommentService;
import secretproject.comment.vo.CommentVO;

@Service("commentService")
public class CommentServiceImpl extends EgovAbstractServiceImpl implements CommentService{
	
	@Resource(name = "commentDAO")
	private CommentDAO commentDAO;

	@Override
	public List<CommentVO> selectCommentList(CommentVO commentVO) throws Exception {
		return commentDAO.selectCommentList(commentVO);
	}

	@Override
	public void insertComment(CommentVO commentVO) throws Exception {
		commentDAO.insertComment(commentVO);
	}

	@Override
	public void updateComment(CommentVO commentVO) throws Exception {
		commentDAO.updateComment(commentVO);
	}

	@Override
	public void deleteComment(int commentSn) throws Exception {
		commentDAO.deleteComment(commentSn);
	}

}
