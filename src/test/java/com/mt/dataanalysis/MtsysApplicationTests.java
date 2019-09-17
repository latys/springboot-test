package com.mt.dataanalysis;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.mt.dataanalysis.Model.DCheckResult;
import com.mt.dataanalysis.Model.DErrcount;
import com.mt.dataanalysis.Model.DErritemDTO;
import com.mt.dataanalysis.Model.DErritemlist;
import com.mt.dataanalysis.Model.DGroupset;
import com.mt.dataanalysis.Service.ICheckResultService;
import com.mt.dataanalysis.Service.MTPYCheckResult;
import com.mt.dataanalysis.Util.CodeUntil;
import com.mt.dataanalysis.respository.DErrcount_respository;
import com.mt.dataanalysis.respository.DGroupset_respository;
import com.mt.dataanalysis.respository.d_erritemlist_respository;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class MtsysApplicationTests {


	@Autowired DGroupset_respository group_res;
	@Autowired d_erritemlist_respository erritem_res;
	@Autowired DErrcount_respository errcount_res;
	
	@Test
	public void test1()
	{
		Pageable pr = new PageRequest(0,2);
		    
		List<DGroupset> list = group_res.findAll(pr).getContent();
		for(DGroupset l:list)
		{
			System.out.println(l.toString());
		}
		  
		System.out.println("123");
	}

	@Test
	public void test2()
	{
		ICheckResultService crs=new MTPYCheckResult();
		
		List<DCheckResult> res=crs.GetCheckResult(1,15);
		
		for(DCheckResult re:res)
		{
			System.out.println(re.toString());
		}
		
		System.out.println("1234");
	}
	
	@Test 
	public void testGetCode()
	{
		List<DErrcount> testData=new ArrayList<>();
		DErrcount tmp=new DErrcount();
		tmp.setCodeStart(5624003);
		tmp.setCodeEnd((5624147));
		tmp.setPageNum(2);
		tmp.setWorkId(1);
		
		
		DErrcount tmp1=new DErrcount();
		tmp1.setCodeStart(5624149);
		tmp1.setCodeEnd((5624341));
		tmp1.setPageNum(2);
		tmp1.setWorkId(1);
		
		DErrcount tmp2=new DErrcount();
		tmp2.setCodeStart(5624345);
		tmp2.setCodeEnd((5624497));
		tmp2.setPageNum(2);
		tmp2.setWorkId(1);
		
		testData.add(tmp);
		testData.add(tmp1);
		testData.add(tmp2);
		
		
	/*	for(int i=0;i<50;i++)
		{
			DErrcount tmp=new DErrcount();
			tmp.setCodeStart(i*10+1);
			tmp.setCodeEnd((i*10+7));
			
			testData.add(tmp);
		}*/
		for(DErrcount r: testData)
		{
			System.out.println(r.getCodeStart()+":"+r.getCodeEnd());
		}
		
		CodeUntil until=new CodeUntil();
		List<DErrcount> rErrcounts=until.getUncheckCode(testData, 5624001, 5624500, 2);
		System.out.println("rErrcounts:"+rErrcounts.size());
		for(DErrcount r: rErrcounts)
		{
			System.out.println(r.getCodeStart()+":"+r.getCodeEnd());
		}
	}
	
	@Test
	public void testgroup()
	{
		Pageable pr = new PageRequest(0,2);
		List<DErritemlist> group=erritem_res.findByGroupNo(new Integer(100),pr).getContent();
		for(DErritemlist list:group)
		{
			System.out.println(list.toString());
		}
	}
	
	@Test
	public void testTime()
	{
		
		List<DErrcount> group=errcount_res.test2("2019-01-01");
		System.out.println("DErrcount:"+group.size());
		for(DErrcount list:group)
		{
			System.out.println(list.toString());
		}
	}
	
	
	@Test
	public void testGetErrCountBySingleGZ()
	{
		
		List<DErrcount> group=errcount_res.GetErrCountBySingleGZ(1000001,1000500,"1","2019-01-01","2019-02-28",0);
		System.out.println("dddd:"+group.size());
		for(DErrcount list:group)
		{
			System.out.println(list.toString());
		}
		
	}
	
	@Test
	public void testGetErrByGroupNo()
	{
		Pageable pr = new PageRequest(0,2);
		List<DErritemDTO> res=erritem_res.GetErrByGroupNo(new Integer(100), pr);
		for(DErritemDTO objects :res)
		{
		
			System.out.println(objects.toString());
		}
	}
}

