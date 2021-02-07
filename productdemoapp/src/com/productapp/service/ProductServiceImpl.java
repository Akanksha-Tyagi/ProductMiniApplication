package com.productapp.service;

import java.util.List;

import com.productapp.product.Product;
import com.productapp.product.ProductDao;
import com.productapp.product.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	public ProductServiceImpl() {
		this.productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> allProduct() {

		return productDao.allProduct();
	}

	@Override
	public Product addProduct(Product product) {

		return productDao.addProduct(product);
	}

	@Override
	public Product deleteProduct(int productId, String productName) {

		return productDao.deleteProduct(productId, productName);
	}

	@Override
	public Product updateProduct(int productId, int price, int quantity) {

		return productDao.updateProduct(productId, price, quantity);
	}

	@Override
	public Product getProductById(int productId) {

		return productDao.getProductById(productId);
	}

}
