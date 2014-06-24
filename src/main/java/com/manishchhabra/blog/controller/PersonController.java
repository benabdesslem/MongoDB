package com.manishchhabra.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.manishchhabra.blog.model.Company;
import com.manishchhabra.blog.model.Employe;
import com.manishchhabra.blog.service.CompanyService;
import com.manishchhabra.blog.service.EmployeService;

   
@Controller    
public class PersonController {  
   
	@Autowired
	private EmployeService personService;
	@Autowired
	private CompanyService companyService;
	

    @RequestMapping(value = "/person", method = RequestMethod.GET)  
	public String getPersonList(ModelMap model) {  
    	
    model.put("companyy", companyService.listPerson());
        model.addAttribute("personList", personService.listPerson());  
        return "output";  
    }  
@ModelAttribute("Companies")
  	public List<Company> CompanyList(ModelMap model) {  

          return companyService.listPerson();  
     
      }  
      
    @RequestMapping(value = "/person/save", method = RequestMethod.POST)  
	public View createPerson(@ModelAttribute Employe employe, ModelMap model,@RequestParam("vvv") String vv ) {
 
    	System.out.println(vv);
    	List<Company > list =companyService.listPerson();
    	Company chose=null;
    	for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equals(vv)){
				chose=list.get(i); 
			//chose.getListEmployes().add(employe);
			companyService.updatePerson(chose);
			
			}
		}
    	employe.setCompany(chose);
    	if(StringUtils.hasText(employe.getId())) {
    		personService.updatePerson(employe);
    	} else {
    		personService.addPerson(employe);
    	}
    	System.out.println(employe.getCompany()+"::::::::");
    	return new RedirectView("/HelloSpringWithMongoDB/person");  
    }
        
    @RequestMapping(value = "/person/delete", method = RequestMethod.GET)  
	public View deletePerson(@ModelAttribute Employe employe, ModelMap model) {  
        personService.deletePerson(employe);  
        return new RedirectView("/HelloSpringWithMongoDB/person");  
    }    
}
