/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:23:36 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.controller;

import org.demo.entity.Problems;
import org.demo.service.ProblemsServiceImpl;

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
@RequestMapping(value = "/problems", produces = "application/hal+json")
public class ProblemsController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProblemsController.class);

	private static final String NOT_FOUND ="Problems not found";

	@Autowired
	private ProblemsServiceImpl problemsService;

	@RequestMapping(value = "/",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Problems> findAll() {
		List<Problems> list = problemsService.findAll();
		return list;
	}


	@GetMapping("{problemCode}")
	public Problems get(@PathVariable("problemCode") Integer problemCode) {
		final Problems problems = problemsService.getOne(problemCode);
		LOGGER.info("Problems found : {}", problems);
		return problems;
	}

	@PostMapping(consumes = "application/json")
	public Problems create(@RequestBody Problems problems) {
		LOGGER.info("Problems creation request : {}", problems);
		if (problemsService.exist(problems)) {
			LOGGER.info("Problems already exist ! : {}", problems);
			return null;
		} else {
			final Problems created = problemsService.create(problems);
			LOGGER.info("Created problems {}", created);
			return created;
		}
	}

	@PutMapping(consumes = "application/json")
	public Problems update( @RequestBody Problems problems) {
		return problemsService.update(problems);
	}

	@DeleteMapping("{problemCode}")
	public void delete(@PathVariable("problemCode") Integer problemCode) {
		LOGGER.info("Problems deletion request : {}", resolveIdForLogger(problemCode));
		if (problemsService.delete(problemCode)) {
			LOGGER.info("Problems succesfully deleted");
		} else {
			LOGGER.info(NOT_FOUND);
		}
	}

	private String resolveIdForLogger(Integer problemCode) {
		final StringBuilder ids = new StringBuilder();
		ids.append(String.valueOf(problemCode));
		return ids.toString();
	}

}

