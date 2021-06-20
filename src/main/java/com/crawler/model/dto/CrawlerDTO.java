package com.crawler.model.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="crawler")
@Data
public class CrawlerDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	@Column(name="URL")
	private String urls;
	
	
	@Override
	   public String toString() {
	       return "{" +
	               "id=" + ID +
	               ", url='" + urls + '\'' +
	               '}';
	   }

}
