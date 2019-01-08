package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangcz
 * @date 2018-11-20 16:40
 * @desc xxx
 */
@RestController
public class HiController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String port;


	@GetMapping("hi")
	public String hi(@RequestParam String name) {
		return "Hi," + name + ",I am from applicationName:" + applicationName + ",port:" + port;
	}


}
