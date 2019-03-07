package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;

public interface ProductRepoNew extends JpaRepository<Product, Integer> {

	@Query("select p.prodCode,p.prodCost from Product p where p.prodId=:pid")
	Object getMyData(Integer pid);
	
	@Modifying
	@Transactional
	@Query("delete from Product p where p.prodId=?1")
	void deleteMyData(Integer pid);
	
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
