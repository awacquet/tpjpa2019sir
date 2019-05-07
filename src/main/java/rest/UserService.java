package rest;

import entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/User")
public class UserService
{

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    EntityManager manager = factory.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getUsers() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<User> users = new ArrayList<>(manager.createQuery("SELECT u FROM User u").getResultList());
        tx.commit();
        manager.close();
        return users;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public User GetUser(@PathParam("id") long id)
    {
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
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        User user;
        manager.persist(user = new User(name, firstname, email));
        tx.commit();
        return user;
    }
}