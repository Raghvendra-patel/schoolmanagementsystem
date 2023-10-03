package schoolmanagements.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class student 
{
	@Id
	private int id;
	private String name;
	private String dob;
	private long mno;
	private String email;
	private String password;
	@OneToMany(cascade= CascadeType.ALL)
	private List<assignment> assignments;
	@ManyToOne(cascade = CascadeType.ALL)
	private management managements;
	public List<assignment> getAssignments() {
		return assignments;
	}
	public void setAssignments(List<assignment> assignments) {
		this.assignments = assignments;
	}
	
	public management getManagements() {
		return managements;
	}
	public void setManagements(management managements) {
		this.managements = managements;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
