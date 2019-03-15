package com.mt.dataanalysis.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.dataanalysis.Model.DErrtypeinfo;

public interface DErrtypeinfo_respository extends JpaRepository<DErrtypeinfo,Integer>{
      public List<DErrtypeinfo> findByErrType(int errType);
}
