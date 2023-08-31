package com.phyho.web.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.phyho.web.Member;

public interface MemberRepository extends Repository<Member, Long> {

	List<Member> findAll();

	void save(Member member);

	List<Member> findTop5ByOrderByMnoDesc();

}

