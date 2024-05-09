package secretproject.comment.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import secretproject.comment.service.CommentService;
import secretproject.comment.vo.CommentVO;

@Slf4j
@Validated
@Controller
public class CommentController {

	@Resource (name = "commentService")
	private CommentService commentService;
	
//	@Resource(name = "boardService")
//	private BoardService boardService;
//	
//	@Resource(name = "userService")
//	private UserService userService;
	
	// 댓글 조회
	@RequestMapping(value = "/CommentList.do")
	public String selectCommentList(@ModelAttribute("commentVO") CommentVO commentVO, Model model) throws Exception {
		
		List<CommentVO> commentList = commentService.selectCommentList(commentVO);
		model.addAttribute("commentList", commentList);
		
		log.info("commentList ==>> {}", commentList);
		
		return "comment/commentList";
	}
	
	// 댓글 작성페이지
	@RequestMapping(value="/CommentRegister.do")
	public String commentRegister() {
		return "comment/commentRegister";
	}
	
	// 댓글 작성
	@RequestMapping(value="/insertComment.do")
	public String write(@ModelAttribute("commentVO") @Valid CommentVO commentVO) throws Exception {
		commentService.insertComment(commentVO);
		return "redirect:CommentList.do";
	}
	
	// 댓글 수정 (댓글 작성자만 수정 가능)
	@RequestMapping(value="/updateComment.do")
	public String updateComment(@ModelAttribute("commentVO") @Valid CommentVO commentVO, HttpServletRequest request, HttpSession session) throws Exception {
		return null;
	}
	
	// 댓글 삭제 (댓글 작성자와 admin만 삭제 가능)
	@RequestMapping(value="/deleteComment.do")
	public String deleteComment(HttpServletRequest request, HttpSession session, CommentVO commentVO) throws Exception {
		int commentSn = Integer.parseInt(request.getParameter("commentSn"));
		commentService.deleteComment(commentSn);
		return "redirect:CommentList.do";
	}
}