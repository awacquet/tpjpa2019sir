package metier;

import javax.persistence.*;
import java.util.List;

@Entity
public class Meeting
{

    private long id;
    private String title;
    private String summary;
    private String accessCode;
    private Date date;
    private Location location;

    private List<User> attendees;

    @Id
    @GeneratedValue
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSummary()
    {
        return summary;
    }

    public void setSummary(String summary)
    {
        this.summary = summary;
    }

    public String getAccessCode()
    {
        return accessCode;
    }

    public void setAccessCode(String accessCode)
    {
        this.accessCode = accessCode;
    }

    @OneToOne
    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    public List<User> getAttendees()
    {
        return attendees;
    }

    public void setAttendees(List<User> attendees)
    {
        this.attendees = attendees;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    @OneToOne
    public Location getLocation()
    {
        return location;
    }
}
