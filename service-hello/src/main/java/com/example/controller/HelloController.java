package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Huangcz
 * @date 2018-11-20 16:40
 * @desc xxx
 */
@RestController
public class HelloController {

	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${server.port}")
	private String port;

	@PostMapping("/hello")
	public String hi(@RequestBody Map map) {
		return "Hi," + map.get("name") + ",I am from applicationName:" + applicationName + ",port:" + port;
	}


}
