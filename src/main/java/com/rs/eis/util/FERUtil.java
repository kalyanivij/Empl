package com.rs.eis.util;

<<<<<<< HEAD
import com.rs.eis.model.Qualification;
import com.rs.eis.request.QualificationVO;

public class FERUtil {

	public static Qualification loadQualificationVOToQualification(QualificationVO qualificationVO) {

		Qualification qualification = new Qualification();
		qualification.setEducation(qualificationVO.getEducation());
		qualification.setCourse(qualificationVO.getCourse());
		qualification.setSpecialization(qualificationVO.getSpecialization());
		qualification.setUniversity(qualificationVO.getUniversity());
		qualification.setCourse_type(qualificationVO.getCourse_type());
		qualification.setGrade(qualificationVO.getGrade());
		qualification.setMarks(qualificationVO.getMarks());

		return qualification;

	}
=======

public class FERUtil {

	/*
	 * public static User loadRegistrationVOToUser(RegistrationVO registrationVO) {
	 * User user = new User();
	 * 
	 * user.setFirstName(registrationVO.getFirstName());
	 * user.setMiddleName(registrationVO.getMiddleName());
	 * user.setLastName(registrationVO.getLastName());
	 * 
	 * user.setEmail(registrationVO.getEmail());
	 * user.setMobile(registrationVO.getMobile());
	 * 
	 * user.setUserName(registrationVO.getUserName());
	 * user.setPassword(registrationVO.getPassword());
	 * 
	 * user.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
	 * 
	 * return user;
	 * 
	 * }
	 * 
	 * public static User loadUpdateUserVOToUser(UserVO userVO, User userdb) {
	 * userdb.setFirstName(userVO.getNameVo().getFirstName());
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
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

}
