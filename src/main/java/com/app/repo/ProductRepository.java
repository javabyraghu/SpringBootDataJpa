package com.app.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//-------------Restrictions---------------
	List<Product> findByVendorCode(String code);
	
	List<Product> findByProdCost(double cost);
	List<Product> findByProdCostGreaterThan(double cost);
	
	Product findByProdCode(String code);
	List<Product> findByProdCodeLike(String code);
	List<Product> findByProdCodeIn(Collection<String> codes);
	
	List<Product> findByProdCodeOrVendorCode(String pc,String vc);
	
	List<Product> findByProdIdBetween(Integer v1,Integer v2);
	
	
}
