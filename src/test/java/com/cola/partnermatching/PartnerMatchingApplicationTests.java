package com.cola.partnermatching;

import com.cola.partnermatching.service.UserService;
import com.cola.partnermatching.utils.excel.ExcelUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PartnerMatchingApplicationTests {

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
		String fileName = "usertest";
		ExcelUtils.readUserByListener(fileName, userService);
	}

}
