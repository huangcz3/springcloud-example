package com.example.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Huangcz
 * @date 2018-11-20 17:49
 * @desc xxx
 */
@FeignClient(value = "service-hi", fallback = HiFeignHystric.class)
public interface HiFeign {

	@GetMapping(value = "/hi")
	String hello(@RequestParam(value = "name") String name);
}
