package com.mt.dataanalysis.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.mt.dataanalysis.Model.DErrcount;


@Component
public class CodeUntil {
	
	//根据已检号段获取未检号段
	public List<DErrcount> getUncheckCode(List<DErrcount> errs,int startcode,int endcode,int GAdd)
	{
		List<DErrcount> unCheckedCodes=new ArrayList<DErrcount>();
		
		int start=0;
		int end=0;
		int startfrom=1;
		int endto=0;
		
		for(DErrcount err :(errs))
		{
			if(err.getCodeEnd()<err.getCodeStart())
			{
				
			}
//			else if(err.getCodeEnd()>endcode&&endcode!=0)
//			{
//				startfrom=501;
//				endto=499;
//				break;
//			}
			else {
				int iCodeStart=err.getCodeStart();
				if(iCodeStart<startcode)
				{
					iCodeStart=startcode+1;
				}
				if(iCodeStart%500<startfrom)
				{
					iCodeStart=startfrom;
				}
				if(iCodeStart%500>=startfrom+GAdd)
				{
					DErrcount tmp=new DErrcount();
					tmp.setCodeStart(iCodeStart/500*500+startfrom);
					tmp.setCodeEnd(iCodeStart-GAdd);
					tmp.setPageNum(err.getPageNum());
					tmp.setWorkId(err.getWorkId());
					unCheckedCodes.add(tmp);
				}
				
				startfrom=err.getCodeEnd()%500+GAdd;
				endto=err.getCodeEnd()%500;
			}
			
			
		/*	if(start==0&&end==0)
			{
				start=err.getCodeStart();
				end=err.getCodeEnd();
			}
			else {
				if(err.getCodeStart()<start&&err.getCodeEnd()>=start)
				{
					start=err.getCodeStart();
					end=Max(end,err.getCodeEnd());
				}
			}
			err.getCodeStart();
			err.getCodeEnd();*/
		}
		
		if(endto!=499&&startfrom<500)
		{
			int count=errs.size();
			if(count>0)
			{
				int ip1=errs.get(count-1).getCodeEnd()/500*500+startfrom;
				int ip2=errs.get(count-1).getCodeEnd()/500*500+499;
				if(ip1>=startcode&&ip1<=endcode&&ip2>=startcode&&ip2<=endcode)
				{
					DErrcount tmp=new DErrcount();
					tmp.setCodeStart(ip1);
					tmp.setCodeEnd(ip2);
					tmp.setPageNum(errs.get(count-1).getPageNum());
					tmp.setWorkId(errs.get(count-1).getWorkId());
					unCheckedCodes.add(tmp);
				}
			}
		}
		
		return unCheckedCodes;
		
	}

	
	public Map<String, String> GetCodeFromDigit(String head,int startCode,int endCode,int firstGZPos,int secondGZPos)
	{
		Map<String, String> map = new HashMap<String, String>();
		String strStartCode="";
		String strEndCode="";
		if(head.length()==1)
    	{
			StringBuilder start=new StringBuilder(String.format("%08d", startCode));
    		start.insert(firstGZPos, head);
    		StringBuilder end=new StringBuilder(String.format("%08d", endCode));
    		end.insert(firstGZPos, head);
    		
    		strStartCode=start.toString();
    		strEndCode=end.toString();

    	}
    	else
    	{
    		StringBuilder start=new StringBuilder(String.format("%07d", startCode));
    		start.insert(firstGZPos, head.charAt(0));
    		start.insert(secondGZPos, head.charAt(1));
    		StringBuilder end=new StringBuilder(String.format("%07d", endCode));
    		end.insert(firstGZPos, head.charAt(0));
    		end.insert(secondGZPos, head.charAt(1));
    		strStartCode=start.toString();
    		strEndCode=end.toString();
    	
    	}
		
		map.put(strStartCode, strEndCode);
		return map;
		
	}


}
