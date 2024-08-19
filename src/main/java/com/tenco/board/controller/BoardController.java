package com.tenco.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	/**
	 * 게시글 목록 페이지 호출
	 * @param page : 현재 페이지
	 * @param size : 한 페이지당 게시글 수
	 */
	@GetMapping("/")
	public String index(Model model,//
			@RequestParam(defaultValue = "0", name = "page") int page,//
			@RequestParam(defaultValue = "5", name = "size") int size) {
		int totalBoards = boardService.countAll();
		int totalPage = totalBoards / size;
		if (totalBoards % size == 0) {
			totalPage--;
		}
		int pageBlock = 5;
		int blockCount = (page / pageBlock) * pageBlock;
		int startPage = blockCount;
		int endPage = (blockCount + pageBlock - 1) > totalPage ? totalPage : (blockCount + pageBlock - 1);
		List<Board> boardList = boardService.readAll(page, size);
		model.addAttribute("currentPage", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("boardList", boardList);
		return "index";
	}

	/**
	 * 게시글 작성 페이지 호출
	 */
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}

	/**
	 * 게시글 수정 페이지 호출
	 */
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable(name = "id") Integer id, Model model) {
		Board board = boardService.readById(id);
		model.addAttribute("board", board);
		return "board/updateForm";
	}

	/**
	 * 게시글 생성 처리
	 */
	@PostMapping("/board/save")
	public String save(BoardDTO dto) {
		// 유효성 검사
		if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
		if (dto.getContent() == null) {
			throw new DataDeliveryException(Define.ENTER_CONTENT, HttpStatus.BAD_REQUEST);
		}
		if (dto.getAuthor() == null || dto.getAuthor().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_AUTHOR, HttpStatus.BAD_REQUEST);
		}
		if (dto.getTitle().length() > Define.MAX_TITLE) {
			throw new DataDeliveryException(Define.OVER_OF_TITLE_LENGTH, HttpStatus.BAD_REQUEST);
		}
		if (dto.getContent().length() > Define.MAX_CONTENT) {
			throw new DataDeliveryException(Define.OVER_OF_CONTENT_LENGTH, HttpStatus.BAD_REQUEST);
		}
		if (dto.getAuthor().length() > Define.MAX_AUTHOR) {
			throw new DataDeliveryException(Define.OVER_OF_AUTHOR_LENGTH, HttpStatus.BAD_REQUEST);
		}
		boardService.create(dto);
		return "redirect:/";
	}

	@PostMapping("/board/{id}/update")
	public String update(BoardDTO dto, @PathVariable(name = "id") Integer id) {
		if (dto.getTitle() == null || dto.getTitle().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_TITLE, HttpStatus.BAD_REQUEST);
		}
		if (dto.getContent() == null) {
			throw new DataDeliveryException(Define.ENTER_CONTENT, HttpStatus.BAD_REQUEST);
		}
		if (dto.getAuthor() == null || dto.getAuthor().trim().isEmpty()) {
			throw new DataDeliveryException(Define.ENTER_AUTHOR, HttpStatus.BAD_REQUEST);
		}
		if (dto.getTitle().length() > Define.MAX_TITLE) {
			throw new DataDeliveryException(Define.OVER_OF_TITLE_LENGTH, HttpStatus.BAD_REQUEST);
		}
		if (dto.getContent().length() > Define.MAX_CONTENT) {
			throw new DataDeliveryException(Define.OVER_OF_CONTENT_LENGTH, HttpStatus.BAD_REQUEST);
		}
		if (dto.getAuthor().length() > Define.MAX_AUTHOR) {
			throw new DataDeliveryException(Define.OVER_OF_AUTHOR_LENGTH, HttpStatus.BAD_REQUEST);
		}
		boardService.update(dto, id);
		return "redirect:/";
	}

	/**
	 * 게시글 수정 처리
	 */
	@PostMapping("/board/{id}/delete")
	public String delete(@PathVariable(name = "id") Integer id) {
		boardService.deleteById(id);
		return "redirect:/";
	}
}
