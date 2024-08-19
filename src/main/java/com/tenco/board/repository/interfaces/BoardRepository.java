package com.tenco.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tenco.board.dto.BoardDTO;
import com.tenco.board.repository.model.Board;

@Mapper
public interface BoardRepository {

	List<Board> readAll(@Param("offset") int offset, @Param("limit") int limit);

	int countAll();

	Board readById(int id);

	int create(BoardDTO dto);

	int update(@Param("board") BoardDTO dto, @Param("id") int id);

	int deleteById(int id);
}
