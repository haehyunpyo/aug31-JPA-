package com.phyho.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phyho.JBoard;
import com.phyho.Member;
import com.phyho.service.BoardService;
import com.phyho.service.MemberService;

@Controller
public class BoardController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BoardService boardService;

	
	@GetMapping("/board")
	public String board(Model model) {
		List<JBoard> list = boardService.findAll();
		model.addAttribute("list", list);
		return "board";
	}
	
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	@PostMapping("/write")
	public String write(JBoard jBoard, HttpSession session) {
		
		if(session.getAttribute("id") != null) {
			Member member = memberService.findByMid((String) session.getAttribute("id"));
			//member.setMid("pororo");
			jBoard.setMember(member);
			boardService.save(jBoard);
		}
		
		return "redirect:/board";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required = true) int bno, Model model) {
		
		JBoard detail = boardService.findByBno(bno);
		model.addAttribute("detail", detail);
		System.out.println(detail);
		return "detail";
	}

	
	
	
	
}
