package aplicacao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Pessoa p = entityManager.find(Pessoa.class, 3);
		
		System.out.println(p);
		
		entityManagerFactory.close();
		entityManager.close();

	}

}
