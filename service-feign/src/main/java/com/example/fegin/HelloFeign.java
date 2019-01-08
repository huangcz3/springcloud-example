package com.example.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author Huangcz
 * @date 2018-11-21 11:50
 * @desc xxx
 */
@FeignClient("service-hello")
public interface HelloFeign {

	@PostMapping("/hello")
	String hello(@RequestBody Map map);


}
