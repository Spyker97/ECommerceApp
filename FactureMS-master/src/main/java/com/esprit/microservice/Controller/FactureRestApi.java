package com.esprit.microservice.Controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.microservice.Entity.Facture;
import com.esprit.microservice.Service.IFactureService;
import com.fasterxml.jackson.databind.JsonMappingException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/factures")
public class FactureRestApi {
	@Autowired
	IFactureService factureService;
	@PostMapping("/add")
	@ResponseBody
	public Facture  addfacture(@RequestBody Facture s)throws Exception {
		 return factureService.addFacture(s);
	}

	@GetMapping("/retrieve-facture/{facture-id}")
	public Facture retrieveStock(@PathVariable("facture-id") int factureid) {
	return factureService.retrieveFacture(factureid);
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	Facture updateFacture(@RequestBody Facture s){
		return factureService.updateFacture(s);
	}
	
	
	
	@GetMapping("/all")
    public List<Facture> getFactures(){
        return factureService.getAllFactures();
    }
	@DeleteMapping("/remove-facture/{facture-id}")
	public void removeFacture(@PathVariable("facture-id") int factureid) {
		factureService.deleteFacture(factureid);
	}
	
}
