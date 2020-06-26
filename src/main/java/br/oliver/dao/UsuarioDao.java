package br.oliver.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.oliver.entity.Usuario;

public class UsuarioDao {

	@Inject
	private EntityManager entityManager;


	public Usuario getUsuario(long id) {
		return entityManager.find(Usuario.class, id);
	}

	public List<Usuario> getTodosUsuarios() {
		return entityManager.createQuery("from Usuario", Usuario.class).getResultList();
	}


	public Usuario addUsuario(Usuario usuario) {

		entityManager.getTransaction().begin();
		entityManager.persist(usuario);
		entityManager.getTransaction().commit();

		return usuario;

	}

}
