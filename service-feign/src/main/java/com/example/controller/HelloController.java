package com.example.controller;

import com.example.fegin.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Huangcz
 * @date 2018-11-21 11:54
 * @desc xxx
 */
@RestController
public class HelloController {


	@Autowired
	private HelloFeign helloFeign;

	@PostMapping("/hello")
	public String hello(@RequestBody Map map){
		return helloFeign.hello(map);
	}

}
