package com.svcet.cashportal.service;

import com.svcet.cashportal.web.beans.MOPendingRecordsRequest;
import com.svcet.cashportal.web.beans.MOPendingRecordsResponse;

public interface MiddleOfficeService {

	MOPendingRecordsResponse list(MOPendingRecordsRequest moPendingRecordsRequest);

}
