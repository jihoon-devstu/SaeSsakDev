package com.example.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(modifyOnCreate = true)  // JPA가 날짜 / 시간 조작할 수 있도록 허용 (@CreatedDate, @LastModifiedDate)
public class Ex09SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex09SpringDataJpaApplication.class, args);
	}

}
