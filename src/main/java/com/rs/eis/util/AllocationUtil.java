package com.rs.eis.util;

import com.rs.eis.model.Allocation;
import com.rs.eis.request.AllocationVO;

public class AllocationUtil {

	public static Allocation loadAllocationVOToAllocationn(AllocationVO allocationVO) {
		Allocation allocation = new Allocation();

		allocation.setName(allocationVO.getName());
		allocation.setProjectid(allocationVO.getProjectid());

		allocation.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return allocation;
	}
}
