package com.tenco.board.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.board.repository.model.Board;

@Mapper
public interface BoardRepository {
	
	List<Board> readAll();
	Board readById();
	void creat(Board board);
	void update(Board board);
	void deleteById(int id);
}
