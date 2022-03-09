package com.abc.cpservice.service;

import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.cpservice.entity.Premium;
import com.abc.cpservice.model.PremiumModel;
import com.abc.cpservice.repository.PremiumRepository;
import com.abc.cpservice.util.Conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PremiumServiceTest {

	@InjectMocks
	private PremiumService PremiumService = new PremiumServiceImpl();

	@Mock
	private PremiumRepository premiumRepository;
	
	@Mock
	private Conversion conversion;

	@Test
	public void testSavePremium() {
		
    	PremiumModel premiumModel = new PremiumModel();
    	
    	premiumModel.setPremiumId(1);
    	premiumModel.setCustomerId(103);
    	premiumModel.setProductId(106);
    	premiumModel.setPremiumAmount(2465.5);
    	premiumModel.setPaidDate(LocalDate.of(2020, 03, 03));
    	premiumModel.setDueDate(LocalDate.of(2022, 03, 03));

    	
        Premium premium = new Premium();
        
        premium.setPremiumId(premiumModel.getPremiumId());
        premium.setCustomerId(premiumModel.getCustomerId());
        premium.setProductId(premiumModel.getProductId());
        premium.setPremiumAmount(premiumModel.getPremiumAmount());
        premium.setPaidDate(premiumModel.getPaidDate());
        premium.setDueDate(premiumModel.getDueDate());

				
		when(conversion.modelToEntity(premiumModel)).thenReturn(premium);
		
		when(conversion.entityToModel(premium)).thenReturn(premiumModel);
		
     	when(premiumRepository.save(premium)).thenReturn(premium);		
    	
     	premiumModel = PremiumService.addPremium(premiumModel);		
		
		assertEquals(premium.getPaidDate(), premiumModel.getDueDate());
		
    }


	@Test
	public void testgetPremiumDetails() {
		Premium premium = new Premium();

		premium.setPremiumId(1);
		premium.setCustomerId(103);
		premium.setProductId(106);
		premium.setPremiumAmount(12334);
		premium.setPaidDate(LocalDate.of(2020, 03, 03));
		premium.setDueDate(LocalDate.of(2022, 03, 03));

		Optional<Premium> option = Optional.of(premium);
		int premiumId = 1;

		when(premiumRepository.findById(1)).thenReturn(option);

		PremiumModel existing = PremiumService.viewPremium(premiumId);

		// assertEquals(customerProduct.getCustomerProductId(),existing.getCustomerProductId());
		assertEquals(premium.getPremiumId(), existing.getPremiumId());
	}

}
