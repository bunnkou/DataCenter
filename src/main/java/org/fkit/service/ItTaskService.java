package org.fkit.service;

import java.util.List;
import org.fkit.domain.ItTask;

public interface ItTaskService {
	/*
	���ݿ�ʼʱ��ͽ���ʱ���ѯ����
	@param String inputStartDatetime
	@param String inputEndDatetime
	@return �ҵ����� ItTask ����û���ҵ����� NULL
	*/
	List<ItTask> findWithCDateTime(String inputStartDatetime, String inputEndDatetime);
}
