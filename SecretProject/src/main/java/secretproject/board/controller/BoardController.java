package secretproject.board.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import secretproject.board.service.BoardService;
import secretproject.board.vo.BoardVO;

@Controller
public class BoardController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(BoardController.class);    //로거 생성

	
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	
//	@Autowired                        															   //이방법으로 의존성 주입도 가능함.
//	private BoardService boardService;

	
	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BoardVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/BoardList.do")
	public String selectBoardList(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception {
		
		log.info("/BoardList.do started");										//예시 로그
		
		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		model.addAttribute("boardList", boardList);
		
		log.info("BoardList ==>> {}",boardList);
		
		
		
		
		log.info("/BoardList.do Ended");                                         //예시 로그
		

		return "board/boardList";
	}	
}
