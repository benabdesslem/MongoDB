package com.manishchhabra.blog.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.manishchhabra.blog.model.Employe;


@Repository
public class EmployeService {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "employe";
	
	public void addPerson(Employe employe) {
		if (!mongoTemplate.collectionExists(Employe.class)) {
			mongoTemplate.createCollection(Employe.class);
		}		
		employe.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(employe, COLLECTION_NAME);
	}
	
	public List<Employe> listPerson() {
		return mongoTemplate.findAll(Employe.class, COLLECTION_NAME);
	}
	
	public void deletePerson(Employe employe) {
		mongoTemplate.remove(employe, COLLECTION_NAME);
	}
	
	public void updatePerson(Employe employe) {
		mongoTemplate.insert(employe, COLLECTION_NAME);		
	}
}
