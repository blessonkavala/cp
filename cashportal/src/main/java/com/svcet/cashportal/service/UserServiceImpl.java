package com.svcet.cashportal.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.svcet.cashportal.domain.CountryMaster;
import com.svcet.cashportal.domain.OrganizationMaster;
import com.svcet.cashportal.domain.UserMaster;
import com.svcet.cashportal.exception.DuplicateUserException;
import com.svcet.cashportal.exception.OrganizationNotFoundException;
import com.svcet.cashportal.exception.UserNotFoundException;
import com.svcet.cashportal.repository.CountryMasterRepository;
import com.svcet.cashportal.repository.OrganizationRepository;
import com.svcet.cashportal.repository.UserRepository;
import com.svcet.cashportal.web.beans.UserRequest;
import com.svcet.cashportal.web.beans.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private CountryMasterRepository countryMasterRepository;

	@Override
	public UserMaster findUserByUserNamePasswordOrgName(String userName, String password, String orgName) {
		try {
			OrganizationMaster organizationMaster = organizationRepository.findByOrgName(orgName);
			return userRepository.findOneByUserNameAndPasswordAndOrgId(userName, password, organizationMaster.getRid());
		} catch (IndexOutOfBoundsException e) {
			LOGGER.debug("No entity was found in repository with the id [{}]", userName);
		}
		return null;
	}

	@Override
	public UserMaster save(UserMaster userMaster) {
		return userRepository.save(userMaster);
	}

	@Override
	public UserResponse save(UserRequest userRequest) {
		try {
			UserMaster userMaster = userRepository.findOneByUserNameAndOrgId(userRequest.getUserName(),
					userRequest.getOrgId());
			throw new DuplicateUserException(userRequest);
		} catch (IndexOutOfBoundsException e) {
			UserMaster userMaster = new UserMaster();
			BeanUtils.copyProperties(userRequest, userMaster, "orgId", "countryId");
			OrganizationMaster organizationMaster = organizationRepository.findByRid(userRequest.getOrgId());
			userMaster.setOrgId(organizationMaster);

			CountryMaster countryId = countryMasterRepository.findByCountryCode(userRequest.getCountryId());
			userMaster.setCountryId(countryId);
			userMaster = userRepository.save(userMaster);

			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userMaster, userResponse, "orgId");
			userResponse.setOrgId(userMaster.getOrgId().getRid());
			return userResponse;
		}
	}

	@Override
	public UserResponse findById(String id) {
		try {
			UserMaster userMaster = userRepository.findByRid(id);
			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userMaster, userResponse, "orgId", "countryId");
			userResponse.setOrgId(userMaster.getOrgId().getRid());

			userResponse.setCountryId(userMaster.getCountryId().getCountryCode());

			return userResponse;
		} catch (IndexOutOfBoundsException e) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public UserResponse update(UserRequest userRequest) {
		try {
			UserMaster userMaster = userRepository.findByRid(userRequest.getRid());
			BeanUtils.copyProperties(userRequest, userMaster, "orgId", "countryId");
			CountryMaster countryId = countryMasterRepository.findByCountryCode(userRequest.getCountryId());
			userMaster.setCountryId(countryId);
			OrganizationMaster organizationMaster = organizationRepository.findByRid(userRequest.getOrgId());
			userMaster.setOrgId(organizationMaster);

			userMaster = userRepository.save(userMaster);

			UserResponse userResponse = new UserResponse();
			BeanUtils.copyProperties(userMaster, userResponse, "orgId", "countryId");
			userResponse.setOrgId(userMaster.getOrgId().getRid());
			userResponse.setCountryId(userMaster.getCountryId().getCountryCode());
			return userResponse;
		} catch (IndexOutOfBoundsException e) {
			throw new UserNotFoundException();
		}
	}

	@Override
	public List<UserResponse> findAll(String orgId) {
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		try {
			List<UserMaster> userMasterList = userRepository.findByOrgId(orgId);
			for (UserMaster userMaster : userMasterList) {
				UserResponse userResponse = new UserResponse();
				BeanUtils.copyProperties(userMaster, userResponse, "orgId", "countryId");
				userResponse.setOrgId(userMaster.getOrgId().getRid());
				userResponse.setCountryId(userMaster.getCountryId().getCountryCode());
				userResponseList.add(userResponse);
			}
		} catch (IndexOutOfBoundsException e) {
			throw new OrganizationNotFoundException();
		}
		return userResponseList;
	}

	@Override
	public UserMaster findOneByUserNameAndOrgId(String userName, String orgId) {
		try {
			return userRepository.findOneByUserNameAndOrgId(userName, orgId);
		} catch (IndexOutOfBoundsException e) {
			throw new UserNotFoundException();
		}
	}
}
