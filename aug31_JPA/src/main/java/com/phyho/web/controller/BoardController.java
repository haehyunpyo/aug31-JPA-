package com.phyho.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.phyho.web.JBoard;
import com.phyho.web.repository.BoardRepository;

@Controller
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jBoard) {
		System.out.println(jBoard);
		jBoard.setMname("포로로");
		
		// 저장하기 save()
		boardRepository.save(jBoard);
		
		return "redirect:/board";
	}
}
