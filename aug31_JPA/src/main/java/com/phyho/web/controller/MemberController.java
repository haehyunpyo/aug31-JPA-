package com.phyho.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.phyho.web.Member;
import com.phyho.web.repository.MemberRepository;

@Controller
public class MemberController {

	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/members")
	public String members(Model model) {
/*		Member member = new Member();
		member.setMid("pororo");
		member.setMname("포로로");
		member.setMpw("01234567");
		member.setMjoindate("2023-08-31");
		
		memberRepository.save(member);
*/
		
		//List<Member> list = memberRepository.findAll();
		List<Member> list = memberRepository.findTop5ByOrderByMnoDesc();
		
		/* findAll()	전체 가져오기
		   findOne()	하나 가져오기
		 	save()		저장하기 / 수정하기
		 	count()
		 	delete()
		 */
		model.addAttribute("list", list);
		return "members";
	}
}

