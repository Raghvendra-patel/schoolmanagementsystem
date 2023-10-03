package schoolmanagements.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class management 
{
	@Id
	private int id;
	private String email;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	List<student> students;
	@OneToMany(cascade = CascadeType.ALL)
	List<teacher> teachers;
	public List<student> getStudents() {
		return students;
	}
	public void setStudents(List<student> students) {
		this.students = students;
	}
	public List<teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<teacher> teachers) {
		this.teachers = teachers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
