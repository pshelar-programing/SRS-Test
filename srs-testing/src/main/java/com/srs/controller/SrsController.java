package com.srs.controller;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srs.pojo.SrsInputBean;
import com.srs.service.SrsService;

@RestController
public class SrsController {
	
	private SrsService service;
	
	
	@RequestMapping("/")
	public String hello() {
		return "Hello SRS";
	}
	
	@PostMapping(value = "/srs/post", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SrsInputBean> postSRSTest(@RequestBody SrsInputBean input){
		service = new SrsService();
		SrsInputBean output = service.getData(input);
		
		return new ResponseEntity<SrsInputBean>(output, HttpStatus.OK);
		
	}

}
