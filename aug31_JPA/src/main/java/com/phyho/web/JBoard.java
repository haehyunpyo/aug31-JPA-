package com.phyho.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class JBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bno;
	
	@Column(name = "btitle", length = 15)
	private String title;
	
	@Column(name = "bcontent", columnDefinition = "MIDIUMTEXT")
	private String content;
	
	@Column(columnDefinition = "TIMESTAMP")
	private String bdate;
	
	private String mname;
	
}
