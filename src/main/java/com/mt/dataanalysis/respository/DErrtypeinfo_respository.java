package com.mt.dataanalysis.respository;

import java.util.List;

import org.apache.activemq.broker.PublishedAddressPolicy;
import org.junit.validator.PublicClassValidator;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.dataanalysis.Model.DErrtypeinfo;

public interface DErrtypeinfo_respository extends JpaRepository<DErrtypeinfo,Integer>{
      public List<DErrtypeinfo> findByErrType(int errType);
      
      public List<DErrtypeinfo> findByErrName(String errName); 
}
