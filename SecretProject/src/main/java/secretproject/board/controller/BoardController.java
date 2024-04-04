package secretproject.board.controller;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import secretproject.board.service.BoardService;
import secretproject.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Resource(name = "boardService")
	private BoardService boardService;

	/**
	 * 글 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BoardVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/BoardList.do")
	public String selectBoardList(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception {

		List<BoardVO> boardList = boardService.selectBoardList(boardVO);
		model.addAttribute("boardList", boardList);
		System.out.println(boardList);

		return "board/boardList";
	}	
}
