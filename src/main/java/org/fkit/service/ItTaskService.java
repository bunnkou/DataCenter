package org.fkit.service;

import java.util.List;
import org.fkit.domain.ItTask;

public interface ItTaskService {
	/*
	根据开始时间和结束时间查询任务单
	@param String inputStartDatetime
	@param String inputEndDatetime
	@return 找到返回 ItTask 对象，没有找到返回 NULL
	*/
	List<ItTask> findWithCDateTime(String inputStartDatetime, String inputEndDatetime);
}
