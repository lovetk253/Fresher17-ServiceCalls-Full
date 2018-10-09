/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:58 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.demo.entity.Problems;
import org.demo.repository.ProblemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProblemsServiceImpl implements ProblemsService {

	@Autowired
	private ProblemsRepository problemsRepository;

	@Override
	public Problems getOne(Integer problemCode) {
		return problemsRepository.findById(problemCode).get();
	}

	@Override
	public Boolean delete(Integer problemCode) {
		if (problemsRepository.getOne(problemCode) != null) {
			problemsRepository.deleteById(problemCode);
			return true;
		}
		return false;
	}

	@Override
	public Problems create(Problems problems) {
		return problemsRepository.save(problems);
	}

	@Override
	public Problems update(Problems problemsToUpdate) {

		return problemsRepository.save(problemsToUpdate);
	}

	@Override
	public Boolean exist(Problems problems) {
		return problemsRepository.existsById(problems.getProblemCode());
	}

	@Override
	public List<Problems> findAll() {
		return problemsRepository.findAll();
	}

}