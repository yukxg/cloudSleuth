package com.yukxg.Ode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class OdeApplication {
    @Autowired
    private RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(OdeApplication.class, args);
	}

	private static final Logger LOG = LoggerFactory.getLogger(OdeApplication.class);


    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

	@RequestMapping("/hi")
    public String home() {
	    LOG.info("ode's hi is being called");
	    return "hi this is Ode";
    }

    @RequestMapping("/ode")
    public String info() {
	    LOG.info("info is being called");
	    return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }
}
