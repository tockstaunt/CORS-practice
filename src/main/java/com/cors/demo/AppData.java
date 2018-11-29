package com.cors.demo;

import javax.persistence.*;

@Entity
public class AppData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String postableValue;
	
		
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPostableValue() {
		return postableValue;
	}
	public void setPostableValue(String postableValue) {
		this.postableValue = postableValue;
	}
	
	
	
}
