package jpa;

import entity.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class JpaTest
{

    private EntityManager manager;
    private User timedUser = new User("Dupont", "Corentin", "cdupont@test.fr");
    private List<User> timedUserList = new ArrayList<>();
    private Date timedDate = new Date(10, 6, 2018, true);
    private List<Date> timedDateList = new ArrayList<>();
    private Location timedLocation = new Location("25 Rue de Saint-Brieuc", "Pordic");
    private List<Meeting> timedMeetingList = new ArrayList<>();

    public JpaTest(EntityManager manager)
    {
        this.manager = manager;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try
        {
            test.createUser();
            test.createLocation();
            test.createDate();
            test.createMeeting();
            test.createSurvey();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        tx.commit();

        System.out.println("nombre de user trouvé :" + test.getUser("dupon%").size());
        manager.close();
        System.out.println(".. done");
    }

    private void createUser()
    {
        int numOfUsers = manager.createQuery("SELECT u FROM User u", User.class).getResultList().size();
        if (numOfUsers == 0)
        {
            manager.persist(timedUser);
            User temp = new User("Dupond", "Lucien", "cdupont@test.fr");
            User temp2 = new User("Dupomp", "Mick", "cdupont@test.fr");
            User temp3 = new User("Dupon", "Arthur", "cdupont@test.fr");
            timedUserList.add(timedUser);
            timedUserList.add(temp);
            timedUserList.add(temp2);
            timedUserList.add(temp3);
            manager.persist(temp);
            manager.persist(temp2);
            manager.persist(temp3);
        }
    }

    private void createLocation()
    {
        int numOfLoc = manager.createQuery("SELECT l FROM Location l", Location.class).getResultList().size();
        if (numOfLoc == 0)
        {
            manager.persist(timedLocation);
            manager.persist(new Location("14 Rue de Tréméloir", "Paris"));
            manager.persist(new Location("6 Rue de Cesson", "Rennes"));
            manager.persist(new Location("34 Rue de Rennes", "Cesson-Sévigné"));
        }
    }

    private void createDate()
    {
        int numOfDates = manager.createQuery("SELECT d FROM Date d", Date.class).getResultList().size();
        if (numOfDates == 0)
        {
            Date d2 = new Date(17, 10, 2018, false);
            Date d3 = new Date(8, 11, 2018, true);
            Date d4 = new Date(25, 3, 2018, false);
            manager.persist(timedDate);
            manager.persist(d2);
            manager.persist(d3);
            manager.persist(d4);
            timedDateList.add(timedDate);
            timedDateList.add(d2);
            timedDateList.add(d3);
            timedDateList.add(d4);
        }
    }

    private void createMeeting()
    {
        int numOfMeets = manager.createQuery("SELECT m FROM Meeting m", Meeting.class).getResultList().size();
        if (numOfMeets == 0)
        {
            Meeting m1 = new Meeting("1ere Reunion", "Reunion de test", "3535", timedDate, timedLocation, timedUserList);
            Meeting m2 = new Meeting("2eme Reunion", "Reunion de lancement", "2222", timedDate, timedLocation, timedUserList);
            Meeting m3 = new Meeting("Grande Reunion", "Reunion visant à présenter les futurs produits", "2929", timedDate, timedLocation, timedUserList);
            Meeting m4 = new Meeting("3eme Reunion", "Reunion de post-lancement", "5656", timedDate, timedLocation, timedUserList);
            manager.persist(m1);
            manager.persist(m2);
            manager.persist(m3);
            manager.persist(m4);
            timedMeetingList.add(m1);
            timedMeetingList.add(m2);
            timedMeetingList.add(m3);
            timedMeetingList.add(m4);
        }
    }

    private void createSurvey()
    {
        int numOfSurv = manager.createQuery("SELECT s FROM Survey s", Survey.class).getResultList().size();
        if (numOfSurv == 0)
        {
            List<Date> l1 = new ArrayList<>();
            List<Date> l2 = new ArrayList<>();
            l1.add(timedDateList.get(0));
            l1.add(timedDateList.get(1));
            l2.add(timedDateList.get(2));
            l2.add(timedDateList.get(3));
            manager.persist(new Survey(timedMeetingList.get(0), l1));
            manager.persist(new Survey(timedMeetingList.get(1), l2));
        }
    }

    public void createUser(String name, String firstname, String email)
    {
        manager.persist(new User(name, firstname, email));
    }

    private List<User> getUser(String name)
    {
        String query = "SELECT u FROM User u WHERE u.name LIKE :name";
        return manager.createQuery(query, User.class).setParameter("name", name).getResultList();
    }

    public List<User> getUser()
    {
        String query = "SELECT u FROM User u";
        return manager.createQuery(query, User.class).getResultList();
    }

    public List<Survey> getSurveyList()
    {
        String query = "SELECT s FROM Survey s";
        return manager.createQuery(query, Survey.class).getResultList();
    }

    public Survey getSurvey(int id)
    {
        String query = "SELECT s FROM Survey s WHERE s.id = :id";
        return manager.createQuery(query, Survey.class).setParameter("id", id).getSingleResult();
    }
}
