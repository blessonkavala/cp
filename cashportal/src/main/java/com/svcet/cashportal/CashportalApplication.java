package com.svcet.cashportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.ExpiringSession;

@SpringBootApplication
public class CashportalApplication<S extends ExpiringSession> {

	public static void main(String[] args) {
		SpringApplication.run(CashportalApplication.class, args);
	}

}
