package com.manishchhabra.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.manishchhabra.blog.model.Company;
import com.manishchhabra.blog.model.Employe;
import com.manishchhabra.blog.service.CompanyService;
import com.manishchhabra.blog.service.EmployeService;

   
@Controller    
public class CompanyController {  
   
	@Autowired
	private CompanyService companyService;

    @RequestMapping(value = "/company", method = RequestMethod.GET)  
	public String getPersonList(ModelMap model) {  
        model.addAttribute("companylist", companyService.listPerson());  
        return "outputCompany";  
    }  
    
    
    
    
    @RequestMapping(value = "/listemp", method = RequestMethod.GET)  
 	public String getListemp(@ModelAttribute Company company, ModelMap model,@RequestParam("idd") String id) {  
   
      model.addAttribute("listemps",companyService.listEmp(id) ); 
  
         return "list";  
     }  
     
     
     
    
    
    @RequestMapping(value = "/company/save", method = RequestMethod.POST)  
	public View createPerson(@ModelAttribute Company company, ModelMap model) {
    	if(StringUtils.hasText(company.getId())) {
    		companyService.updatePerson(company);
    	} else {
    		companyService.addPerson(company);
    	}
    	return new RedirectView("/HelloSpringWithMongoDB/company");  
    }
        
    @RequestMapping(value = "/company/delete", method = RequestMethod.GET)  
	public View deletePerson(@ModelAttribute Company company, ModelMap model) {  
        companyService.deletePerson(company);  
        return new RedirectView("/HelloSpringWithMongoDB/company");  
    }    
}
