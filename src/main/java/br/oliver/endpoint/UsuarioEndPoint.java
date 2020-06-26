package br.oliver.endpoint;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.oliver.dao.UsuarioDao;
import br.oliver.entity.Usuario;

@Path("/usuarios")
public class UsuarioEndPoint {

	@Inject
	UsuarioDao dao;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam(value = "id") long id) {
		return Response.ok().entity(dao.getUsuario(id)).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodosUsuarios() {
		List<Usuario> todosUsuarios = dao.getTodosUsuarios().stream()
				.sorted((s1, s2) -> s1.getNome().compareTo(s2.getNome()))
				.collect(Collectors.toList());
		return Response.status(Response.Status.OK).entity(todosUsuarios).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUsuario(Usuario usuario) {
		usuario = dao.addUsuario(usuario);
		URI location = null;
		try {
			location = new URI("/usuarios/" + usuario.getId());
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
			return Response.ok().entity(usuario).build();
		}
		return Response.created(location).entity(usuario).build();
	}

}
