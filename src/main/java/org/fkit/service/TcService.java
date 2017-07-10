package org.fkit.service;

import java.util.List;

import org.fkit.domain.Timecard;

public interface TcService {
	
	List<Timecard> findWithDate(
			List<Integer> yearLst,
			String inputStartDatetime, 
			String inputEndDatetime, 
			String inputKeyword, 
			int page, 
			int rows
	);
	
	int countBySpec(
			List<Integer> yearLst,
			String inputStartDatetime, 
			String inputEndDatetime, 
			String inputKeyword
	);
}
