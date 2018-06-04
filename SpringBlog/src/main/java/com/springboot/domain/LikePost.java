package com.springboot.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="likepost")
public class LikePost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="post_state")
	private int postState;
	@Column(name="user_id")
	private long userId;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinColumn(name="post_id")
	private Post posts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostState() {
		return postState;
	}

	public void setPostState(int postState) {
		this.postState = postState;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Post getPosts() {
		return posts;
	}

	public void setPosts(Post posts) {
		this.posts = posts;
	}
	
	
	
	
	
	
	
}
