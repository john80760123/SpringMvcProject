package tw.leonchen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Table(name="house")
@Component("house")//µ¹spring¬Ý±oµù¥Ubean
public class House {
	
	@Id @Column(name = "houseid")
	private int houseid;
	@Column(name = "housename")
	private String housename;
	 
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housemame) {
		this.housename = housemame;
	}
	
}
