package com.mt.dataanalysis.respository;

import java.util.Date;
import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.mt.dataanalysis.Model.DErrcount;
import com.mt.dataanalysis.Model.DErritemDTO;
import com.mt.dataanalysis.Model.DErritemlist;


public interface d_erritemlist_respository extends JpaRepository<DErritemlist, Integer>,JpaSpecificationExecutor<DErritemlist> {
	
	
	  public List<DErritemlist> findByGroupNo(Integer groupNo) ;
	  public Page<DErritemlist> findByGroupNo(Integer groupNo,org.springframework.data.domain.Pageable pr) ;
	  
	  public List<DErritemlist> findAll(Specification<DErritemlist> spe);
	  public Page<DErritemlist> findAll(Specification<DErritemlist> spe,org.springframework.data.domain.Pageable pr);
	  
	  @Query(value = "SELECT new com.mt.dataanalysis.Model.DErritemDTO( b.errName,a.errType,a.errLocation,a.imageName,a.errClass) FROM DErritemlist a,DErrtypeinfo b where a.groupNo=?1 and a.errType=b.errType Order by ?#{#pr}")
	  public List<DErritemDTO> GetErrByGroupNo(Integer groupNo,Pageable pr);
	  
	  @Query(value = "SELECT distinct(a.errDescript) FROM DErritemlist a where a.errDescript is not null")
	  public List<String> GetErrDescript();
	  
	  @Query(value = "SELECT distinct(a.algDescript) FROM DErritemlist a ")
	  public List<String> GetALgDescript();
	  
	  @Query(value = "SELECT count(*) FROM DErritemlist a where a.groupNo=?1")
	  public int GetErrCount(Integer groupNo);
	  
	  
	  
	  @Query(value = "SELECT a.*  FROM d_erritemlist a where  exCodeNum between ?1 and ?2 and exCode=?3 and static<>1 and productType=?4  and  dRecordCreationDate between ?5 and ?6 order by exCodeNum,pages desc,temp3,ErrClass desc",nativeQuery=true)
	  public List<DErritemlist> GetErritemList(int startCode,int endCode,String head,String productType,Date startDate,Date endDate);
 

}
