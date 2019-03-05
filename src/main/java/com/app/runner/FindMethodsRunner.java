package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class FindMethodsRunner implements CommandLineRunner {
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.findAll().forEach(System.out::println);
		System.out.println("/*****************************/");
		Product p=new Product();
		p.setVendorCode("V1");
		Example<Product> e=Example.of(p);
		repo.findAll(e).forEach(System.out::println);
		
		System.out.println("/*****************************/");
		repo.findAll(Sort.by(Direction.DESC,"prodCost"))
		.forEach(System.out::println);
		
		System.out.println("/*****************************/");
		repo.findAll(PageRequest.of(4, 3))
		.forEach(System.out::println);
		
		System.out.println("/*****************************/");
		repo.findAll(e, PageRequest.of(0, 3))
		.forEach(System.out::println);
		
		System.out.println("/*****************************/");
		repo.findAll(e, Sort.by("prodCode"))
		.forEach(System.out::println);

		
		System.exit(0);
	}

}
