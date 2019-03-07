package entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Survey {

    private long id;
    private Meeting meeting;
    private List<Date> availableChoices;

    public Survey() {
    }

    public Survey(Meeting meeting, List<Date> availableChoices) {
        this.meeting = meeting;
        this.availableChoices = availableChoices;
    }

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

    @ManyToOne
    public Meeting getMeeting()
    {
        return meeting;
    }

    public void setMeeting(Meeting meeting)
    {
        this.meeting = meeting;
    }

    @OneToMany(fetch=FetchType.EAGER)
    public List<Date> getAvailableChoices()
    {
        return availableChoices;
    }

    public void setAvailableChoices(List<Date> availableChoices)
    {
        this.availableChoices = availableChoices;
    }
}
