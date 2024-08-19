package com.tenco.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tenco.board.repository.interfaces.BoardRepository;
import com.tenco.board.repository.model.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	/**
	 * 모든 글 목록 조회
	 * @return
	 */
	public List<Board> readAll(){
		List<Board> boardList = null;
		boardList = boardRepository.readAll();
		return boardList;
	}
	
	/**
	 * 해당 글 삭제
	 * @param id
	 */
	public void deleteById(int id) {
		boardRepository.deleteById(id);
	}
	
}
