/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;

import org.demo.entity.ServiceRequestCalls;
import java.util.List;

public interface ServiceRequestCallsService {

	public ServiceRequestCalls getOne(Integer callId);

	public List<ServiceRequestCalls> findAll();

	public Boolean delete(Integer callId);

	public ServiceRequestCalls create(ServiceRequestCalls serviceRequestCalls);

	public ServiceRequestCalls update(ServiceRequestCalls serviceRequestCalls);

	public Boolean exist(ServiceRequestCalls serviceRequestCalls);
}
