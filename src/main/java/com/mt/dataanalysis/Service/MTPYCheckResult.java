package com.mt.dataanalysis.Service;

import java.util.ArrayList;
import java.util.List;

import com.mt.dataanalysis.Model.DCheckResult;

public  class MTPYCheckResult implements ICheckResultService {

	@Override
	public List<DCheckResult> GetAllCheckResult() {
		
		List<DCheckResult> res=new ArrayList<DCheckResult>();
		for(int i=0;i<200;i++)
		{
		DCheckResult dcr=new DCheckResult();
		dcr.setErrCount(100);
		dcr.setBatchno("100100");
		dcr.setTotalCount(1000);
		res.add(dcr);
		}
		return res;
	}

	@Override
	public List<DCheckResult> GetCheckResult(int page, int limit) {
		// TODO Auto-generated method stub
		
		List<DCheckResult> res=new ArrayList<DCheckResult>();
		for(int i=0;i<limit;i++)
		{
		DCheckResult dcr=new DCheckResult();
		dcr.setErrCount(100);
		dcr.setBatchno("100100");
		dcr.setTotalCount(1000);
		res.add(dcr);
		}
		return res;
	}

	@Override
	public int GetAllCheckResultCount() {
		// TODO Auto-generated method stub
		return 200;
	}
	
}
