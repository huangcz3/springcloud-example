package com.example.controller;

import com.example.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangcz
 * @date 2018-11-21 12:39
 * @desc xxx
 */
@RestController
public class HiController {


	@Autowired
	private HiService hiService;


	@GetMapping("/hi")
	public String hi(@RequestParam String name){
		return hiService.hi(name);
	}








}
