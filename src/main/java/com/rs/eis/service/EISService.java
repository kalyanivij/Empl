package com.rs.eis.service;

<<<<<<< HEAD
import com.rs.eis.model.Perfomance_review;
import com.rs.eis.response.AddPerfomance_reviewResponse;
import com.rs.eis.response.DeletePerfomance_reviewResponse;
import com.rs.eis.response.EditPerfomance_reviewResponse;
import com.rs.eis.response.GetPerfomance_reviewResponse;
=======
<<<<<<< HEAD
import org.springframework.stereotype.Service;

import com.rs.eis.model.Emp_awards;
import com.rs.eis.response.AddEmp_awardsResponse;
import com.rs.eis.response.DeleteEmp_awardsResponse;
import com.rs.eis.response.EditEmp_awardsResponse;
import com.rs.eis.response.GetAllEmp_awardsResponse;
import com.rs.eis.response.GetEmp_awardsResponse;

@Service
public interface EISService {

	GetEmp_awardsResponse getEmp_awardsByemployeeid(int employeeid);

	AddEmp_awardsResponse addEmp_awards(Emp_awards emp_awards);

	EditEmp_awardsResponse editEmp_awards(Emp_awards emp_awards);

	GetAllEmp_awardsResponse allEmp_awards(int employeeid);

	DeleteEmp_awardsResponse deleteEmp_awards(int id);
=======
import javax.validation.Valid;

import com.rs.eis.model.Country;
import com.rs.eis.model.State;
import com.rs.eis.response.CountryResponse;
import com.rs.eis.response.DeleteCountryResponse;
import com.rs.eis.response.DeleteStateResponse;
import com.rs.eis.response.EditCountryResponse;
import com.rs.eis.response.EditStateResponse;
import com.rs.eis.response.GetCountryResponse;
import com.rs.eis.response.GetStateResponse;
import com.rs.eis.response.StateResponse;
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

public interface EISService {

	AddPerfomance_reviewResponse addPerfomance_review(Perfomance_review perfomance_review);

	EditPerfomance_reviewResponse editPerfomance_review(Perfomance_review perfomance_review);

	GetPerfomance_reviewResponse getPerfomance_reviewByemployeeid(int employeeid);

<<<<<<< HEAD
	DeletePerfomance_reviewResponse deletePerfomance_review(int employeeid);
=======
	DeleteStateResponse deleteStateById(int id);

	EditStateResponse editState(State state);

	GetCountryResponse getCountryById(int id);

	DeleteCountryResponse deleteCountryById(int id);

	EditCountryResponse editCountry(@Valid Country country);
>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git

>>>>>>> branch 'master' of https://github.com/kalyanivij/Empl.git
}
