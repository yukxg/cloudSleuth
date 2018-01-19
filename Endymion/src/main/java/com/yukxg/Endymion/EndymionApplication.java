package com.yukxg.Endymion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class EndymionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EndymionApplication.class, args);
	}

	private static final Logger LOG = LoggerFactory.getLogger(EndymionApplication.class);

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public AlwaysSampler defaultSampler(){
		return new AlwaysSampler();
	}

	@RequestMapping("/hi")
	public String callHome() {
		LOG.info("calling trace Endymion");
		return restTemplate.getForObject("http://localhost:8989/ode", String.class);
	}

	@RequestMapping("/info")
	public String info() {
		LOG.info("calling trace Endymion");
		return "this is Endymion";
	}
}
