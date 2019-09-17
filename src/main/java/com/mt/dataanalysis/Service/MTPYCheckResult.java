package com.mt.dataanalysis.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.mt.dataanalysis.Model.DCheckResult;
import com.mt.dataanalysis.Model.DGroupset;
import com.mt.dataanalysis.respository.DGroupset_respository;
import com.mt.dataanalysis.respository.d_erritemlist_respository;
@Component
public  class MTPYCheckResult implements ICheckResultService {
	
	@Autowired 
	DGroupset_respository group_res;
	@Autowired 
	d_erritemlist_respository erritem_res;

	private static MTPYCheckResult  MTPYcheckResult ;
	
	@PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {  
		MTPYcheckResult = this;  
		MTPYcheckResult.group_res = this.group_res;  
		MTPYcheckResult.erritem_res = this.erritem_res;  
        // 初使化时将已静态化的testService实例化
    }  

	@Override
	public List<DCheckResult> GetAllCheckResult() {
		
		List<DCheckResult> res=new ArrayList<DCheckResult>();
		for(int i=0;i<20;i++)
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
		Sort sort = new Sort(Direction.DESC, "groupNO");
	    Pageable pr = new PageRequest(page-1,limit,sort);
	    
	    List<DGroupset> list = MTPYcheckResult.group_res.findAll(pr).getContent();
        
	    for(DGroupset ls : list)
	    {
	        int err_count=MTPYcheckResult.erritem_res.GetErrCount(ls.getGroupNO());
	        NumberFormat numberFormat = NumberFormat.getInstance();  
	        numberFormat.setMaximumFractionDigits(2);  
	        
	        if(ls.getPages()!=0)
	        {
	          String err_rate=numberFormat.format((float) err_count / (float) ls.getPages() * 100); 
	        }
			DCheckResult dcr=new DCheckResult();
			dcr.setErrCount(err_count);
			dcr.setBatchno(Integer.toString(ls.getGroupNO()));
			dcr.setTotalCount(1000);
			dcr.setStartCode(ls.getHead()+ls.getFirstCode());
			res.add(dcr);
	    }

		
		//测试
	/*	for(int i=0;i<limit;i++)
		{
		DCheckResult dcr=new DCheckResult();
		dcr.setErrCount(100);
		dcr.setBatchno("100100");
		dcr.setTotalCount(1000);
		res.add(dcr);
		}*/
		return res;
	}

	@Override
	public int GetAllCheckResultCount() {
		// TODO Auto-generated method stub
		//List<DCheckResult> res=new ArrayList<DCheckResult>();
		return (int)MTPYcheckResult.group_res.count();
	   
	}
	
}
