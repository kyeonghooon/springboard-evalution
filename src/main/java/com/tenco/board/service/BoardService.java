package com.tenco.board.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tenco.board.dto.BoardDTO;
import com.tenco.board.handler.exception.DataDeliveryException;
import com.tenco.board.handler.exception.RedirectException;
import com.tenco.board.repository.interfaces.BoardRepository;
import com.tenco.board.repository.model.Board;
import com.tenco.board.utils.Define;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	/**
	 * 모든 글 목록 조회
	 * 
	 * @return
	 */
	public List<Board> readAll() {
		List<Board> boardList = null;
		boardList = boardRepository.readAll();
		return boardList;
	}

	/**
	 * 해당 글 삭제
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}

	public void create(BoardDTO dto) {
		int result = 0;
		try {
			result = boardRepository.create(dto);
		} catch (Exception e) {
			throw new RedirectException(Define.UNKNOWN, HttpStatus.SERVICE_UNAVAILABLE);
		}
		if (result == 0) {
			throw new DataDeliveryException(Define.FAIL_TO_CREATE_BOARD, HttpStatus.BAD_REQUEST);
		}
	}

}
