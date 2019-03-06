package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepoNew extends JpaRepository<Product, Integer> {

	// ******** PROJECTIONS ***********//
	interface ProductOne{
		String getProdCode();
		Double getProdCost();
	}
	interface ProductTwo{
		String getProdCode();
		String getVendorCode();
		Double getProdCost();
	}
	
	interface ProductThree{
		Double getProdCost();
	}

	List<ProductOne> findByVendorCode(String vendorCode);
	<T> List<T>  findByProdCodeLike(String prodCode,Class<T> clz);
	
	
}
