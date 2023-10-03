package schoolmanagements.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class assignment 
{
	@Id
	private int aid;
	private String aname;
	private int amarks;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getAmarks() {
		return amarks;
	}
	public void setAmarks(int amarks) {
		this.amarks = amarks;
	}
	
}
