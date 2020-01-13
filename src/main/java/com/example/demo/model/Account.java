package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class Account {   

    @Id
    private String id;

    private String username;
    private String password;    
    private Set<Bookmark> bookmarkSet = new HashSet<>();
	public Set<Bookmark> getBookmarkSet() {
		return bookmarkSet;
	}
	public void setBookmarkSet(Set<Bookmark> bookmarkSet) {
		this.bookmarkSet = bookmarkSet;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}    
}