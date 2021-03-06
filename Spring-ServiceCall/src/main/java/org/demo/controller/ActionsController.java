/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:23:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller;

import org.demo.entity.Actions;
import org.demo.service.ActionsServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/actions", produces = "application/hal+json")
public class ActionsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActionsController.class);

	private static final String NOT_FOUND ="Actions not found";

	@Autowired
	private ActionsServiceImpl actionsService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Actions> findAll() {
		List<Actions> list = actionsService.findAll();
		return list;
	}


	@GetMapping("{actionCode}")
	public Actions get(@PathVariable("actionCode") Integer actionCode) {
		final Actions actions = actionsService.getOne(actionCode);
		LOGGER.info("Actions found : {}", actions);
		return actions;
	}

	@PostMapping(consumes = "application/json")
	public Actions create(@RequestBody Actions actions) {
		LOGGER.info("Actions creation request : {}", actions);
		if (actionsService.exist(actions)) {
			LOGGER.info("Actions already exist ! : {}", actions);
			return null;
		} else {
			final Actions created = actionsService.create(actions);
			LOGGER.info("Created actions {}", created);
			return created;
		}
	}

	@PutMapping( consumes = "application/json")
	public Actions update( @RequestBody Actions actions) {
		return actionsService.update(actions);
	}

	@DeleteMapping("{actionCode}")
	public void delete(@PathVariable("actionCode") Integer actionCode) {
		LOGGER.info("Actions deletion request : {}", resolveIdForLogger(actionCode));
		if (actionsService.delete(actionCode)) {
			LOGGER.info("Actions succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer actionCode) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(actionCode));
		return ids.toString();
	}

}

