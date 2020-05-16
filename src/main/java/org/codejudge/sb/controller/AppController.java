package org.codejudge.sb.controller;

import javax.validation.Valid;

import org.codejudge.sb.Service.LeadService;
import org.codejudge.sb.entity.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.annotations.ApiOperation;

@RestController
@ControllerAdvice
public class AppController extends ResponseEntityExceptionHandler  {
	

	 @Autowired
	 private LeadService leadService;

    @ApiOperation("This is the hello world api")
    @GetMapping("/")
    public String hello() {
        return "Hello World!!";
    }
    
    @GetMapping("/api/leads/{leadId}")
    public ResponseEntity<Lead> getLead(@PathVariable(name="leadId")Integer leadId) throws Exception {
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        Lead employee=null;
        try {
    	  employee = leadService.getLead(leadId);
	} catch(Exception ex) {
		 System.out.println("Lead Id not found" + ex.getMessage());
		 return ResponseEntity.badRequest().headers(headers).body(employee);
	}
	
	return ResponseEntity.ok().headers(headers).body(employee);
    }
    
    @PostMapping("/api/leads")
    public ResponseEntity<Lead> saveEmployee(@Valid @RequestBody Lead lead){
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    try {
    	leadService.saveLead(lead);
    } catch(Exception ex) {
		 System.out.println("Employee not found" + ex.getMessage());
		 return ResponseEntity.badRequest().headers(headers).body(lead);
	}
     /*ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
    	        ex.getBindingResult().toString());*/
    return ResponseEntity.ok().headers(headers).body(lead);
    }
    
  //  @RequestMapping(value = "/api/leads/{leadId}", produces = "application/json", method = RequestMethod.DELETE)
   @DeleteMapping("/api/leads/{leadId}")
    public String deleteLead(@PathVariable(value="leadId") int id) {
	   Lead employee=null;
		try {
			
			employee = leadService.delete(id);
		} catch(Exception ex) {
			 System.out.println("Lead not found to delete" + ex.getMessage());
			 return "not del";
		}
		
		return "OK Deleted";
	}
    
    
   // @RequestMapping(value = "/api/leads/{leadId}",  produces = "application/json",method = RequestMethod.PUT)
    @PutMapping("/api/leads/{leadId}")
    public ResponseEntity<Lead> updateLead(@PathVariable(value="leadId") int id,@Valid @RequestBody Lead lead){
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    try {
    	leadService.updateLead(lead,id);
    } catch(Exception ex) {
		 System.out.println("Lead not found" + ex.getMessage());
		 return ResponseEntity.ok().build();
	}
     /*ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
    	        ex.getBindingResult().toString());*/
    return ResponseEntity.ok().build();
    }
    
    @RequestMapping(value = "/api/mark_lead/{leadId}", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<Lead> markLead(@RequestParam("communication") String communication,@Valid @RequestBody Lead lead){
    	HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
    try {
    	//if(communication.equals(anObject))
    	leadService.markLead(lead,communication);
    } catch(Exception ex) {
		 System.out.println("Lead not found" + ex.getMessage());
		 return ResponseEntity.ok().headers(headers).body(lead);
	}
     /*ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
    	        ex.getBindingResult().toString());*/
    return ResponseEntity.ok().headers(headers).body(lead);
    }

}
