package com.tenco.board.repository.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {
	
	private Integer id;
	private String title;
	private String content;
	private String author;
	
}
