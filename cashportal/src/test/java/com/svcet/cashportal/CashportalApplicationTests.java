package com.svcet.cashportal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CashportalApplication.class)
@WebAppConfiguration
public class CashportalApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		OrganizationMaster organizationMaster = new OrganizationMaster();
		organizationMaster.setOrgName("misys");

		UserMaster userMaster = new UserMaster();
		userMaster.setOrgId(organizationMaster);
		userMaster.setUserName("U1");
		userMaster.setPassword("password");

		userMaster = userService.save(userMaster);
	}

}
