package secretproject.comment.service;

import java.util.List;

import secretproject.comment.vo.CommentVO;

public interface CommentService {
	
	public List<CommentVO> selectCommentList(CommentVO commentVO) throws Exception;
	
	public void insertComment(CommentVO commentVO) throws Exception;

	public void updateComment(CommentVO commentVO) throws Exception;

	public void deleteComment(int commentSn) throws Exception;

}
