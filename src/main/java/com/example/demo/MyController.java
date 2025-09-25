package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {
		@GetMapping("/{id}")
		public Combine show(@PathVariable int id) {
			RestTemplate template=CombineServiceApplication.getRestTemplate();
			Product p=template.getForObject("https://ciran12481.pythonanywhere.com/product/"+id, Product.class);
			Customer ce=template.getForObject("https://customerservice-7zw8.onrender.com/"+id, Customer.class);
			Combine c=new Combine();
			c.setProduct(p);
			c.setCustomer(ce);
			return c;
		}
}
