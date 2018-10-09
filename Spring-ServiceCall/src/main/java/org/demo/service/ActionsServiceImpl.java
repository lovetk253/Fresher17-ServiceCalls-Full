/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:57 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;



import java.util.List;

import javax.transaction.Transactional;

import org.demo.entity.Actions;
import org.demo.repository.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ActionsServiceImpl implements ActionsService {

	@Autowired
	private ActionsRepository actionsRepository;

	@Override
	public Actions getOne(Integer actionCode) {
		return actionsRepository.findById(actionCode).get();
	}

	@Override
	public Boolean delete(Integer actionCode) {
		if (actionsRepository.getOne(actionCode) != null) {
			actionsRepository.deleteById(actionCode);
			return true;
		}
		return false;
	}

	@Override
	public Actions create(Actions actions) {
		return actionsRepository.save(actions);
	}

	@Override
	public Actions update(Actions actionsToUpdate) {
						
				return actionsRepository.save(actionsToUpdate);
	}

	@Override
	public Boolean exist(Actions actions) {
						return actionsRepository.existsById(actions.getActionCode());
									}

	@Override
	public List<Actions> findAll() {
		return actionsRepository.findAll();
	}

}

