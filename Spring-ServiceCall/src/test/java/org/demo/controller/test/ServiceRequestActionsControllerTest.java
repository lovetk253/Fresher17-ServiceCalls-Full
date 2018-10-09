/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 13:46:11 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.ServiceRequestActionsResource;
import org.demo.entity.ServiceRequestActions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;

// Junit specific runner
@RunWith(SpringJUnit4ClassRunner.class)
// Declare as spring boot test and define the port according to properties in
// src/test/resources/application.properties
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// Ensure all are clean between two method test execution
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:clean.sql") })
public class ServiceRequestActionsControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final Date RESPONSEDATETIME = java.sql.Timestamp.valueOf("2001-05-21 01:46:52");

	private static final Integer CALLID = Integer.valueOf(100);

	private static final Integer ACTIONCODE = Integer.valueOf(100);

	private static final Integer OUTCOMECODE = Integer.valueOf(100);

	private static final Integer TECHNICIANID = Integer.valueOf(100);

	@Test
	public void createServiceRequestActionsTest() {
		// Create an serviceRequestActions
		ServiceRequestActions serviceRequestActions = createMocKServiceRequestActions(Integer.valueOf(100) , RESPONSEDATETIME, CALLID, ACTIONCODE, OUTCOMECODE, TECHNICIANID);
		// Recover this serviceRequestActions
		ResponseEntity<ServiceRequestActionsResource> result = this.restTemplate.getForEntity("/serviceRequestActions/1", ServiceRequestActionsResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/serviceRequestActions/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getCallId()).isEqualTo(CALLID);
		assertThat(result.getBody().getActionCode()).isEqualTo(ACTIONCODE);
		assertThat(result.getBody().getOutcomeCode()).isEqualTo(OUTCOMECODE);
		assertThat(result.getBody().getTechnicianId()).isEqualTo(TECHNICIANID);
		// Try to create the same serviceRequestActions, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/serviceRequestActions", serviceRequestActions, ServiceRequestActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an serviceRequestActions and assert field
		ServiceRequestActions serviceRequestActions = createMocKServiceRequestActions(Integer.valueOf(100)  , RESPONSEDATETIME, CALLID, ACTIONCODE, OUTCOMECODE, TECHNICIANID);
		// Recover this serviceRequestActions
		ResponseEntity<ServiceRequestActionsResource> result = this.restTemplate.getForEntity("/serviceRequestActions/1", ServiceRequestActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/serviceRequestActions/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getCallId()).isEqualTo(CALLID);
		assertThat(result.getBody().getActionCode()).isEqualTo(ACTIONCODE);
		assertThat(result.getBody().getOutcomeCode()).isEqualTo(OUTCOMECODE);
		assertThat(result.getBody().getTechnicianId()).isEqualTo(TECHNICIANID);

		// Change field value


		serviceRequestActions.setCallId(Integer.valueOf(200));

		serviceRequestActions.setActionCode(Integer.valueOf(200));

		serviceRequestActions.setOutcomeCode(Integer.valueOf(200));

		serviceRequestActions.setTechnicianId(Integer.valueOf(200));
		// Process update
		RequestEntity<ServiceRequestActions> request = new RequestEntity<ServiceRequestActions>(serviceRequestActions, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/serviceRequestActions/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the serviceRequestActions and ensure field are correct
		result = this.restTemplate.getForEntity("/serviceRequestActions/1", ServiceRequestActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/serviceRequestActions/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);


		assertThat(result.getBody().getCallId()).isEqualTo(Integer.valueOf(200));

		assertThat(result.getBody().getActionCode()).isEqualTo(Integer.valueOf(200));

		assertThat(result.getBody().getOutcomeCode()).isEqualTo(Integer.valueOf(200));

		assertThat(result.getBody().getTechnicianId()).isEqualTo(Integer.valueOf(200));
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<ServiceRequestActions> request = new RequestEntity<ServiceRequestActions>(new ServiceRequestActions(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/serviceRequestActions/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an serviceRequestActions
		createMocKServiceRequestActions(Integer.valueOf(100)  , RESPONSEDATETIME, CALLID, ACTIONCODE, OUTCOMECODE, TECHNICIANID);
		// Recover this serviceRequestActions and test if all is ok
		ResponseEntity<ServiceRequestActionsResource> result = this.restTemplate.getForEntity("/serviceRequestActions/1", ServiceRequestActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the serviceRequestActions
		RequestEntity<ServiceRequestActions> request = new RequestEntity<ServiceRequestActions>(new ServiceRequestActions(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/serviceRequestActions/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the serviceRequestActions and ensure it's don't exist
		// Recover this serviceRequestActions and test if all is ok
		result = this.restTemplate.getForEntity("/serviceRequestActions/1", ServiceRequestActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the serviceRequestActions
		RequestEntity<ServiceRequestActions> request = new RequestEntity<ServiceRequestActions>(new ServiceRequestActions(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/serviceRequestActions/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getServiceRequestActionssTest() {
		// First call assert no element
		ResponseEntity<PagedResources<ServiceRequestActionsResource>> result = this.search("/serviceRequestActions");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<ServiceRequestActionsResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 serviceRequestActions
		for (int i = 1; i < 22; i++) {
			createMocKServiceRequestActions(new Integer((int)i), new Date(),CALLID + i,ACTIONCODE + i,OUTCOMECODE + i,TECHNICIANID + i);
		}
		result = this.search("/serviceRequestActions");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/serviceRequestActions?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}


	private ServiceRequestActions createMocKServiceRequestActions(Integer responseId, Date responseDatetime, Integer callId, Integer actionCode, Integer outcomeCode, Integer technicianId) {
		ServiceRequestActions serviceRequestActionsMock = new ServiceRequestActions();
		serviceRequestActionsMock.setResponseId(responseId);
		serviceRequestActionsMock.setResponseDatetime(responseDatetime);
		serviceRequestActionsMock.setCallId(callId);
		serviceRequestActionsMock.setActionCode(actionCode);
		serviceRequestActionsMock.setOutcomeCode(outcomeCode);
		serviceRequestActionsMock.setTechnicianId(technicianId);
		this.restTemplate.postForLocation("/serviceRequestActions", serviceRequestActionsMock);
		return serviceRequestActionsMock;
	}

	private ResponseEntity<PagedResources<ServiceRequestActionsResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<ServiceRequestActionsResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<ServiceRequestActionsResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}