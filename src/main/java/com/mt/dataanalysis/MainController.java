package com.mt.dataanalysis;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mt.dataanalysis.Model.DCheckResult;
import com.mt.dataanalysis.Model.DErritemlist;
import com.mt.dataanalysis.Service.ICheckResultService;
import com.mt.dataanalysis.Service.MTPYCheckResult;
import com.mt.dataanalysis.respository.d_erritemlist_respository;

@RestController  // 添加了一个注解
public class MainController {

	@Autowired  
    private d_erritemlist_respository res;  
	
	@RequestMapping("/getuser")
    public List<DErritemlist> hello(){
		
		
		List<DErritemlist> erritemlist=res.findAll();
    	return erritemlist;
    }
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getcheckresult")
    public List<DCheckResult> getcheckresult(){
		
		ICheckResultService crs=new MTPYCheckResult();
	
		List<DCheckResult> res=crs.GetAllCheckResult();
    	return res;
    }
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getallbatchnodetail")
    public int getallbatchnodetail(String batchno){

		return 90;
    }
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getbatchnodetail")
    public List<String> getbatchnodetail(String batchno,int page,int limit){

		List<String> lstpath=new ArrayList<String>();
		if(page==2)
		{
			for(int i=0;i<9;i++)
			{
				lstpath.add("D:\\图像\\现场\\2_0_7_2_153441379.bmp");
			}
		}
		else
		{
			for(int i=0;i<9;i++)
			{
				lstpath.add("D:\\图像\\现场\\1_0_7_1_153440961.bmp");
			}
		}
	
		return lstpath;
    }
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/showdata")
	   public Map<String,Object> methodx(
	            @RequestParam(required=false,defaultValue="1") int page,
	            @RequestParam(required=false,defaultValue="15") int limit,
	            String keyWord
	    ){
		
		ICheckResultService crs=new MTPYCheckResult();
		int count=crs.GetAllCheckResultCount();
		List<DCheckResult> res=crs.GetCheckResult(page,limit);
	        Map<String,Object> map=new HashMap<String,Object>();
	        map.put("code",0);
	        map.put("msg","");
	        map.put("count",count);
	        map.put("data",res);
	        System.out.println(map.toString());
	        return map;
	    }
}
