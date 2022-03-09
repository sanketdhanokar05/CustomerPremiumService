package com.abc.cpservice.service;

import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.abc.cpservice.entity.Premium;
import com.abc.cpservice.repository.PremiumRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PremiumServiceTest {

	@InjectMocks
	private PremiumService PremiumService = new PremiumServiceImpl();

	@Mock
	private PremiumRepository premiumRepository;

//		@Test
//	    public void testSaveProduct() {
//	       
//	        CustomerProduct customerProduct = new CustomerProduct();
//	        customerProduct.setCustomerProductId(2);
//	        customerProduct.setCustomerId(4);
//	        customerProduct.setDateOfMaturity(LocalDate.of(2022, 03, 8));
//	        customerProduct.setPremiumType(6);
//	        customerProduct.setPremiumAmount(20000);
//	        customerProduct.setProductId(3);
//	        customerProduct.setNomineeId(2);
//	           
//	       
//	        when(customerProductRepository.save(customerProduct)).thenReturn(customerProduct);
//	       
//	        CustomerProduct newProduct = customerProductService.saveCustomerProduct(customerProduct);
//	       
//	        //assertEquals(product.getProductName(), newProduct.getProductName(customerProduct));
//	       
//	        verify(customerProductRepository,times(1)).save(customerProduct);       
//	       
//	    }

	@Test
	public void testgetPremiumDetails() {

		Premium premium = new Premium();
		premium.setPremiumId(1);
		premium.setCustomerId(103);
		premium.setProductId(106);
		premium.setPremiumAmount(2465.5);
		premium.setPaidDate(LocalDate.of(2020, 03, 03));
		premium.setDueDate(LocalDate.of(2022, 03, 03));

		Optional<Premium> option = Optional.of(premium);
		int premiumId = 1;

		when(premiumRepository.findById(1)).thenReturn(option);

		Premium existing = PremiumService.viewPremium(premiumId);

		// assertEquals(customerProduct.getCustomerProductId(),existing.getCustomerProductId());
		assertEquals(premium.getPremiumId(), existing.getPremiumId());
	}

//		@Test
//	    public void testGetCustomerByIdNotFound() {
//	       
//	        int customerProductId = 1;       
//	           
//	        when(customerProductRepository.findById(customerProductId)).thenThrow(ResourceNotFoundException.class);
//	           
//	        assertThrows(ResourceNotFoundException.class,()->customerProductService.getCustomerProductDetails(customerProductId));
//	       
//	    }

}
