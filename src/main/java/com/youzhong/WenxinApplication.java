package com.youzhong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.youzhong.dao")
public class WenxinApplication {

	public static void main(String[] args) {
		SpringApplication.run(WenxinApplication.class, args);
	}

}
