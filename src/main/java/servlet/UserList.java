package servlet;

import entity.User;
import jpa.JpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "userlist",
        urlPatterns = {"/UserList"})
public class UserList extends HttpServlet
{
    private JpaTest jpaLink;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        jpaLink = new JpaTest(manager);
        List<User> users = jpaLink.getUser();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<HTML>\n<BODY>\n" +
                "<H1>Liste des utilisateurs</H1>\n");
        for (User unUser : users)
        {
            out.println("<UL>\n" +
                    " <LI>Nom: " + unUser.getName() + "\n" +
                    " <LI>Prenom: " + unUser.getFirstName() + "\n" +
                    " <LI>Mail: " + unUser.getMail() + "\n" +
                    "</UL>\n");
        }
        out.println("</BODY></HTML>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(new User(req.getParameter("name"), req.getParameter("firstname"), req.getParameter("email")));
        tx.commit();
        PrintWriter out = resp.getWriter();
        out.println("<HTML><BODY> OK c'est fait : " +
                req.getParameter("name") + " " +  req.getParameter("firstname") + " - " + req.getParameter("email") +
                "</BODY></HTML>");
    }
}