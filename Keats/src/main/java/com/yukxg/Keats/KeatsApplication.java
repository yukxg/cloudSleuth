package com.yukxg.Keats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class KeatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeatsApplication.class, args);
	}
}
