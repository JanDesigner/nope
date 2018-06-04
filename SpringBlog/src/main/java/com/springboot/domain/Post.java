package com.springboot.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="userpost")
public class Post {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="date")
	private Date curDate;
	@Column(name="content")
	private String content;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User users;
	
	@OneToMany(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE},
			mappedBy="posts",fetch=FetchType.LAZY)
	private List<LikePost> likes;
	
	
	@OneToMany( cascade=CascadeType.ALL , fetch=FetchType.LAZY ,
				mappedBy="post" )
	private List<Comment> comments;
	
	
	
	@Column(name="count_likes")
	private int CountLikes;
		
	
	
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getCountLikes() {
		return CountLikes;	
	}

	public void setCountLikes(int countLikes) {
		CountLikes = countLikes;
	}

	public List<LikePost> getLikes() {
		return likes;
	}

	public void setLikes(List<LikePost> likes) {
		this.likes = likes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCurDate() {
		return curDate;
	}

	public void setCurDate(Date curDate) {
		this.curDate = curDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	
	
	
}
