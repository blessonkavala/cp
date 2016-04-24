package com.svcet.cashportal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.svcet.cashportal.service.MiddleOfficeService;
import com.svcet.cashportal.web.beans.MOPendingRecordsRequest;
import com.svcet.cashportal.web.beans.MOPendingRecordsResponse;

@RestController
public class MiddleOfficeController {

	@Autowired
	private MiddleOfficeService middleOfficeService;

	@RequestMapping(method = RequestMethod.POST, value = "/middleoffice/list")
	@ResponseBody
	public MOPendingRecordsResponse inquiry(@RequestBody MOPendingRecordsRequest moPendingRecordsRequest) {
		return middleOfficeService.list(moPendingRecordsRequest);
	}
}
