package com.insta.instagram.model;

import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import com.insta.instagram.dto.UserDTO;

@Entity
@Table(name = "Stories")
public class Story {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "id", column = @Column(name="user_id")),
		@AttributeOverride(name = "email", column = @Column(name="user_email"))
	})
	private UserDTO user;
	
	@NotNull
	private String image;
	
	private String caption;
	
	private LocalDateTime timeestamp;
	
	

	public Story() {
		// TODO Auto-generated constructor stub
	}

	public Story(Integer id, UserDTO user, String image, String caption, LocalDateTime timeestamp) {
		super();
		this.id = id;
		this.user = user;
		this.image = image;
		this.caption = caption;
		this.timeestamp = timeestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public LocalDateTime getTimeestamp() {
		return timeestamp;
	}

	public void setTimeestamp(LocalDateTime timeestamp) {
		this.timeestamp = timeestamp;
	}
			
}
