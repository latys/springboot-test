package com.mt.dataanalysis.Service;

import static org.assertj.core.api.Assertions.in;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.mt.dataanalysis.Model.DErritemDTO;
import com.mt.dataanalysis.Model.DErritemlist;
import com.mt.dataanalysis.Model.DErrtypeinfo;
import com.mt.dataanalysis.Model.DGroupset;
import com.mt.dataanalysis.respository.DErrtypeinfo_respository;
import com.mt.dataanalysis.respository.d_erritemlist_respository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class DErritemlistService {




	@Autowired 
	private d_erritemlist_respository res;
	
	@Autowired
	private DErrtypeinfo_respository  errtypeinfo_respository;
	
	private HashMap<Integer, String> errTypeMap;
	
	

	
	
    public int getallbatchnodetail(String batchno,String algType,String errName,String errLevel,String isDelete){

    	System.out.println(batchno);
    	if(res==null) {
    		System.out.println("res is null");
    		return 0;
    	}
    	List<DErritemlist> erritemlists= res.findAll(new Specification<DErritemlist>() {

			@Override
			public Predicate toPredicate(Root<DErritemlist> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				int errType=-1;
				
//				if(errName!=null) {
//					List<DErrtypeinfo> tDErrtypeinfos=errtypeinfo_respository.findByErrName(errName);
//					if(tDErrtypeinfos!=null&&tDErrtypeinfos.size()>0) {
//						errType=tDErrtypeinfos.get(0).getErrType();
//					}
//				}
			
				// TODO Auto-generated method stub
			    List<Predicate> predicatesList = new ArrayList<>();
			    predicatesList.add((Predicate) criteriaBuilder.equal(root.get("groupNo").as(Integer.class),new Integer(batchno)));
			    if(""!=errName && null!=errName&&!errName.equals("全部")){
					 /*Join<DErrtypeinfo, DErritemlist> join = root.join("DErrtypeinfo", JoinType.LEFT);
					 predicatesList.add(criteriaBuilder.equal(join.get("errName"), errType));*/
				     predicatesList.add((Predicate) criteriaBuilder.equal(root.get("errDescript").as(String.class),errName));
				 }
				 if(""!=algType && null!=algType&&!algType.equals("全部")){
				     predicatesList.add((Predicate) criteriaBuilder.equal(root.get("algType").as(String.class),algType));
				 }
				 if(""!=isDelete && null!=isDelete&&!isDelete.equals("全部")){
					 if(isDelete.equals("已删除"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.notEqual(root.get("static_").as(String.class),"0"));
					 }
					 if(isDelete.equals("未删除"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.equal(root.get("static_").as(String.class),"0"));
					 }
				     
				 }
				 if(""!=errLevel && null!=errLevel&&!errLevel.equals("全部")){
					 if(errLevel.equals("警告"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.between(root.get("errClass").as(Integer.class), 1, 3));
					 }
					 if(errLevel.equals("一般"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.between(root.get("errClass").as(Integer.class), 4, 6));
					 }
					 if(errLevel.equals("严重"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.ge(root.get("errClass").as(Integer.class), 7));
					 }

				 }
				 Predicate[] p = new Predicate[predicatesList.size()];
				 return criteriaBuilder.and((javax.persistence.criteria.Predicate[]) predicatesList.toArray(p));

			}
		});
		
		return erritemlists.size();
    }
    
    
    public List<DErritemDTO> getErrDetail(int batchno,String algType,String errName,String errLevel,String isDelete,
   		 @RequestParam(required=false,defaultValue="1") int page,
	            @RequestParam(required=false,defaultValue="15") int limit){

    	if(res==null) {
    		System.out.println("res is null");
    		return new ArrayList<DErritemDTO>();
    	}
    	Sort sort = new Sort(Direction.ASC, "errClass");
	    Pageable pr = new PageRequest(page-1,limit,sort);
		List<DErritemlist> erritemlists= res.findAll(new Specification<DErritemlist>() {

			@Override
			public Predicate toPredicate(Root<DErritemlist> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				int errType=-1;
				
//				if(errName!=null) {
//					List<DErrtypeinfo> tDErrtypeinfos=errtypeinfo_respository.findByErrName(errName);
//					if(tDErrtypeinfos!=null&&tDErrtypeinfos.size()>0) {
//						errType=tDErrtypeinfos.get(0).getErrType();
//					}
//				}
			
				// TODO Auto-generated method stub
			    List<Predicate> predicatesList = new ArrayList<>();
			    predicatesList.add((Predicate) criteriaBuilder.equal(root.get("groupNo").as(Integer.class),new Integer(batchno)));
			    if(""!=errName && null!=errName&&!errName.equals("全部")){
					 /*Join<DErrtypeinfo, DErritemlist> join = root.join("DErrtypeinfo", JoinType.LEFT);
					 predicatesList.add(criteriaBuilder.equal(join.get("errName"), errType));*/
				     predicatesList.add((Predicate) criteriaBuilder.equal(root.get("errDescript").as(String.class),errName));
				 }
				 if(""!=algType && null!=algType&&!algType.equals("全部")){
				     predicatesList.add((Predicate) criteriaBuilder.equal(root.get("algType").as(String.class),algType));
				 }
				 if(""!=isDelete && null!=isDelete&&!isDelete.equals("全部")){
					 if(isDelete.equals("已删除"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.notEqual(root.get("static_").as(String.class),"0"));
					 }
					 if(isDelete.equals("未删除"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.equal(root.get("static_").as(String.class),"0"));
					 }
				     
				 }
				 if(""!=errLevel && null!=errLevel&&!errLevel.equals("全部")){
					 if(errLevel.equals("警告"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.between(root.get("errClass").as(Integer.class), 1, 3));
					 }
					 if(errLevel.equals("一般"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.between(root.get("errClass").as(Integer.class), 4, 6));
					 }
					 if(errLevel.equals("严重"))
					 {
						 predicatesList.add((Predicate) criteriaBuilder.ge(root.get("errClass").as(Integer.class), 7));
					 }

				 }
				 Predicate[] p = new Predicate[predicatesList.size()];
				 return criteriaBuilder.and((javax.persistence.criteria.Predicate[]) predicatesList.toArray(p));

			}
		},pr ).getContent();
		
//		errTypeMap=new HashMap<>();
//		List<DErrtypeinfo> tDErrtypeinfos= errtypeinfo_respository.findAll();
//		for(DErrtypeinfo type:tDErrtypeinfos)
//		{
//			if(!errTypeMap.containsKey(new Integer(type.getErrType())))
//			{
//				errTypeMap.put(type.getErrType(), type.getErrName());
//			}
//		}
		
	    List<DErritemDTO> erritemDtos=new ArrayList<>();
	    for(DErritemlist erritemlist:erritemlists)
	    {
//	    	String ErrorName="";
//	    	if(errTypeMap.containsKey(new Integer(erritemlist.getErrType())))
//	    	{
//	    		ErrorName=errTypeMap.get(new Integer(erritemlist.getErrType()));
//	    	}
	    	DErritemDTO erritemDto=new DErritemDTO(erritemlist.getErrDescript(),erritemlist.getErrType(),erritemlist.getErrLocation(),erritemlist.getImageName());

	    	erritemDtos.add(erritemDto);
	    }

		return erritemDtos;
   }
	
}
