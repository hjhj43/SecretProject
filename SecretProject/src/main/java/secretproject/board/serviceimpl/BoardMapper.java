package secretproject.board.serviceimpl;

import java.util.List;

import egovframework.rte.psl.dataaccess.mapper.Mapper;
import secretproject.board.vo.BoardVO;

@Mapper
public interface BoardMapper {
	
	List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception;

}
