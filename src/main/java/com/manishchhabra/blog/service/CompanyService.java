package com.manishchhabra.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.manishchhabra.blog.model.Company;
import com.manishchhabra.blog.model.Employe;


@Repository
public class CompanyService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "company";
	
	public void addPerson(Company company) {
		if (!mongoTemplate.collectionExists(Company.class)) {
			mongoTemplate.createCollection(Company.class);
		}		
		company.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(company, COLLECTION_NAME);
	}
	
	public List<Company> listPerson() {
		return mongoTemplate.findAll(Company.class, COLLECTION_NAME);
	}
	
	public void deletePerson(Company company) {
		mongoTemplate.remove(company, COLLECTION_NAME);
	}
	
	public void updatePerson(Company company) {
		mongoTemplate.insert(company, COLLECTION_NAME);		
	}
	public List<Employe> listEmp(String id){
		List<Employe> list=mongoTemplate.findAll(Employe.class,"employe");
		List<Employe> listfinal= new ArrayList<Employe>();
		if(list!=null){
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getCompany().getId().equals(id)) listfinal.add(list.get(i));
		}
		}
		return listfinal;
	}
}
