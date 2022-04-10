package jpabook.jpashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Component Scan을 하여 Spring Bean에 모두 등록
public class JpashopApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpashopApplication.class, args);
	}
}
