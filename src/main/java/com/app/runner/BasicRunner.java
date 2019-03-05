package com.app.runner;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;

@Component
public class BasicRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		/************** SAVE OR UPDATE ************************/
		repo.save(new Product("PEN", 32.36,"V1"));
		repo.save(new Product("TABLE", 305.86,"V1"));
		repo.save(new Product("REMOTE", 500.36,"V1"));
		repo.save(new Product("PENCIL", 8.12,"V2"));
		repo.save(new Product("CAT", 18.12,"V2"));
		
		System.out.println("--save /update -- finish--");
		
		
		/************** COUNT and EXIST ************************/
		System.out.println("EXIST? :"+repo.existsById(2));
		System.out.println("COUNT :"+repo.count());
		
		/************** BASIC FIND METHODS ************************/
		Optional<Product> p=repo.findById(3);
		if(p.isPresent()) {
			System.out.println(p.get());
		}else {
			System.out.println("NO DATA FOUND");
		}
		
		repo.findAll().forEach(System.out::println);
		
		/************** DELETE ************************/
		/*
		 * repo.deleteById(3); //repo.deleteAll(); repo.deleteAllInBatch();
		 * 
		 * System.out.println("--delete -- finished");
		 */
		
		System.exit(0);
	}

}
