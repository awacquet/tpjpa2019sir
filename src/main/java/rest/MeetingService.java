package rest;

import entity.Meeting;

import javax.persistence.*;
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
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        String query = "SELECT m FROM Meeting m WHERE m.id=:id";
        Meeting meeting = null;
        try {
            meeting = (Meeting) manager.createQuery(query).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            meeting = new Meeting();
        }
        tx.commit();
        manager.close();
        return meeting;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/user/{id}")
    public Collection<Meeting> getUserParticipation(@PathParam("id") long id) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        String query = "SELECT u.meetings FROM User u WHERE u.id = :id";
        List<Meeting> meetings = new ArrayList<>(manager.createQuery(query).setParameter("id", id).getResultList());
        tx.commit();
        manager.close();
        return meetings;
    }

}
