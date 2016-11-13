package br.com.sematec.financas.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sematec.financas.modelo.Conta;

public class TesteJPA {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Maria dos Santos");
		conta.setBanco("Caixa");
		conta.setAgencia("043");
		conta.setNumero("54321");

		/**
		 * Usando MySQL
		 */
		persist(conta, Persistence.createEntityManagerFactory("contas-mysql"));

		/**
		 * Usando PostgreSQL
		 */
		persist(conta, Persistence.createEntityManagerFactory("contas-postgres"));
	}

	private static void persist(Conta conta, EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();
	}
}
