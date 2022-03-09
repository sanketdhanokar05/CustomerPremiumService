package com.abc.cpservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.cpservice.entity.Premium;
import com.abc.cpservice.exception.PremiumNotFoundException;
import com.abc.cpservice.model.PremiumModel;
import com.abc.cpservice.repository.PremiumRepository;
import com.abc.cpservice.util.Conversion;

@Service
public class PremiumServiceImpl implements PremiumService {

	@Autowired
	private PremiumRepository premiumRepository;
	
	/******************************************
	 - Method Name      : addPremium
	 - Input Parameters : Premium premium
	 - Return type      : Premium
	 - Author           : Sanket Vinod Dhanokar
	 - Creation Date    : 06-03-2022
	 - Description      : Inserting the Premium  information entered by customer   into  the database.
	  ******************************************/
	

	@Override
	public PremiumModel addPremium(PremiumModel premiumModel) {
		
		Premium newPremium = premiumRepository.save(Conversion.modelToEntity(premiumModel));
		return Conversion.entityToModel(newPremium);
	}

	@Override
	public PremiumModel viewPremium(int premiumId) {
		Optional<Premium> optionalPremium = premiumRepository.findById(premiumId);
		if (!optionalPremium.isPresent()) {
			throw new PremiumNotFoundException("Sorry! Premium is not existing with id: " + premiumId);
		}
		return Conversion.entityToModel(optionalPremium.get());
	}
}
