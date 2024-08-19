package com.tenco.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tenco.board.repository.model.Board;
import com.tenco.board.service.BoardService;

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
    public String updateForm(@PathVariable int id) {
        return "board/updateForm";
    }

    @PostMapping("/board/save")
    public String save(){
        return "redirect:/";
    }

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable(name="id") Integer id){
        return "redirect:/";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable(name="id") Integer id){
    	boardService.deleteById(id);
        return "redirect:/";
    }
}
