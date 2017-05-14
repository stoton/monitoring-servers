package com.github.stoton.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
public class MonitoringServersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringServersApplication.class, args);
	}
}
