package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepository;

@Component
public class QueryMethodsTest implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.findByProdIdBetween(2,4)
		.forEach(System.out::println);
		
		System.exit(0);
	}

}
