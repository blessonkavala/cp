package com.svcet.cashportal.repository;

import org.springframework.data.orient.object.repository.OrientObjectRepository;

import com.svcet.cashportal.domain.product.ft.FundTransfer;
import java.lang.String;
import java.util.List;

public interface FundTransferRepository extends OrientObjectRepository<FundTransfer> {

	List<FundTransfer> findByTnxStatCode(String tnxstatcode);
}
