/*
 * Created on 2018-10-01 ( Date ISO 2018-10-01 - Time 16:15:57 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
*/
package org.demo.service;

import org.demo.entity.Actions;
import java.util.List;

public interface ActionsService {

	public Actions getOne(Integer actionCode);

	public List<Actions> findAll();

	public Boolean delete(Integer actionCode);

	public Actions create(Actions actions);

	public Actions update(Actions actions);

	public Boolean exist(Actions actions);
}
