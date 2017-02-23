package com.ibm.bookstore.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(unique= true, nullable= false)
	private Integer ID;
	@Column(nullable= false)
	private String Email;
	@Column(nullable= false)
	private String Password;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
	@Override
	public String toString() {
		return "User [ID=" + ID + ", Email=" + Email + ", Password=" + Password + "]";
	}
	
	
   
}
