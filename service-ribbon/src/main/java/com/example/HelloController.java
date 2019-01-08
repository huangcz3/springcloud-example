package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangcz
 * @date 2018-11-20 17:08
 * @desc xxx
 */
@RestController
public class HelloController {

	@Autowired
	private HelloService helloService;

	@GetMapping("/hi")
	public String hi(@RequestParam String name){
		return helloService.hiService(name);
	}



}
