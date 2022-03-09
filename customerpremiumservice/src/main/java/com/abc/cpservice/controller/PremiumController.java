package com.abc.cpservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.cpservice.model.PremiumModel;
import com.abc.cpservice.service.PremiumService;


@RestController
@RequestMapping("/premium")
public class PremiumController {

	@Autowired
	private PremiumService premiumService;

	@PostMapping("/newpremium")
	 public ResponseEntity<PremiumModel> newPremium(@RequestBody PremiumModel premiumModel) {
		PremiumModel newPremiumModel =premiumService.addPremium(premiumModel);
		 ResponseEntity<PremiumModel> responseEntity = new ResponseEntity<PremiumModel>(newPremiumModel,HttpStatus.CREATED);
			return responseEntity;
			
	 }
	 
	 @GetMapping("/view/{pid}")
		public ResponseEntity<?> viewAllPremium(@PathVariable("pid") int premiumId)
		{
		 PremiumModel premiumModel=premiumService.viewPremium(premiumId);
			return new ResponseEntity<>(premiumModel, HttpStatus.OK);
			
		}
}
