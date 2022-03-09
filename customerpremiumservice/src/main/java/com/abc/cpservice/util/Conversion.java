package com.abc.cpservice.util;

import com.abc.cpservice.entity.Premium;
import com.abc.cpservice.model.PremiumModel;

public class Conversion {

	public static Premium modelToEntity(PremiumModel premiumModel) {

		Premium premium = new Premium();

		premium.setPremiumId(premiumModel.getPremiumId());
		premium.setCustomerId(premiumModel.getCustomerId());
		premium.setProductId(premiumModel.getProductId());
		premium.setPremiumAmount(premiumModel.getPremiumAmount());
		premium.setPaidDate(premiumModel.getPaidDate());
		premium.setDueDate(premiumModel.getDueDate());

		return premium;
	}

	public static PremiumModel entityToModel(Premium premium) {

		PremiumModel premiumModel = new PremiumModel();

		premiumModel.setPremiumId(premium.getPremiumId());
		premiumModel.setCustomerId(premium.getCustomerId());
		premiumModel.setProductId(premium.getProductId());
		premiumModel.setPremiumAmount(premium.getPremiumAmount());
		premiumModel.setPaidDate(premium.getPaidDate());
		premiumModel.setDueDate(premium.getDueDate());

		return premiumModel;
	}

}
