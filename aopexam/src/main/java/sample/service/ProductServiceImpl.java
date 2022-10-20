package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sample.dao.ProductDao;
import sample.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public void addProduct(Product product) {
		System.out.println("## addProduct()");
		productDao.addProduct(product);
	}

	public Product findByProductName(String name) {
		System.out.println("## findByProductName()");
		return productDao.findProduct(name);
	}
}