package com.rs.eis.util;

import com.rs.eis.model.Employee;
import com.rs.eis.request.AddEmployeeVO;

public class EmployeeUtil {

	public static Employee loadAddEmployeeVOToEmployee(AddEmployeeVO addemployeeVO) {
		Employee employee = new Employee();

		employee.setFirstName(addemployeeVO.getFirstName());
		employee.setMiddleName(addemployeeVO.getMiddleName());
		employee.setLastName(addemployeeVO.getLastName());

		employee.setDateOfBirth(addemployeeVO.getDateOfBirth());
		employee.setGender(addemployeeVO.getGender());

		employee.setBloodGroup(addemployeeVO.getBloodGroup());
		employee.setDifferentlyAbled(addemployeeVO.getDifferentlyAbled());
		employee.setAadharNo(addemployeeVO.getAadharNo());
		employee.setMaritalStatus(addemployeeVO.getMaritalStatus());
		employee.setPanNo(addemployeeVO.getPanNo());
		employee.setPassportNo(addemployeeVO.getPassportNo());

		employee.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return employee;

	}

	/*
	 * public static Employee loadUpdateEmployeeVOToEmployee(EmployeeVO employeeVO,
	 * Employee employeedb) {
	 * employeedb.setFirstName(employeeVO.get.getFirstName());
	 * employeedb.setMiddleName(employeeVO.getNameVo().getMiddleName());
	 * employeedb.setLastName(employeeVO.getNameVo().getLastName());
	 * employeedb.setEmail(employeeVO.getContactVo().getEmail());
	 * employeedb.setMobile(employeeVO.getContactVo().getMobile());
	 * 
	 * if (!employeeVO.getAddressVo().getLineOne().isEmpty()) {
	 * employeedb.getAddress().setLineOne(employeeVO.getAddressVo().getLineOne());
	 * employeedb.getAddress().setLineTwo(employeeVO.getAddressVo().getLineTwo());
	 * employeedb.getAddress().setCity(employeeVO.getAddressVo().getCity());
	 * employeedb.getAddress().setState(employeeVO.getAddressVo().getState());
	 * employeedb.getAddress().setPostal(employeeVO.getAddressVo().getPostal());
	 * employeedb.getAddress().setCountry(employeeVO.getAddressVo().getCountry());
	 * if (employeedb.getAddress().getId() > 0) {
	 * employeedb.getAddress().setUpdated(DateUtil.
	 * getCurrentDate("dd-M-yyyy hh:mm:ss")); } else {
	 * employeedb.getAddress().setCreated(DateUtil.
	 * getCurrentDate("dd-M-yyyy hh:mm:ss")); } }
	 * employeedb.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss")); return
	 * employeedb;
	 * 
	 * }
	 */
}
