package com.tenco.board.service;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<Board> readAll(int page, int size) {
		List<Board> boardListEntity = null;
		try {
			int offset = page * size;
			boardListEntity = boardRepository.readAll(offset, size);
		} catch (DataAccessException e) {
			throw new DataDeliveryException(Define.FAILED_PROCESSING, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw new RedirectException(Define.UNKNOWN, HttpStatus.SERVICE_UNAVAILABLE);
		}
		return boardListEntity;
	}

	/**
	 * 해당 글 삭제
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}

	/**
	 * 게시글 작성
	 * 
	 * @param dto
	 */
	@Transactional
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
	
	/**
	 * 게시글 수정을 위한 조회
	 * @param id
	 * @return
	 */
	public Board readById(int id) {
		Board boardEntity = null;
		try {
			boardEntity = boardRepository.readById(id);
		} catch (DataAccessException e) {
			throw new DataDeliveryException(Define.FAILED_PROCESSING, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			throw new RedirectException(Define.UNKNOWN, HttpStatus.SERVICE_UNAVAILABLE);
		}
		if (boardEntity == null) {
			throw new DataDeliveryException(Define.FAILED_ACCESS, HttpStatus.BAD_REQUEST);
		}
		return boardEntity;
	}
	
	/**
	 * 게시글 수정
	 * @param dto
	 * @param id
	 */
	@Transactional
	public void update(BoardDTO dto, int id) {
		int result = 0;
		try {
			result = boardRepository.update(dto, id);
		} catch (Exception e) {
			throw new RedirectException(Define.UNKNOWN, HttpStatus.SERVICE_UNAVAILABLE);
		}
		if (result == 0) {
			throw new DataDeliveryException(Define.FAIL_TO_CREATE_BOARD, HttpStatus.BAD_REQUEST);
		}
	}
	
	public int countAll() {
		int result = 0;
		result = boardRepository.countAll();
		return result;
	}
}
