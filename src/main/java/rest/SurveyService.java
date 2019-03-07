package rest;

import entity.Meeting;
import entity.Survey;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Path("/survey")
public class SurveyService {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
    private EntityManager manager = factory.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Survey> getSurveys() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        List<Survey> surveys = new ArrayList<>(manager.createQuery("SELECT s FROM Survey s").getResultList());
        tx.commit();
        manager.close();
        return surveys;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Survey getSurvey(@PathParam("id") long id) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        String query = "SELECT s FROM Survey s WHERE s.id=:id";
        Survey s = null;
        try {
            s = (Survey) manager.createQuery(query).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            s = new Survey(new Meeting(), null);
        }
        manager.close();
        tx.commit();
        return s;
    }

}
