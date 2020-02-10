package com.test.TestExample;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("getRes")
public class AlienResource1 {
	AlienRipository ripo=new AlienRipository();
	
	// Getting aliens
	@GET
	@Path("aliens")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Alien> getAliens() {
		return(ripo.getAliens());
	}
	
	// Getting a particular alien
	@GET
	@Path("alien/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alien getAlien(@PathParam("id") int id) {
		return(ripo.getAlien(id));
	}
	
	// Adding an alien
	@POST
	@Path("addAlien")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Alien addAlien(Alien a) {
		ripo.insertAlien(a);
		return(a);
	}
	
	// Deleting an alien
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAlien(@PathParam("id") int id) {
		return(ripo.delete(id));
	}
	
	// Updating an alien
	@PUT
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAlien(Alien alien) {
		return(ripo.update(alien));
	}
	
	@GET
	@Path("pathparam/{name}/{id}/{points}")
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAlienThroughPathparam(@PathParam("name") String name,
			@PathParam("id") int id,
			@PathParam("points") int points) {
		Alien alien=new Alien();
		alien.setName(name);
		alien.setId(id);
		alien.setPoints(points);
		ripo.insertAlien(alien);
		return("Success");
	}
	
	@GET
	@Path("queryparam")
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAlienThroughQathParam(@QueryParam("name") String name,
			@QueryParam("id") int id,
			@QueryParam("points") int points) {
		Alien alien=new Alien();
		alien.setName(name);
		alien.setId(id);
		alien.setPoints(points);
		ripo.insertAlien(alien);
		return("Success");
	}
	
	@GET
	@Path("matrixparam")
	@Produces(MediaType.TEXT_PLAIN)
	public String insertAlienThroughMatrixParam(@MatrixParam("name") String name,
			@MatrixParam("id") int id,
			@MatrixParam("points") int points) {
		Alien alien=new Alien();
		alien.setName(name);
		alien.setId(id);
		alien.setPoints(points);
		ripo.insertAlien(alien);
		return("Success");
	}
}
