package com.springboot.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="enabled")
	private int enabled;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable( 
		name="user_role",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="role_id")
			)
	private Set<Role> roles;
	
	@OneToMany(
		cascade= CascadeType.ALL,
		fetch=FetchType.LAZY,
		mappedBy="users"
			)
	private List<Post> posts = new ArrayList<>();
	
	
	@OneToMany(
		cascade=CascadeType.ALL,
		fetch=FetchType.LAZY,
		mappedBy="user"
			)
	private List<Comment> comments;
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinTable(
			name="user_message",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="message_id")
			)
	private List<Message> myMessage;
	
	
	@ManyToMany(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinTable(
			name="myinbox",
			joinColumns=@JoinColumn(name="sender_id"),
			inverseJoinColumns=@JoinColumn(name="receiver_id")
			)
	private Set<DoLong> myInbox;
	
	
	
	


	public Set<DoLong> getMyInbox() {
		return myInbox;
	}

	public void setMyInbox(Set<DoLong> myInbox) {
		this.myInbox = myInbox;
	}

	public List<Message> getMyMessage() {
		return myMessage;
	}

	public void setMyMessage(List<Message> myMessage) {
		this.myMessage = myMessage;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
