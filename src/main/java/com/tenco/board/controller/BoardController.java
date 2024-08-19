package com.tenco.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tenco.board.dto.BoardDTO;
import com.tenco.board.handler.exception.DataDeliveryException;
import com.tenco.board.repository.model.Board;
import com.tenco.board.service.BoardService;
import com.tenco.board.utils.Define;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
    @GetMapping("/")
    public String index(Model model) {
    	List<Board> boardList = boardService.readAll();
    	model.addAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable(name="id") Integer id, Model model) {
    	Board board = boardService.readById(id);
    	model.addAttribute("board", board);
        return "board/updateForm";
    }

    @PostMapping("/board/save")
    public String save(BoardDTO dto){
    	// 유효성 검사
    	if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
    	if (dto.getContent() == null || dto.getContent().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
    	if (dto.getAuthor() == null || dto.getAuthor().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
    	if (dto.getAuthor().length() > Define.MAX_TITLE) {
    		throw new DataDeliveryException(Define.OVER_OF_TITLE_LENGTH, HttpStatus.BAD_REQUEST);
    	}
    	if (dto.getAuthor().length() > Define.MAX_CONTENT) {
    		throw new DataDeliveryException(Define.OVER_OF_CONTENT_LENGTH, HttpStatus.BAD_REQUEST);
    	}
    	if (dto.getAuthor().length() > Define.MAX_AUTHOR) {
    		throw new DataDeliveryException(Define.OVER_OF_AUTHOR_LENGTH, HttpStatus.BAD_REQUEST);
    	}
    	boardService.create(dto);
        return "redirect:/";
    }

    @PostMapping("/board/{id}/update")
    public String update(BoardDTO dto, @PathVariable(name="id") Integer id){
    	if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
    	if (dto.getContent() == null || dto.getContent().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
    	if (dto.getAuthor() == null || dto.getAuthor().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
    	if (dto.getAuthor().length() > Define.MAX_TITLE) {
    		throw new DataDeliveryException(Define.OVER_OF_TITLE_LENGTH, HttpStatus.BAD_REQUEST);
    	}
    	if (dto.getAuthor().length() > Define.MAX_CONTENT) {
    		throw new DataDeliveryException(Define.OVER_OF_CONTENT_LENGTH, HttpStatus.BAD_REQUEST);
    	}
    	if (dto.getAuthor().length() > Define.MAX_AUTHOR) {
    		throw new DataDeliveryException(Define.OVER_OF_AUTHOR_LENGTH, HttpStatus.BAD_REQUEST);
    	}
    	boardService.update(dto, id);
        return "redirect:/";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable(name="id") Integer id){
    	boardService.deleteById(id);
        return "redirect:/";
    }
}
