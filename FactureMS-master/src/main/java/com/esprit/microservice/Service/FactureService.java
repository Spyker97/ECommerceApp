package com.esprit.microservice.Service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Facture;
import com.esprit.microservice.Repository.FactureRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;








@Service
public class FactureService implements IFactureService {

	
	@Autowired
	private FactureRepository factureRepository;
	@Autowired
    ServletContext context;
	
	

	public Facture updateFacture( Facture facture) {
	return factureRepository.save(facture);
}
	
	
	public void deleteFacture(int id) {
			factureRepository.deleteById(id);

	}

	@Override
	public List<Facture> getAllFactures() {
		// TODO Auto-generated method stub
		return factureRepository.findAll();
		
	}
	@Override
	public Facture retrieveFacture(int id) {
		// TODO Auto-generated method stub
		Facture p = factureRepository.findById(id).get();
		// TODO Auto-generated method stub
		return p;	}
	@Override
	public Facture addFacture(Facture s) {
		// TODO Auto-generated method stub
		return factureRepository.save(s
				);
	}
	
	
	
	
	
	
}
