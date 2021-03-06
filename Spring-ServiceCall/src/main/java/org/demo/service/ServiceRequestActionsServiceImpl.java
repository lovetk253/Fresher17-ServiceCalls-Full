/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.demo.entity.ServiceRequestActions;
import org.demo.repository.ServiceRequestActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ServiceRequestActionsServiceImpl implements ServiceRequestActionsService {

	@Autowired
	private ServiceRequestActionsRepository serviceRequestActionsRepository;

	@Override
	public ServiceRequestActions getOne(Integer responseId) {
		return serviceRequestActionsRepository.findById(responseId).get();
	}

	@Override
	public Boolean delete(Integer responseId) {
		if (serviceRequestActionsRepository.getOne(responseId) != null) {
			serviceRequestActionsRepository.deleteById(responseId);
			return true;
		}
		return false;
	}

	@Override
	public ServiceRequestActions create(ServiceRequestActions serviceRequestActions) {
		return serviceRequestActionsRepository.save(serviceRequestActions);
	}

	@Override
	public ServiceRequestActions update(ServiceRequestActions serviceRequestActionsToUpdate) {

		return serviceRequestActionsRepository.save(serviceRequestActionsToUpdate);
	}

	@Override
	public Boolean exist(ServiceRequestActions serviceRequestActions) {
		return serviceRequestActionsRepository.existsById(serviceRequestActions.getResponseId());
	}

	@Override
	public List<ServiceRequestActions> findAll() {
		return serviceRequestActionsRepository.findAll();
	}

}
