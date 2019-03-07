package rest;

import entity.Meeting;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/meeting")
public class MeetingService {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    private EntityManager manager = factory.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Meeting> getMeetings() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Meeting> meetings = new ArrayList<>(manager.createQuery("SELECT m FROM Meeting m").getResultList());
        tx.commit();
        manager.close();
        return meetings;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Meeting getMeeting(@PathParam("id") long id) {

    }

}
