package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location extends ChoiceType
{
    long id;
    String adress;
    String city;

    public Location() {
    }

    public Location(String adress, String city) {
        this.adress = adress;
        this.city = city;
    }

    @Id @GeneratedValue
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getAdress()
    {
        return adress;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }
}
