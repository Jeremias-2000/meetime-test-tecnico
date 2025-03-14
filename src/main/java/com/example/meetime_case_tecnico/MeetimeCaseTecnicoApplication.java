package com.example.meetime_case_tecnico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MeetimeCaseTecnicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetimeCaseTecnicoApplication.class, args);
	}

}
