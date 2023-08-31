package com.phyho.web.repository;

import org.springframework.data.repository.Repository;

import com.phyho.web.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jBoard);


}

