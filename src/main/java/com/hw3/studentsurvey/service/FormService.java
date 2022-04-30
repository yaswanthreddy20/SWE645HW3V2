package com.hw3.studentsurvey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hw3.studentsurvey.entity.StudentSurveyForm;
import com.hw3.studentsurvey.repository.FormRepository;
@Service
public class FormService implements IFormService{
	@Autowired
    private FormRepository formRepository;
	// Save operation
	@Override
    public StudentSurveyForm saveSurvey(StudentSurveyForm surveyForm) {
    	return formRepository.save(surveyForm);
    }
    
    // Read operation
    @Override
    public List<StudentSurveyForm> fetchSurveyList(){
    	return (List<StudentSurveyForm>) formRepository.findAll();
    }
  
}
