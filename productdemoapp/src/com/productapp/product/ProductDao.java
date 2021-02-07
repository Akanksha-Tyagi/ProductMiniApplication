package com.productapp.product;

import java.util.*;

public interface ProductDao {
	public List<Product> allProduct();

	public Product addProduct(Product product);

	public Product deleteProduct(int productId, String productName);

	public Product updateProduct(int productId, int price, int quantity);

	public Product getProductById(int productId);
}
