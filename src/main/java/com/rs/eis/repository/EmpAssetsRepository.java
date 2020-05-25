package com.rs.eis.repository;

import java.util.List;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rs.eis.model.EmpAssets;
import com.rs.eis.model.Expense;

@Repository
public interface EmpAssetsRepository extends JpaRepository<EmpAssets, Integer> {
     
	List<EmpAssets> findByUserId(int id);
//	static List<EmpAssets> findByUserIdAndTypeAndDateBetween(int id,String assetsid,String employeeid,String Date) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	static List<EmpAssets> findByUserIdAndTypeAndDateBetween(EmpAssets empassets) {
		// TODO Auto-generated method stub
		return null;
	}                                       
	}
                               