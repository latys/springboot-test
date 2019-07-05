package com.mt.dataanalysis;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.dataanalysis.Model.DCheckResult;
import com.mt.dataanalysis.Model.DErritemDTO;
import com.mt.dataanalysis.Model.DErritemlist;
import com.mt.dataanalysis.Model.DErrtypeinfo;
import com.mt.dataanalysis.Model.DGroupset;
import com.mt.dataanalysis.Service.DErritemlistService;
import com.mt.dataanalysis.Service.ICheckResultService;
import com.mt.dataanalysis.Service.MTPYCheckResult;
import com.mt.dataanalysis.Service.MTPYPrintService;
import com.mt.dataanalysis.respository.DErrtypeinfo_respository;
import com.mt.dataanalysis.respository.DGroupset_respository;
import com.mt.dataanalysis.respository.d_erritemlist_respository;

@RestController  // 添加了一个注解
public class MainController {

	@Value("${test}")
	private String msg;
	
	@Autowired  
    private d_erritemlist_respository res;  
	
	@Autowired  
    private DGroupset_respository group_res; 
	
	@Autowired
	private DErrtypeinfo_respository errType_res;
	
	@Autowired
	private DErritemlistService erritemservice;
	
	
	@Autowired  
    private MTPConf mtpconf; 
	
	@Autowired
    JmsTemplate  jmsTemplate;
	
	@RequestMapping("/getuser")
    public List<DErritemlist> hello(){
		
		
		List<DErritemlist> erritemlist=res.findAll();
		jmsTemplate.send("my-destination",new Msg());
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

		System.out.println(batchno);
		List<DErritemlist> erritemlists=res.findByGroupNo(new Integer(batchno));
		
		return erritemlists.size();
    }
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getallbatchnodetailbyCondition")
    public int getallbatchnodetail(String batchno,String algType,String errName,String errLevel,String isDelete){

		System.out.println(batchno);
		
		
		return erritemservice.getallbatchnodetail(batchno, algType, errName, errLevel, isDelete);
    }
	
	
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getbatchnodetail")
    public List<String> getbatchnodetail(int batchno,int page,int limit){

		List<String> lstpath=new ArrayList<String>();
	    List<DGroupset> groups=	group_res.findByGroupNO(batchno);
	    
	    Pageable pr = new PageRequest(page-1,limit);
	    List<DErritemlist> erritemlists=res.findByGroupNo(new Integer(batchno),pr).getContent();
	    for(DErritemlist items:erritemlists)
	    {
	    	lstpath.add(items.getImageName());
	    }
	/*	for(DGroupset group:groups)
		{
			lstpath.add(group.getPicPath());
		}*/
		/*if(page==2)
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
		}*/
	
		return lstpath;
    }
	
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getErrDetail")
    public List<DErritemDTO> getErrDetail(int batchno,
    		 @RequestParam(required=false,defaultValue="1") int page,
	            @RequestParam(required=false,defaultValue="15") int limit){

		List<String> lstpath=new ArrayList<String>();
	    List<DGroupset> groups=	group_res.findByGroupNO(batchno);
	    
	    Pageable pr = new PageRequest(page-1,limit);
	    List<DErritemDTO> erritemlists=res.GetErrByGroupNo(new Integer(batchno), pr);
	  

	
		return erritemlists;
    }
	
	@CrossOrigin(origins = "*", maxAge = 3600)
	@RequestMapping("/getErrDetailbyCondition")
	List<DErritemDTO> getErrDetail(int batchno,String algType,String errName,String errLevel,String isDelete,
	   		 @RequestParam(required=false,defaultValue="1") int page,
		            @RequestParam(required=false,defaultValue="15") int limit){
		return erritemservice.getErrDetail(batchno, algType, errName, errLevel, isDelete, page, limit);
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
	
	 @CrossOrigin(origins = "*", maxAge = 3600) 	
	 @RequestMapping(value = "/getimage",produces = MediaType.IMAGE_JPEG_VALUE)
	 @ResponseBody
	 public byte[] getImage(String filename,@RequestParam(required=false,defaultValue="") String errLocation) throws IOException {
	 /*File file = new File("D:/test3.jpg");
	 FileInputStream inputStream = new FileInputStream(file);
	 byte[] bytes = new byte[inputStream.available()];
	 inputStream.read(bytes, 0, inputStream.available());*/
	 
	  
       BufferedImage image = ImageIO.read(new File(filename));
       Graphics g = image.getGraphics();
       Graphics2D g2 = (Graphics2D)g;  //g是Graphics对象
	   g2.setStroke(new BasicStroke(8.0f));
		
	   g2.setColor(Color.red);
       if(errLocation!=null&&!errLocation.isEmpty())
       {
    	   String[] strings=errLocation.split(",");
    	   if(strings.length==4)
    	   {
    		   g2.drawRect(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), Integer.parseInt(strings[2])-Integer.parseInt(strings[0]), Integer.parseInt(strings[3])-Integer.parseInt(strings[1]));//矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
    	   }
       }
	

      
       
       ByteArrayOutputStream out = new ByteArrayOutputStream();
       try {
       ImageIO.write(image, "jpg", out);
       } catch (IOException e) {
       e.printStackTrace();
       }
       return out.toByteArray();
	
     }
	 
	 
	 @CrossOrigin(origins = "*", maxAge = 3600) 
	 @RequestMapping("/GenPrintContent")
	 public List<String> genPrintContent(String startCode,String printCount,String GZ,String startDate,String endDate,String firstGZPos,String secondGZPos) throws ParseException
	 {
		 MTPYPrintService mtp=new MTPYPrintService();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 Date start=sdf.parse(startDate);
		 Date end=sdf.parse(endDate);
		 Integer fgzpos=Integer.parseInt(firstGZPos);
		 Integer sgzpos=Integer.parseInt(secondGZPos);
		 Integer startcode=Integer.parseInt(startCode);
		 Integer printcount=Integer.parseInt(printCount);
	
		 return mtp.genPrintContent(startcode, printcount, GZ, start, end, fgzpos, sgzpos);
	 }


	 @CrossOrigin(origins = "*", maxAge = 3600) 
	 @RequestMapping("/getConf")
	 public MTPConf getConf()
	 {
		 return mtpconf;
	 }
	 
	 @CrossOrigin(origins = "*", maxAge = 3600) 
	 @RequestMapping("/test")
	 public String test()
	 {
		 return msg;
	 }
	 
	 /**
	 * 获取所有缺陷类型
	 * @return
	 */
	 @CrossOrigin(origins = "*", maxAge = 3600) 
	 @RequestMapping("/getAllErrtype")
	 public List<String> getAllErrtype()
	 {
		 return res.GetErrDescript();
	 }
	 
	 /**
	 * 获取所有算法类型
	 * @return
	 */
	 @CrossOrigin(origins = "*", maxAge = 3600) 
	 @RequestMapping("/getAllAlgtype")
	 public List<String> getAllALgtype()
	 {
		 return res.GetALgDescript();
	 }
	 
	 

}
