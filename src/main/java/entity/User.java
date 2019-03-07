package entity;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

	private Long id;
	private String name;
	private String firstName;
	private String mail;
	private List<Meeting> meetings = new ArrayList<>();

	public User() {
	}

	public User(String name, String firstName, String mail) {
		this.name = name;
		this.firstName = firstName;
		this.mail = mail;
	}

	@Id
	@GeneratedValue
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getMail()
	{
		return mail;
	}

	public void setMail(String mail)
	{
		this.mail = mail;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "attendees", cascade = CascadeType.PERSIST)
	public List<Meeting> getMeetings()
	{
		return meetings;
	}

	public void setMeetings(List<Meeting> meetings)
	{
		this.meetings = meetings;
	}
}
