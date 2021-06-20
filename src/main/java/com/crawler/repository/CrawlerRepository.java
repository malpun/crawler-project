package com.crawler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crawler.model.dto.CrawlerDTO;


@Repository
public interface CrawlerRepository extends JpaRepository<CrawlerDTO, Long> {

	@Query(value  = "select * FROM crawler s WHERE s.URL LIKE %?1%",nativeQuery = true)
	public List<CrawlerDTO> searchUrl(String searchinput);

}
