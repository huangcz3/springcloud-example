package com.example.fegin;

import org.springframework.stereotype.Component;

/**
 * @author Huangcz
 * @date 2018-11-21 13:36
 * @desc xxx
 */
@Component
public class HiFeignHystric implements HiFeign {

	@Override
	public String hello(String name) {
		return "sorry! " + name + "!";
	}
}
