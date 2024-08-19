package com.tenco.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.board.dto.BoardDTO;
import com.tenco.board.repository.model.Board;

@Mapper
public interface BoardRepository {
	
	List<Board> readAll();
	Board readById();
	int create(BoardDTO dto);
	int update(BoardDTO dto);
	int deleteById(int id);
}
