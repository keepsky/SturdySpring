package jpaexam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaexam");		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Product product = new Product();
			//product.setId(1L);
			product.setName("자동차");
			product.setPrice(2000);
			System.out.println("----1");
			em.persist(product); // goto persistence state
			System.out.println("----2");
			
			tx.commit();
			System.out.println("----3");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		em.close();
		emf.close();
	}

}
