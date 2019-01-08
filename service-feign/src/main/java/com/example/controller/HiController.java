package com.example.controller;

import com.example.fegin.HiFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huangcz
 * @date 2018-11-20 17:52
 * @desc xxx
 */
@RestController
public class HiController {

	@Autowired
	private HiFeign hiFeign;

	@GetMapping("/hi")
	public String sayHi( String name){
		return hiFeign.hello(name);
	}

}
