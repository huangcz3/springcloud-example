package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Huangcz
 * @date 2018-11-20 17:04
 * @desc xxx
 */
@Service
public class HelloService {

	@Autowired
	private RestTemplate restTemplate;

	public String hiService(String name) {


		return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
	}







}
