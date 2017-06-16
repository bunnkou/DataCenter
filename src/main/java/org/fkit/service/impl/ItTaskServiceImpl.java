package org.fkit.service.impl;

import java.util.List;
import org.fkit.domain.ItTask;
import org.fkit.mapper.ItTaskMapper;
import org.fkit.service.ItTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItTaskServiceImpl implements ItTaskService {
	
	@Autowired
	private ItTaskMapper itTaskMapper;
	
	@Override
	public List<ItTask> findWithCDateTime(String inputStartDatetime, String inputEndDatetime, String inputKeyword) {
		return 	itTaskMapper.findWithCDateTime(inputStartDatetime, inputEndDatetime, inputKeyword);
	}

}
