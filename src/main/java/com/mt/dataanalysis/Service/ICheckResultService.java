package com.mt.dataanalysis.Service;

import java.util.List;

import com.mt.dataanalysis.Model.DCheckResult;

public interface ICheckResultService {
	
	public int GetAllCheckResultCount();
	public List<DCheckResult> GetAllCheckResult();
	public List<DCheckResult> GetCheckResult(int page,int limit);

}
