package br.oliver.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.hk2.api.Factory;

public class EntityManagerProducer implements Factory<EntityManager>{
	private  EntityManagerFactory factory;
	
	@Override
	public EntityManager provide() {
		System.out.println("Create EntityManager");
		this.factory = Persistence.createEntityManagerFactory("usuarioapi");
		return this.factory.createEntityManager();
	}

	@Override
	public void dispose(EntityManager manager) {
		System.out.println("Close EntityManager");
		manager.close();
	}
}
