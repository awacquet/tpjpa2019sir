package fr.istic.sir.rest;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/User")
public class UserService
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User GetUser(@PathParam("id") long id)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        String query = "SELECT u FROM User u WHERE u.id = :id";
        List<User> users = manager.createQuery(query, User.class).setParameter("id", id).getResultList();
        return users.size() == 1 ? users.get(0) : null;
    }

    //TODO: corriger le bug de null
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add")
    public User AddUser(@FormParam("name") String name, @FormParam("firstname") String firstname, @FormParam("email") String email)
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        User user;
        manager.persist(user = new User(name, firstname, email));
        tx.commit();
        return user;
    }
}