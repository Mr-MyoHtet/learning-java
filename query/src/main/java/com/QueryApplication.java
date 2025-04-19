package com;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
// @ComponentScan(basePackages = "com.query.repo.jpql")
// @ComponentScan(basePackages = "com.query.repo.criteria")
public class QueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

}
