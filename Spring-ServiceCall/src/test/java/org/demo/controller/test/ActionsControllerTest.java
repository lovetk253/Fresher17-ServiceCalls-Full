/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 13:46:10 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.ActionsResource;
import org.demo.entity.Actions;
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

// Junit specific runner
@RunWith(SpringJUnit4ClassRunner.class)
// Declare as spring boot test and define the port according to properties in
// src/test/resources/application.properties
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
// Ensure all are clean between two method test execution
@SqlGroup({ @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:clean.sql") })
public class ActionsControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final String ACTIONDESCRIPTION = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	@Test
	public void createActionsTest() {
		// Create an actions
		Actions actions = createMocKActions(Integer.valueOf(100) , ACTIONDESCRIPTION);
		// Recover this actions
		ResponseEntity<ActionsResource> result = this.restTemplate.getForEntity("/actions/1", ActionsResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/actions/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getActionDescription()).isEqualTo(ACTIONDESCRIPTION);
		// Try to create the same actions, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/actions", actions, ActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an actions and assert field
		Actions actions = createMocKActions(Integer.valueOf(100)  , ACTIONDESCRIPTION);
		// Recover this actions
		ResponseEntity<ActionsResource> result = this.restTemplate.getForEntity("/actions/1", ActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/actions/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getActionDescription()).isEqualTo(ACTIONDESCRIPTION);

		// Change field value

		actions.setActionDescription("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
		// Process update
		RequestEntity<Actions> request = new RequestEntity<Actions>(actions, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/actions/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the actions and ensure field are correct
		result = this.restTemplate.getForEntity("/actions/1", ActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/actions/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);

		assertThat(result.getBody().getActionDescription()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<Actions> request = new RequestEntity<Actions>(new Actions(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/actions/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an actions
		createMocKActions(Integer.valueOf(100)  , ACTIONDESCRIPTION);
		// Recover this actions and test if all is ok
		ResponseEntity<ActionsResource> result = this.restTemplate.getForEntity("/actions/1", ActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the actions
		RequestEntity<Actions> request = new RequestEntity<Actions>(new Actions(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/actions/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the actions and ensure it's don't exist
		// Recover this actions and test if all is ok
		result = this.restTemplate.getForEntity("/actions/1", ActionsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the actions
		RequestEntity<Actions> request = new RequestEntity<Actions>(new Actions(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/actions/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getActionssTest() {
		// First call assert no element
		ResponseEntity<PagedResources<ActionsResource>> result = this.search("/actions");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<ActionsResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 actions
		for (int i = 1; i < 22; i++) {
			createMocKActions(new Integer((int)i),String.valueOf(i));
		}
		result = this.search("/actions");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/actions?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}

	@Test
	public void getActionssTestFilter() {
		// Create an actions
		Actions actions = createMocKActions(Integer.valueOf(100) , ACTIONDESCRIPTION);
		RequestEntity<Actions> request = null;
		ResponseEntity<PagedResources<ActionsResource>> result = null;
		PagedResources<ActionsResource> page = null;
		// Test actionDescription filter
		// Set the value on entity and update
		actions.setActionDescription("c");
		// Process update
		request = new RequestEntity<Actions>(actions, HttpMethod.PUT, null);
		this.restTemplate.exchange("/actions/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test actionDescription filter
		result = this.search("/actions?size=20&actionDescription=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (ActionsResource actionsResource : page.getContent()) {
			assertThat(actionsResource.getActionDescription()).startsWith("c");
		}
	}

	private Actions createMocKActions(Integer actionCode, String actionDescription) {
		Actions actionsMock = new Actions();
		actionsMock.setActionCode(actionCode);
		actionsMock.setActionDescription(actionDescription);
		this.restTemplate.postForLocation("/actions", actionsMock);
		return actionsMock;
	}

	private ResponseEntity<PagedResources<ActionsResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<ActionsResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<ActionsResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}