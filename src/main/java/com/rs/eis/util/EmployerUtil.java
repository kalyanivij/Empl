package com.rs.eis.util;

import com.rs.eis.model.Employer;
import com.rs.eis.request.AddEmployerVO;

public class EmployerUtil {

	public static Employer loadAddEmployerVOToEmployer(AddEmployerVO addemployerVO) {
		Employer employer = new Employer();

		employer.setName(addemployerVO.getName());
		employer.setCampus(addemployerVO.getCampus());
		employer.setBranch(addemployerVO.getBranch());

		employer.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));

		return employer;

	}

	/*
	 * public static Employee loadUpdateUserVOToUser(UserVO userVO, Employee userdb)
	 * { userdb.setFirstName(userVO.getNameVo().getFirstName());
	 * userdb.setMiddleName(userVO.getNameVo().getMiddleName());
	 * userdb.setLastName(userVO.getNameVo().getLastName());
	 * userdb.setEmail(userVO.getContactVo().getEmail());
	 * userdb.setMobile(userVO.getContactVo().getMobile());
	 * 
	 * if (!userVO.getAddressVo().getLineOne().isEmpty()) {
	 * userdb.getAddress().setLineOne(userVO.getAddressVo().getLineOne());
	 * userdb.getAddress().setLineTwo(userVO.getAddressVo().getLineTwo());
	 * userdb.getAddress().setCity(userVO.getAddressVo().getCity());
	 * userdb.getAddress().setState(userVO.getAddressVo().getState());
	 * userdb.getAddress().setPostal(userVO.getAddressVo().getPostal());
	 * userdb.getAddress().setCountry(userVO.getAddressVo().getCountry()); if
	 * (userdb.getAddress().getId() > 0) {
	 * userdb.getAddress().setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"))
	 * ; } else {
	 * userdb.getAddress().setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"))
	 * ; } } userdb.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
	 * return userdb;
	 * 
	 * }
	 */

}
