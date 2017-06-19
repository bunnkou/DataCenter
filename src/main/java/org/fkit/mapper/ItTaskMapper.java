package org.fkit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.fkit.domain.ItTask;

public interface ItTaskMapper {
		
	List<ItTask> findWithCDateTime(
			@Param("inputStartDatetime") String inputStartDatetime, 
			@Param("inputEndDatetime") String inputEndDatetime,
			@Param("inputKeyword") String inputKeyword,
			@Param("page") int page,
			@Param("rows") int rows
	);
	
	int countBySpec(
			@Param("inputStartDatetime") String inputStartDatetime, 
			@Param("inputEndDatetime") String inputEndDatetime,
			@Param("inputKeyword") String inputKeyword
	);
	
}
