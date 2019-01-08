package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Huangcz
 * @date 2018-11-21 12:39
 * @desc xxx
 */
@Service
public class HiService {


	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(String name) {
		return restTemplate.getForObject("http://SERVICE-HI:8762/hi?name=" + name, String.class);
	}


	public String hiError(String name) {
		return "hi," + name + "! Sorry very much!";
	}


}
