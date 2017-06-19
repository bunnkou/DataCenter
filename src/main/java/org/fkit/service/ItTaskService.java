package org.fkit.service;

import java.util.List;
import org.fkit.domain.ItTask;

public interface ItTaskService {

	List<ItTask> findWithCDateTime(
			String inputStartDatetime, 
			String inputEndDatetime, 
			String inputKeyword, 
			int page, 
			int rows
	);
	
	int countBySpec(
			String inputStartDatetime, 
			String inputEndDatetime, 
			String inputKeyword
	);
}
