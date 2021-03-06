package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;

//@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceGatewayApplication {


	private static final Logger logger = LoggerFactory.getLogger(ServiceGatewayApplication.class);

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/baidu")
						.uri("http://baidu.com:80/")
				)
//				.route("websocket_route", r -> r.path("/apitopic1/**")
//						.uri("ws://127.0.0.1:6605"))
				.route(r -> r.path("/service-ribbon/**")
						.filters(f -> f.addResponseHeader("X-AnotherHeader", "testapi3"))

						.uri("lb://service-ribbon/")
				)
				.build();
	}




	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}
}
