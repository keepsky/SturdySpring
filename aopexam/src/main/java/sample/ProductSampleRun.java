package sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.config.AppConfig;
import sample.domain.Product;
import sample.service.ProductService;

public class ProductSampleRun {

	public static void main(String[] args) {
		
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ProductService productService = ctx.getBean(ProductService.class);
		
		productService.addProduct(new Product("핸드폰", 10000));
		
		Product product = productService.findByProductName("핸드폰");

		productService.addProduct(new Product("컴퓨터", 20000));

	}

}
