package com.crawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawler.model.dto.CrawlerDTO;
import com.crawler.repository.CrawlerRepository;

@Service
public class CrawlerService {

	@Autowired
	private CrawlerRepository crawlerRepository;

	public void addURLData(List<CrawlerDTO> request) throws Exception {

		for (CrawlerDTO dtoURL : request) {
			crawlerRepository.save(dtoURL);
		}
	}

	public List<CrawlerDTO> getAllURLdata(String searchinput) {

		if (searchinput != null) {
			return crawlerRepository.searchUrl(searchinput);
		}
		return null;
	}
}
