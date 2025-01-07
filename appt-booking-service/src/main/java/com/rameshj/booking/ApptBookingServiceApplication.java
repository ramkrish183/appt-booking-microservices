package com.rameshj.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApptBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptBookingServiceApplication.class, args);
	}

}
