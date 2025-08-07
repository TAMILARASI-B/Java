package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dto.Coupon;
import com.model.Product;
import com.repository.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	private ProductRepo repo;
	
	@Value("${couponService.url}")
	private String couponServiceURL;
	
	@Autowired
		private RestTemplate restTemplate;
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		
		Coupon coupon=restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
		System.out.println(coupon.getCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repo.save(product);
		
	}
	

}
