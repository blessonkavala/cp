package com.svcet.cashportal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.service.OraganizationService;
import com.svcet.cashportal.service.UserService;
import com.svcet.cashportal.web.beans.OrganizationRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CashportalApplication.class)
@WebAppConfiguration
public class CashportalApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private OraganizationService oraganizationService;

	@Test
	public void contextLoads() {

		OrganizationRequest organizationRequest = new OrganizationRequest();

		organizationRequest.setOrgName("misys");
		organizationRequest.setAddressLine1("11-221");
		organizationRequest.setAddressLine2("Angels Home");
		organizationRequest.setStreet("Buchi Chetty Street");
		organizationRequest.setDom("Chittoor");
		organizationRequest.setCountryCode("IN");
		organizationRequest.setStatus("A");
		organizationRequest.setLegalIdType("P");
		organizationRequest.setLegalIdNumber("12345");
		organizationRequest.setLegalCountryCode("IN");
		organizationRequest.setContactName("Blesson");
		organizationRequest.setContactNumber("8147035233");
		organizationRequest.setTelex("8147035233");
		organizationRequest.setFax("8147035233");
		organizationRequest.setBei("8147035233");
		organizationRequest.setEmail("blesson.vagun@gmail.com");
		organizationRequest.setWebAddress("www.svcet.com");
		organizationRequest.setCustomerReference("123456");

		OrganizationMaster organizationMaster = oraganizationService.save(organizationRequest);

		UserMaster userMaster = new UserMaster();
		userMaster.setOrgId(organizationMaster);
		userMaster.setUserName("U1");
		userMaster.setPassword("password");

		userMaster = userService.save(userMaster);
	}

}
