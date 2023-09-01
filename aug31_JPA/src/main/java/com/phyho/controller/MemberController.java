package com.phyho.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.phyho.Member;
import com.phyho.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;   
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	
	@PostMapping("/login")
	public String login(Member member, HttpSession session) {
		// Member(mno=0, mname=null, mid=아이디랑, mpw=qlalfqjsgh, mjoindate=null)
		System.out.println(member);
		
		int count = memberService.count(member);
		System.out.println("카운트 : " + count);
		
		
		if(count == 1) {
			Member result = memberService.findByMidAndMpw(member.getMid(), member.getMpw());
			System.out.println("name : " + result);
			//name : Member(mno=1, mname=pyo, mid=pororo, mpw=01234, mjoindate=2023-09-01T10:13:20)
			session.setAttribute("id", result.getMid());
			session.setAttribute("name", result.getMname());
			
			return "redirect:/index";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "redirect:login";
	}
	
}

