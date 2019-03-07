package servlet;

import entity.Date;
import entity.Survey;
import jpa.JpaTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//todo: gérer le cas du null
//todo: récupérer la bonne liste des votes
@WebServlet(name = "userinfo",
        urlPatterns = {"/SurveyInfo"})
public class SurveyInfo extends HttpServlet
{

    private JpaTest jpaLink;

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        jpaLink = new JpaTest(manager);
        Survey survey = jpaLink.getSurvey(Integer.parseInt(request.getParameter("id")));

        out.println("<HTML>\n<BODY>\n" +
                "<H1>Recapitulatif des informations</H1>\n" +
                "<UL>\n" +
                " <LI>Nom: "
                + survey.getMeeting().getSummary() + "\n" +
                " <LI>Lieu: "
                + survey.getMeeting().getLocation() + "\n" +
                " <LI>Date: "
                + survey.getMeeting().getDate() + "\n" +
                " <LI>Choix: ");
        for (Date adate : survey.getAvailableChoices())
        {
            out.println(
                    "<LI>jour: " + adate.getDay() + "\n" +
                            "</UL>\n" +
                            "<LI>Mois: " + adate.getMonth() + "\n" +
                            "</UL>\n" +
                            "<LI>Année: " + adate.getYear() + "\n" +
                            "</UL>\n");
        }


        out.println("</BODY></HTML>");
    }
}
