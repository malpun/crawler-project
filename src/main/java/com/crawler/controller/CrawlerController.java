package com.crawler.controller;


import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crawler.model.dto.CrawlerDTO;
import com.crawler.service.CrawlerService;

@RestController
@RequestMapping("/crawler")
public class CrawlerController {
	
	
	Logger logger=Logger.getLogger(CrawlerController.class);
	
	@Autowired
	private CrawlerService service;
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.POST)
	public ResponseEntity<Object> addData(@RequestBody List<CrawlerDTO> request)
			throws Exception {
		try {
			service.addURLData(request);
		} catch (Exception e) {
			logger.error("Exception occured while adding Data to Crawler table : "+e.getMessage());
		}
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@RequestMapping(value = { "/getCrawlerdata/{searchinput}" }, method = { RequestMethod.GET }, produces = { "application/json" })
	public ResponseEntity<Object> getCrawlerData(@PathVariable String searchinput) throws Exception {
		List<CrawlerDTO> matchCrawlerData = null;
		try {
			matchCrawlerData = service.getAllURLdata(searchinput);
				logger.info(matchCrawlerData);

		} catch (Exception e) {
			logger.error("Exception occured while getting Data from Crawler table : "+e);
		}
		return new ResponseEntity<Object>(matchCrawlerData, HttpStatus.OK);
	}
	

}
