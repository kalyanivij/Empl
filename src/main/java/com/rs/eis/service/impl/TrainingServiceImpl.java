package com.rs.eis.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rs.eis.model.Employee;
import com.rs.eis.model.Employer;
import com.rs.eis.model.Trainings;
import com.rs.eis.repository.EmployeeRepository;
import com.rs.eis.repository.EmployerRepository;
import com.rs.eis.repository.TrainingsEmployeeRepository;
import com.rs.eis.repository.TrainingsEmployerRepository;
import com.rs.eis.repository.TrainingsRepository;
import com.rs.eis.request.TrainingsVO;
import com.rs.eis.response.DeleteTrainingsResponse;
import com.rs.eis.response.EditTrainingsResponse;
import com.rs.eis.response.GetTrainingResponse;
import com.rs.eis.response.GetTrainingsResponse;
import com.rs.eis.response.AddEmployeeTrainingsResponse;
import com.rs.eis.response.AddEmployerTrainingsResponse;
import com.rs.eis.service.TrainingService;
import com.rs.eis.util.DateUtil;
import com.rs.eis.util.TrainingUtil;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployerRepository employerRepository;
	
	@Autowired
	TrainingsRepository trainingsRepository;
	
	@Autowired
	TrainingsEmployeeRepository trainingempRepository;
	
	@Autowired
	TrainingsEmployerRepository trainingemprRepository;

	@Override
	public AddEmployeeTrainingsResponse saveTrainingEmployee(TrainingsVO trainingsVO) {
		AddEmployeeTrainingsResponse response = new AddEmployeeTrainingsResponse();
		Optional<Employee> emp = employeeRepository.findById(trainingsVO.getEmployeeId());
		if (emp.isPresent()) {
			Trainings trainings = TrainingUtil.loadTrainingVOToTrainings(trainingsVO);
			trainingsVO.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			trainings = trainingsRepository.save(trainings);

			response.setTrainings(trainings);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		}else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in the table");
		}

		return response;
	}
	
	@Override
	public AddEmployerTrainingsResponse saveTrainingEmployer(TrainingsVO trainingsVO) {
		AddEmployerTrainingsResponse response = new AddEmployerTrainingsResponse();
		Optional<Employer> empr =employerRepository.findById(trainingsVO.getEmployerId());
		if (empr.isPresent()) {
			Trainings trainings = TrainingUtil.loadTrainingVOToTrainings(trainingsVO);
			trainingsVO.setCreated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			trainings = trainingsRepository.save(trainings);

			response.setTrainings(trainings);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		}else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in the table");
		}

		return response;
	}

	@Override
	public EditTrainingsResponse editTraining(Trainings trainings) {
		EditTrainingsResponse response = new EditTrainingsResponse();

		Optional<Trainings> trainingsObj = trainingsRepository.findById(trainings.getId());

		if (trainingsObj.isPresent()) {

			trainings.setUpdated(DateUtil.getCurrentDate("dd-M-yyyy hh:mm:ss"));
			trainings = trainingsRepository.save(trainings);

			response.setTrainings(trainings);

			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as trainingId is not present in trainings table");
		}

		return response;
	}

	@Override
	public DeleteTrainingsResponse deleteTraining(int trainingId) {
		DeleteTrainingsResponse response = new DeleteTrainingsResponse();

		Optional<Trainings> trainings = trainingsRepository.findById(trainingId);

		if (trainings.isPresent()) {
			Trainings training = trainings.get();
			trainingsRepository.delete(training);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as trainingId is not present in trainings table");
		}

		return response;
	}

	@Override
	public GetTrainingResponse getTrainingsById(int trainingId) {
		GetTrainingResponse response = new GetTrainingResponse();
		Optional<Trainings> trainings = trainingsRepository.findById(trainingId);
		if (trainings.isPresent()) {
			response.setTrainings(trainings.get());
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("No Trainings Found for the given trainingid");
		}

		return response;
	}
	
	@Override
	public GetTrainingsResponse getTrainings(int employeeId) {
		GetTrainingsResponse response = new GetTrainingsResponse();
		List<Trainings> trainings = trainingempRepository.findByEmployeeId(employeeId);
		if (!trainings.isEmpty()) {
			response.setTrainings(trainings);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in trainings table");
		}

		return response;
	}
	@Override
	public GetTrainingsResponse getTraining(int employerId) {
		GetTrainingsResponse response = new GetTrainingsResponse();
		List<Trainings> trainings = trainingemprRepository.findByEmployerId(employerId);
		if (!trainings.isEmpty()) {
			response.setTrainings(trainings);
			response.setStatusCode("000");
			response.setStatus(HttpStatus.OK);
		} else {
			response.setStatusCode("001");
			response.setStatus(HttpStatus.PRECONDITION_FAILED);
			response.setErrorMessage("Invalid Input as Id is not present in trainings table");
		}

		return response;
	}

	

	
}
