package com.svcet.cashportal.repository;

import java.util.List;

import org.springframework.data.orient.commons.repository.annotation.Query;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.product.ft.FundTransfer;

public interface FundTransferRepository extends OrientObjectRepository<FundTransfer> {

	List<FundTransfer> findByTnxStatCode(String tnxstatcode);
	
	@Query("select from FundTransfer where @rid = ?")
	FundTransfer findByRid(String rid);

	@Query("select from FundTransfer where issuingBank = ? and tnxStatCode = ?")
	List<FundTransfer> findByIssuingBankAndTnxStatCode(String rid, String tnxStatCode);
}
