package com.mt.dataanalysis.respository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mt.dataanalysis.Model.DErrcount;


public interface DErrcount_respository extends JpaRepository<DErrcount, Integer> {

	
	 @Query(value = "SELECT a.* FROM d_errcount a  where a.codeStart between ?1 and ?2 and temp1=?3 and dRecordCreationDate between ?4 and ?5 and workid=?6 order by codeStart,pageNum",nativeQuery=true)
	 public List<DErrcount> GetErrCountBySingleGZ(int startCode,int endCode,String productType,String startDate,String endDate,int workid);
	 
	 @Query(value = "SELECT a.* FROM d_errcount a  where a.codeStart between ?1 and ?2 and temp1=?3 and dRecordCreationDate between ?4 and ?5   and groupNo in (select groupNo from d_groupset where head=?6) and workid=?7 order by codeStart,pageNum",nativeQuery=true)
	 public List<DErrcount> GetErrCountByDoubleGZ(Integer startCode,Integer endCode,String productType,Date startDate,Date endDate,String head,int workid);
	 
	 @Query(value = "SELECT a FROM DErrcount a  where DATEDIFF(a.dRecordCreationDate, ?1)>0 ")
	 public List<DErrcount> test(Date startDate);
	 
	 @Query(value = "SELECT a.* FROM d_errcount a  where a.dRecordCreationDate> ?1 ",nativeQuery=true)
	 public List<DErrcount> test2(String startDate);
	 
	 
}
