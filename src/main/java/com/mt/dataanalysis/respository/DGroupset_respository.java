package com.mt.dataanalysis.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mt.dataanalysis.Model.DGroupset;
import com.mt.dataanalysis.Model.DCheckResult;

public interface DGroupset_respository extends JpaRepository<DGroupset,Integer>{

	  @Query(value = "SELECT new com.johnfnash.learn.domain.ViewInfo(u, a) FROM UserInfo u, Address a WHERE u.addressId = a.addressId")
	  public List<DCheckResult> findViewInfo();
}

