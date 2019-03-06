package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.repo.ProductRepoNew;

@Component
public class QueryMethodsTest implements CommandLineRunner {
	@Autowired
	private ProductRepoNew repo;

	@Override
	public void run(String... args) throws Exception {
		repo.findByProdCodeLike("%P%",ProductRepoNew.ProductThree.class)
		.stream()
		.map((ob)->ob.getProdCost())
		.forEach(System.out::println);


		System.exit(0);
	}

}
