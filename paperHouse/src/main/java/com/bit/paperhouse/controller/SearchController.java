package com.bit.paperhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.paperhouse.dto.ArticleDto;
import com.bit.paperhouse.dto.SearchDto;
import com.bit.paperhouse.dto.WriterDto;
import com.bit.paperhouse.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@RequestMapping(value = "/search")
	public String search() {
		System.out.println("SearchController search");
		return "/search";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSearchWlist", method = RequestMethod.GET)
	public List<WriterDto> getSearchList(SearchDto searchDto) {
		if(searchDto.getSearchSort() == null || searchDto.getSort() == null) {
			searchDto.setSearchSort("WRITER_NAME");
			searchDto.setSort("ASC");
		}
		System.out.println("getSearchWlist");
		System.out.println(searchDto.toString());
		List<WriterDto> list = searchService.getSearchWriter(searchDto);
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getSearchClist",method = RequestMethod.GET)
	public Map<String, Object> getSearchCont(SearchDto searchDto){
		if(searchDto.getSearchSort()==null || searchDto.getSort() ==null) {
			searchDto.setSearchSort("VIEWCOUNT");
			searchDto.setSort("DESC");
		}
		System.out.println("getSearchClist");
		System.out.println(searchDto.toString());
		Map<String, Object> map = searchService.getSearchCont(searchDto);
		System.out.println(map);
		
		return map;
	}
}
