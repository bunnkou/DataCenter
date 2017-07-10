package org.fkit.service.impl;

import java.util.List;

import org.fkit.domain.Timecard;
import org.fkit.mapper.TcMapper;
import org.fkit.service.TcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TcServiceImpl implements TcService {

	@Autowired
	private TcMapper tcMapper;
	
	@Override
	public List<Timecard> findWithDate(
			List<Integer> yearLst,
			String inputStartDatetime, String inputEndDatetime, String inputKeyword,
			int page, int rows) {
		return tcMapper.findWithDate(yearLst, inputStartDatetime, inputEndDatetime, inputKeyword, page, rows);
	}
	
	@Override
	public int countBySpec(
			List<Integer> yearLst, 
			String inputStartDatetime, 
			String inputEndDatetime, 
			String inputKeyword) {
		return tcMapper.countBySpec(yearLst, inputStartDatetime, inputEndDatetime, inputKeyword);
	}

}
