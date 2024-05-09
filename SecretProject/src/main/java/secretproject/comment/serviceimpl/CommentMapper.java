package secretproject.comment.serviceimpl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import secretproject.comment.vo.CommentVO;

@Mapper
public interface CommentMapper {
	
	public List<CommentVO> selectCommentList(CommentVO commentVO) throws Exception;
	
	public void insertComment(CommentVO commentVO) throws Exception;

	public void updateComment(CommentVO commentVO) throws Exception;

	public void deleteComment(int commentSn) throws Exception;


}
