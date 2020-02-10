package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.entity.BoardEntity;
import board.service.JpaBoardService;

@Controller
public class JpaBoardController {
	
	@Autowired
	private JpaBoardService jpaBoardService;
	
	@RequestMapping(value = "/jpa/board", method = RequestMethod.GET)
	public ModelAndView boardList() {
		System.out.println("JapBoardController : boardList() 실행");
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/board/jpaBoardList");
		// .html 확장자를 쓰지않아도 
		//	Thymeleaf에 의해  templates 폴더아래 있는 
		//  boardList.html 파일을 의미한다.
		
		List<BoardEntity> list=jpaBoardService.selectBoardList();
		//System.out.println(list);
		System.out.println("list 사이즈 : "+ list.size());
		//if(list.size()!=0)
		mv.addObject("list", list);
		//게시글 정보
		
		return mv;
	}
	
	//글쓰기 페이지 이동
	@GetMapping("/jpa/board/write")
	public String openBoardWrite() {
		return "/board/jpaBoardWrite";
	}
	//
	@PostMapping("/jpa/board/write")
	public String boardWrite(BoardEntity boardEntity, MultipartHttpServletRequest mr) {
		jpaBoardService.saveBoard(boardEntity, mr);
		return "redirect:/jpa/board";
	}
}
