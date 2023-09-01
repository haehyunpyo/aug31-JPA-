package com.phyho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phyho.Member;
import com.phyho.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	/* 	findAll()	전체 가져오기
	* 	findOne()	하나 가져오기
	 * 	save()		저장하기 / 수정하기
	 * 	count()		
	 * 	delete()	
	 * 
	 */
	public List<Member> findTop5ByOrderByMnoDesc() {
		return memberRepository.findTop5ByOrderByMnoDesc();
	}

	public int count(String mid, String mpw) {
		return memberRepository.count(mid, mpw);
	}

	public Member findByMid(String mid) {
		return memberRepository.findByMid(mid);
	}

	public Member findByMidAndMpw(String mid, String mpw) {
		return memberRepository.findByMidAndMpw(mid, mpw);
	}
	/*
	 * public Member findByMidAndMpw(Member memeber) { return
	 * memberRepository.findByMidAndMpw(memeber.getMid(), memeber.getMpw()); }
	 */
	//public String findByMid(Member member) {
	//	return memberRepository.findByMid(member);
	//}

	public int count(Member member) {
		return memberRepository.count(member.getMid(), member.getMpw());
	}


}
