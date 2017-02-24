package com.ibm.bookstore.model;

import com.ibm.bookstore.model.User;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Book
 *
 */
@Entity
@Table(name="BOOKS")
public class Book implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID;
	@Column(nullable=false)
	private String Title;
	@ManyToOne(cascade={CascadeType.REMOVE})
	@JoinColumn(name="OWNER_ID")
	private User Owner;
	private static final long serialVersionUID = 1L;

	public Book() {
		super();
	}   
	
	public Integer getID() {
		return this.ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}   
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}   
	public User getOwner() {
		return this.Owner;
	}

	public void setOwner(User Owner) {
		this.Owner = Owner;
	}
   
}
