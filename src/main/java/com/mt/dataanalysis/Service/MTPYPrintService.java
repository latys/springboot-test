package com.mt.dataanalysis.Service;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.dataanalysis.MTPConf;
import com.mt.dataanalysis.Model.DErrcount;
import com.mt.dataanalysis.Model.DErritemlist;
import com.mt.dataanalysis.Model.DErrtypeinfo;
import com.mt.dataanalysis.Util.CodeUntil;
import com.mt.dataanalysis.respository.DErrcount_respository;
import com.mt.dataanalysis.respository.DErrtypeinfo_respository;
import com.mt.dataanalysis.respository.d_erritemlist_respository;

@Service
public class MTPYPrintService {
	
	@Autowired DErrcount_respository res;
	@Autowired d_erritemlist_respository erritem_res;
	@Autowired DErrtypeinfo_respository  errType_res;
	@Autowired MTPConf conf;
	
	private static  MTPYPrintService  mtpyPrintService;
	
	
	@PostConstruct //通过@PostConstruct实现初始化bean之前进行的操作
    public void init() {  
		mtpyPrintService = this;  
		mtpyPrintService.res = this.res;  
		mtpyPrintService.erritem_res = this.erritem_res;  
		mtpyPrintService.errType_res=this.errType_res;
		mtpyPrintService.conf=this.conf;
        // 初使化时将已静态化的testService实例化
    }  

	
	public List<String> genPrintContent(Integer startCode,Integer printCount,String gz,Date startDate,Date endDate,Integer firstGZPos,Integer secondGZPos)
	{
	    List<String> printContent=new ArrayList<String>();
	    List<String> stopMachineErr=new ArrayList<>();
	    boolean []unchecked=new boolean[100];
	    boolean allcodechecked=true;
	    int line=0;
	
	
	    CodeUntil until=new CodeUntil();
	    //标题
	    printContent.add(mtpyPrintService.conf.getMachineName()+mtpyPrintService.conf.getProductName()+"在线检测");
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    printContent.add("打印时间："+df.format(new Date()));
	    
	    for(Integer i=0;i<printCount;i++)
	    {
	     
	        for(int k=0;k<100;k++)
		    {
		    	unchecked[k]=true;
		    }
	        //14工位不打印
	        unchecked[14]=false;
	    	int checkworkstationCount=0;
	    	line=0;
	    	Map<String,String> map=until.GetCodeFromDigit(gz, startCode.intValue()+i*500, startCode.intValue()+i*500+499, firstGZPos, secondGZPos);
	    	for(String key:map.keySet())
	    	{
	    		printContent.add("开始号码："+key);
	    		printContent.add("结束号码："+map.get(key));
	    		
	    	}
	    	

	    	printContent.add("未检号码范围:");
	    	line+=3;
	    	for(int j=0;j<mtpyPrintService.conf.getWorkstationCount();j++)
	    	{
	    		List<DErrcount> errors=new ArrayList<>();
	    		if(gz.length()>=2) {
	        		errors=mtpyPrintService.res.GetErrCountByDoubleGZ(new Integer(startCode.intValue()+i*500), 
	        				new Integer(startCode.intValue()+i*500+499), mtpyPrintService.conf.getProductType(), startDate, endDate,gz,j);
	    		}
	    		else
	    		{
	        		errors=mtpyPrintService.res.GetErrCountBySingleGZ(((startCode.intValue()+i*500)),
	        				(startCode.intValue()+i*500+499), mtpyPrintService.conf.getProductType(), df.format(startDate), df.format(endDate),j);
	    		}
	    		
		    	
		    	List<DErrcount> uncheckedCodes=until.getUncheckCode(errors, startCode.intValue()+i*500, startCode.intValue()+i*500+499, 2);
		    	if(errors.size()>0)
		    	{
		    		checkworkstationCount++;
		    		unchecked[j]=false;
		    	}
		    	
		    	for(DErrcount err:uncheckedCodes)
		    	{
		    		allcodechecked=false;
		    		String strCodeStart="";
					String strCodeEnd="";
		    		Map<String,String> map1=until.GetCodeFromDigit(gz, err.getCodeStart(),err.getCodeEnd(), firstGZPos, secondGZPos);
		    		for(String key : map1.keySet())
			    	{
		    			strCodeStart=key;
		    			strCodeEnd=map1.get(key);
			    	
			    	}
		    	
		    		//14工位不打印
		    		if(err.getWorkId()==13)
		    			continue;
					String content=String.format(" 第%2d工位  页码: %2d  %s-- %s ", j+1,err.getPageNum(),strCodeStart,strCodeEnd);
					line++;
					printContent.add(content);
		    	
		    	}
	    	}
	    	 if(checkworkstationCount<mtpyPrintService.conf.getWorkstationCount())
	 	    {
	 	    	String content=String.format(" 有%d个工位没有检测结果信息",mtpyPrintService.conf.getWorkstationCount()-checkworkstationCount);
	 	    	line++;
	 	    	printContent.add(content);
	 	    	for(int j=0;j<mtpyPrintService.conf.getWorkstationCount();j++)
	 	    	{
	 	    		if(unchecked[j])
	 	    		{

	 	    			content=String.format(" 第%d工位未测",j+1);
	 	    			line++;
	 	    			printContent.add(content);
	 	    		}
	 	    	}
	 	    	allcodechecked=false;
	 	    }
	 	    
	 	    if(allcodechecked)
	 	    {
	 	    	printContent.add("所有号码都被检测了!");
	 	    	line++;
	 	    }
	 	    
	 	    printContent.add("号码检测结果：");
			line++;
			System.out.println((startCode.intValue()+i*500)+"--"+(startCode.intValue()+i*500+499));
	 	    List<DErritemlist> checkedCodes=mtpyPrintService.erritem_res.GetErritemList((startCode.intValue()+i*500), (startCode.intValue()+i*500+499), gz, mtpyPrintService.conf.getProductType(), startDate, endDate);
			List<String> norepeat_checkedCodes=new ArrayList<String>();
			if(checkedCodes.size()>0)
	 	    {
	 	    	for(DErritemlist err:checkedCodes)
	 	    	{
					 String content="";
					 String errCode="";
					 String pageNum="";
					 String dateTime="";

					 String code= String.format("%07d",err.getExCodeNum());
					 if(norepeat_checkedCodes.contains(code))
					 {
						 continue;
					 }
					 else
					 {
						 norepeat_checkedCodes.add(code);
					 }
					 
					//修改数据库在表中增加了缺陷类型描述，不需要再从缺陷表中进行查询
	 	    		String errname=err.getErrDescript();
	 	    		
	 	    		//芯片报警和第14工位号码检测结果不打印
	 	    		if (err.getErrType()==206||(err.getWorkId()==14)) {
						continue;
					}
	 	    		// List<DErrtypeinfo> errtypeinfos=mtpyPrintService.errType_res.findByErrType(err.getErrType());
	 	    		// if(errtypeinfos!=null&&errtypeinfos.size()>0)
	 	    		// {
	 	    		// 	errname=errtypeinfos.get(0).getErrName();
	 	    		// }
	 	    	  	//204是停机  显示号码为检测号码而不是预期号 Add[9/20/2016 WZS]
//	 				if ( err.getErrType()== 204)
//	 				{
//	 					if (err.getErrCode()==null||err.getErrCode()=="") {
//	 						System.out.println(err);
//						}
//	 					if(err.getErrCode().length()>=2)
//	 					{
//	 						if (err.getErrCodeNum() == 0)
//	 						{
//	 							
//	 							StringBuilder str=new StringBuilder(String.format("%06d",err.getExCodeNum()));
//	 							str.insert(err.getTemp4().intValue(), err.getErrCode().charAt(0));
//	 							str.insert(err.getTemp5().intValue(), err.getErrCode().charAt(1));
//	 							str.insert(str.length(), err.getErrCode().charAt(1));
//	 							errCode=str.toString();
//	 							
//	 						
//	 						}
//	 						else
//	 						{
//	 							
//	 							StringBuilder str=new StringBuilder(String.format("%07d",err.getExCodeNum()));
//	 							str.insert(err.getTemp4().intValue(), err.getErrCode().charAt(0));
//	 							str.insert(err.getTemp5().intValue(), err.getErrCode().charAt(1));
//	 							str.insert(str.length(), err.getErrCode().charAt(1));
//	 							errCode=str.toString();
//	 							
//	 						}
//	 					}
//	 					else
//	 					{
//	 						errCode=String.format("%s%08d",err.getErrCode(),err.getExCodeNum());
//	 					}
//	 					line++;
//	 					pageNum=String.format("第%d页", err.getTemp3().intValue());
//	 					String s1=String.format("%-12s", errCode);
//	 					String s2=String.format("%-10s", pageNum);
//	 					String s3=String.format("%-20s", errname);
//	 					
//	 					String s4=String.format("%-25s", err.getdRecordCreationDate().toString());
//	 					content=s1+";"+s2+";"+s3+";"+s4;
//	 					System.out.println(content);
//	 					stopMachineErr.add(content);
//	 				}
//	 				else
	 				{
	 					if(err.getExCode().length()>=2)
	 					{
	 						if (err.getExCodeNum() == 0)
	 						{
	 							
	 							StringBuilder str=new StringBuilder(String.format("%06d",err.getExCodeNum()));
	 							str.insert(err.getTemp4().intValue(), err.getExCode().charAt(0));
	 							str.insert(err.getTemp5().intValue(), err.getExCode().charAt(1));
	 							str.insert(str.length(), err.getExCode().charAt(1));
	 							errCode=str.toString();
	 						
	 						}
	 						else
	 						{
	 							StringBuilder str=new StringBuilder(String.format("%07d",err.getExCodeNum()));
	 							str.insert(err.getTemp4().intValue(), err.getExCode().charAt(0));
	 							str.insert(err.getTemp5().intValue(), err.getExCode().charAt(1));
	 							//str.insert(str.length(), err.getErrCode().charAt(1));
	 							errCode=str.toString();
	 						}
	 					}
	 					else
	 					{
	 						errCode=String.format("%s%08d",err.getExCode(),err.getExCodeNum());
	 					}
	 					line++;
	 					pageNum=String.format("第%d页", err.getTemp3().intValue());
	 					String s1=String.format("%-12s", errCode);
	 					String s2=String.format("%-10s", pageNum);
	 					String s3=String.format("%-20s", errname);
	 					String s4=String.format("%-25s", err.getdRecordCreationDate().toString());
	 					content=s1+";"+s2+";"+s3+";"+s4;
	 					System.out.println(content);
	 					printContent.add(content);
	 				}
	 	    	}
	 	        printContent.addAll(stopMachineErr);
	 	    }
	 	    else
	 	    {
	 	    	 printContent.add("没有错误记录!!");
	 	    	 line++;
	 	    }
	    	
            
	    }
	    
	   
	    return printContent;
	}

}
