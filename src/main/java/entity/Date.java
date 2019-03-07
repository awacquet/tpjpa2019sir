package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Date extends ChoiceType
{

    private long id;
    private int day;
    private int month;
    private int year;
    private boolean pause;

    public Date() {
    }

    public Date(int day, int month, int year, boolean pause) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.pause = pause;
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

    public int getDay()
    {
        return day;
    }

    public void setDay(int day)
    {
        this.day = day;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public boolean isPause()
    {
        return pause;
    }

    public void setPause(boolean pause)
    {
        this.pause = pause;
    }
}
