package br.oliver.config;

import javax.persistence.EntityManager;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import br.oliver.dao.UsuarioDao;

public class ApplicationBinder extends AbstractBinder{

	@Override
	protected void configure() {
//		bind(UsuarioDao.class).to(UsuarioDao.class);
		bindAsContract(UsuarioDao.class);
		bindFactory(EntityManagerProducer.class)
        .to(EntityManager.class)
        .in(RequestScoped.class);
	}

}
