package com.productapp.service;

import java.util.List;

import com.productapp.product.Product;

public interface ProductService {
	public List<Product> allProduct();

	public Product addProduct(Product product);

	public Product deleteProduct(int productId, String productName);

	public Product updateProduct(int productId, int price, int quantity);

	public Product getProductById(int productId);
}
