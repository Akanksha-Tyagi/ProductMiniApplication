package com.productapp.product;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.productapp.product.Product;
import com.productapp.dao.ConnectionFactory;
import com.productapp.dao.DataAccessException;
import com.productapp.dao.ProductNotFoundException;

public class ProductDaoImpl implements ProductDao {

	private Connection connection;

	public ProductDaoImpl() {
		this.connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Product> allProduct() {
		List<Product> allProductList = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement("Select * from product");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				allProductList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"),
						rs.getInt("qty"), rs.getDate("manfdate"), rs.getDate("inspecteddate")));
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}

		return allProductList;
	}

	@Override
	public Product addProduct(Product product) {
		System.out.println("in dao addProduct");

		try {
			PreparedStatement pstmt = connection.prepareStatement(
					" insert into product(name, price,qty,manfdate,inspecteddate) values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQuantity());
			pstmt.setDate(4, new java.sql.Date(product.getMandate().getTime()));
			pstmt.setDate(5, new java.sql.Date(product.getInsdob().getTime()));

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				product.setId(rs.getInt(1));
			}

		} catch (SQLException ex) {
			throw new DataAccessException(ex.getCause().toString());
		}

		return product;
	}

	@Override
	public Product deleteProduct(int productId, String productName) {

		System.out.println("in dao deleteProduct");
		Product product = getProductById(productId);
		System.out.println("dao  object" + product);
		if (product != null) {
			try {
				PreparedStatement pstmt = connection.prepareStatement("delete from product where id=? and name=?");
				pstmt.setInt(1, productId);
				pstmt.setString(2, productName);
				System.out.println("dao pstmt " + pstmt);

				pstmt.executeUpdate();

			} catch (SQLException ex) {
				throw new ProductNotFoundException(ex.getCause().toString());
			}
		}

		return product;
	}

	@Override
	public Product updateProduct(int productId, int price, int quantity) {

		System.out.println("in dao updateProduct");
		Product product = getProductById(productId);
		System.out.println("update dao  object" + product);
		if (product != null) {
			try {
				PreparedStatement pstmt = connection.prepareStatement("update product set price=?, qty =? where id=?");
				pstmt.setInt(1, price);
				pstmt.setInt(2, quantity);
				pstmt.setInt(3, productId);
				System.out.println("update dao pstmt " + pstmt);

				pstmt.executeUpdate();

			} catch (SQLException ex) {
				throw new ProductNotFoundException(ex.getCause().toString());
			}
		}

		return product;
	}

	@Override
	public Product getProductById(int productId) {

		Product product = null;
		System.out.println("in dao getProductById");

		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from product where id=? ");
			pstmt.setInt(1, productId);

			System.out.println("getby id pstmt " + pstmt);

			ResultSet rs = pstmt.executeQuery();
			System.out.println("getby id rs " + rs);
			if (rs.next()) {
				product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"), rs.getInt("qty"),
						rs.getDate("manfdate"), rs.getDate("inspecteddate"));
				System.out.println("getby id if product " + product);
			}

		} catch (SQLException ex) {
			throw new ProductNotFoundException(ex.getCause().toString());
		}

		return product;
	}

}
