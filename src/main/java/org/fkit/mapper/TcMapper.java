package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fkit.domain.Timecard;

public interface TcMapper {
	
	List<Timecard> findWithDate(
			@Param("yearLst") List<Integer> yearLst,
			@Param("inputStartDatetime") String inputStartDatetime, 
			@Param("inputEndDatetime") String inputEndDatetime,
			@Param("inputKeyword") String inputKeyword,
			@Param("page") int page,
			@Param("rows") int rows
	);
	
	int countBySpec(
			@Param("yearLst") List<Integer> yearLst,
			@Param("inputStartDatetime") String inputStartDatetime, 
			@Param("inputEndDatetime") String inputEndDatetime,
			@Param("inputKeyword") String inputKeyword
	);
	
}
