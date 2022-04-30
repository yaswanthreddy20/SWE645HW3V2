package com.hw3.studentsurvey.service;

import java.util.List;

import com.hw3.studentsurvey.entity.StudentSurveyForm;

public interface IFormService {
	// Save operation
    StudentSurveyForm saveSurvey(StudentSurveyForm surveyForm);
  
    // Read operation
    List<StudentSurveyForm> fetchSurveyList();
}
