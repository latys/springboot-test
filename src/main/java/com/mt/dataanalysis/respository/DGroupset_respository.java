package com.mt.dataanalysis.respository;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mt.dataanalysis.Model.DGroupset;
import com.mt.dataanalysis.Model.DCheckResult;

public interface DGroupset_respository extends JpaRepository<DGroupset,Integer>{
	 /* @Query(value = "SELECT * FROM D_Groupset a group by a.guid limit 0 5")
	  public List<DGroupset> findTopGroupsetGuid();*/
	  public List<DGroupset> findByGroupNO(int groupno);
	  
	  public List<DGroupset> findByHead(String head);
	  
	 /* @Query(value = "SELECT DGroupset FROM D_Groupset a where head=?1 and temp4=?2 and temp5=?3 ")
	  public List<DGroupset> findByHeadPos(String head,Integer firsheadPos,Integer secondheadPos );*/
/*	  @Query(value = "SELECT new com.mt.dataanalysis.Model.DCheckResult(a.batchno) FROM D_Groupset a")
	  public List<DCheckResult> findViewInfo();*/
	
      
}

