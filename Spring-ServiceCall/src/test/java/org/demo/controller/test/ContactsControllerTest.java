/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 13:46:11 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller.test;
import static org.assertj.core.api.Assertions.assertThat;

import org.demo.controller.resource.ContactsResource;
import org.demo.entity.Contacts;
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
public class ContactsControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	private static final String CONTACTNAME = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String JOBTITLE = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final String CONTACTDETAILS = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";

	private static final Integer CUSTOMERSCUSTOMERID = Integer.valueOf(100);

	@Test
	public void createContactsTest() {
		// Create an contacts
		Contacts contacts = createMocKContacts(Integer.valueOf(100) , CONTACTNAME, JOBTITLE, CONTACTDETAILS, CUSTOMERSCUSTOMERID);
		// Recover this contacts
		ResponseEntity<ContactsResource> result = this.restTemplate.getForEntity("/contacts/1", ContactsResource.class);
		// The response can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/contacts/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getContactName()).isEqualTo(CONTACTNAME);
		assertThat(result.getBody().getJobTitle()).isEqualTo(JOBTITLE);
		assertThat(result.getBody().getContactDetails()).isEqualTo(CONTACTDETAILS);
		assertThat(result.getBody().getCustomersCustomerId()).isEqualTo(CUSTOMERSCUSTOMERID);
		// Try to create the same contacts, must return a CONFLICT status code
		result = this.restTemplate.postForEntity("/contacts", contacts, ContactsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CONFLICT);
		// Response body must not be null
		assertThat(result.getBody()).isNull();
	}

	@Test
	public void updateTest() {
		// Create an contacts and assert field
		Contacts contacts = createMocKContacts(Integer.valueOf(100)  , CONTACTNAME, JOBTITLE, CONTACTDETAILS, CUSTOMERSCUSTOMERID);
		// Recover this contacts
		ResponseEntity<ContactsResource> result = this.restTemplate.getForEntity("/contacts/1", ContactsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		Link link = new Link("http://localhost:9999/contacts/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);
		assertThat(result.getBody().getContactName()).isEqualTo(CONTACTNAME);
		assertThat(result.getBody().getJobTitle()).isEqualTo(JOBTITLE);
		assertThat(result.getBody().getContactDetails()).isEqualTo(CONTACTDETAILS);
		assertThat(result.getBody().getCustomersCustomerId()).isEqualTo(CUSTOMERSCUSTOMERID);

		// Change field value

		contacts.setContactName("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		contacts.setJobTitle("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		contacts.setContactDetails("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		contacts.setCustomersCustomerId(Integer.valueOf(200));
		// Process update
		RequestEntity<Contacts> request = new RequestEntity<Contacts>(contacts, HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/contacts/1", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be OK
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Recover the contacts and ensure field are correct
		result = this.restTemplate.getForEntity("/contacts/1", ContactsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		assertThat(result.getBody()).isNotNull();
		// Assert the Hateoas self link
		link = new Link("http://localhost:9999/contacts/1", Link.REL_SELF);
		assertThat(result.getBody().getId()).isEqualTo(link);

		assertThat(result.getBody().getContactName()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getJobTitle()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getContactDetails()).isEqualTo("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		assertThat(result.getBody().getCustomersCustomerId()).isEqualTo(Integer.valueOf(200));
	}

	@Test
	public void updateNotFoundTest() {
		// Process update
		RequestEntity<Contacts> request = new RequestEntity<Contacts>(new Contacts(), HttpMethod.PUT, null);
		ResponseEntity<Void> resultUpdate = this.restTemplate.exchange("/contacts/999", HttpMethod.PUT, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultUpdate).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultUpdate.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteTest() {
		// Create an contacts
		createMocKContacts(Integer.valueOf(100)  , CONTACTNAME, JOBTITLE, CONTACTDETAILS, CUSTOMERSCUSTOMERID);
		// Recover this contacts and test if all is ok
		ResponseEntity<ContactsResource> result = this.restTemplate.getForEntity("/contacts/1", ContactsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);

		// Delete the contacts
		RequestEntity<Contacts> request = new RequestEntity<Contacts>(new Contacts(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/contacts/1", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_CONTENT
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

		// Try to recover the contacts and ensure it's don't exist
		// Recover this contacts and test if all is ok
		result = this.restTemplate.getForEntity("/contacts/1", ContactsResource.class);
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void deleteNotFound() {
		// Delete the contacts
		RequestEntity<Contacts> request = new RequestEntity<Contacts>(new Contacts(), HttpMethod.DELETE, null);
		ResponseEntity<Void> resultDelete = this.restTemplate.exchange("/contacts/999", HttpMethod.DELETE, request,
				getTypeRefVoid());
		// The response can't be null
		assertThat(resultDelete).isNotNull();
		// The status code must be NOT_FOUND
		assertThat(resultDelete.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	@Test
	public void getContactssTest() {
		// First call assert no element
		ResponseEntity<PagedResources<ContactsResource>> result = this.search("/contacts");
		// The reponse can't be null
		assertThat(result).isNotNull();
		// The status code must be OK
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		// Response body must not be null
		PagedResources<ContactsResource> page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata()).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(0);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(0);
		// By default page size is 20
		assertThat(page.getMetadata().getSize()).isEqualTo(20);

		// Insert 21 contacts
		for (int i = 1; i < 22; i++) {
			createMocKContacts(new Integer((int)i),String.valueOf(i),String.valueOf(i),String.valueOf(i),CUSTOMERSCUSTOMERID + i);
		}
		result = this.search("/contacts");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(2);

		// Change the number of element per page and assert the page number
		result = this.search("/contacts?size=3");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(21);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(7);
	}

	@Test
	public void getContactssTestFilter() {
		// Create an contacts
		Contacts contacts = createMocKContacts(Integer.valueOf(100) , CONTACTNAME, JOBTITLE, CONTACTDETAILS, CUSTOMERSCUSTOMERID);
		RequestEntity<Contacts> request = null;
		ResponseEntity<PagedResources<ContactsResource>> result = null;
		PagedResources<ContactsResource> page = null;
		// Test contactName filter
		// Set the value on entity and update
		contacts.setContactName("c");
		// Process update
		request = new RequestEntity<Contacts>(contacts, HttpMethod.PUT, null);
		this.restTemplate.exchange("/contacts/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test contactName filter
		result = this.search("/contacts?size=20&contactName=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (ContactsResource contactsResource : page.getContent()) {
			assertThat(contactsResource.getContactName()).startsWith("c");
		}
		// Test jobTitle filter
		// Set the value on entity and update
		contacts.setJobTitle("c");
		// Process update
		request = new RequestEntity<Contacts>(contacts, HttpMethod.PUT, null);
		this.restTemplate.exchange("/contacts/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test jobTitle filter
		result = this.search("/contacts?size=20&jobTitle=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (ContactsResource contactsResource : page.getContent()) {
			assertThat(contactsResource.getJobTitle()).startsWith("c");
		}
		// Test contactDetails filter
		// Set the value on entity and update
		contacts.setContactDetails("c");
		// Process update
		request = new RequestEntity<Contacts>(contacts, HttpMethod.PUT, null);
		this.restTemplate.exchange("/contacts/1", HttpMethod.PUT, request, getTypeRefVoid());
		// Test contactDetails filter
		result = this.search("/contacts?size=20&contactDetails=c");
		// Response body must not be null
		page = result.getBody();
		assertThat(page).isNotNull();
		assertThat(page.getMetadata().getTotalElements()).isEqualTo(1);
		assertThat(page.getMetadata().getTotalPages()).isEqualTo(1);
		for (ContactsResource contactsResource : page.getContent()) {
			assertThat(contactsResource.getContactDetails()).startsWith("c");
		}
	}

	private Contacts createMocKContacts(Integer contactId, String contactName, String jobTitle, String contactDetails, Integer customersCustomerId) {
		Contacts contactsMock = new Contacts();
		contactsMock.setContactId(contactId);
		contactsMock.setContactName(contactName);
		contactsMock.setJobTitle(jobTitle);
		contactsMock.setContactDetails(contactDetails);
		contactsMock.setCustomersCustomerId(customersCustomerId);
		this.restTemplate.postForLocation("/contacts", contactsMock);
		return contactsMock;
	}

	private ResponseEntity<PagedResources<ContactsResource>> search(String uri) {
		return this.restTemplate.exchange(uri, HttpMethod.GET, null, getTypeRef());
	}

	private ParameterizedTypeReference<PagedResources<ContactsResource>> getTypeRef() {
		return new ParameterizedTypeReference<PagedResources<ContactsResource>>() {
		};
	}

	private ParameterizedTypeReference<Void> getTypeRefVoid() {
		return new ParameterizedTypeReference<Void>() {
		};
	}
}