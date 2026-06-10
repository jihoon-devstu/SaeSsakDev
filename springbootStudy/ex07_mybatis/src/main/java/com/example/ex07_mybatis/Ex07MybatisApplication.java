package com.example.ex07_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.ex07_mybatis.mapper")
public class Ex07MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex07MybatisApplication.class, args);
	}

}
