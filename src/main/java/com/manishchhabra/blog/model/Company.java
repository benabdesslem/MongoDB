package com.manishchhabra.blog.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Company {

	@Id
	private String id;
	private String name;
	private String location;
	private List<Employe> listEmployes=new ArrayList<Employe>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return name;
	}
	public List<Employe> getListEmployes() {
		return listEmployes;
	}
	public void setListEmployes(List<Employe> listEmployes) {
		this.listEmployes = listEmployes;
	}
}
