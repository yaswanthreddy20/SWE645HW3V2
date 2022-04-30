package com.hw3.studentsurvey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hw3.studentsurvey.entity.StudentSurveyForm;
import com.hw3.studentsurvey.service.FormService;

@RestController
public class FormController {
	
	@Autowired
	private FormService formService;
	  
    // Save operation
    @PostMapping("/new-survey")
    public StudentSurveyForm saveSurvey( @RequestBody StudentSurveyForm survey)
    {
        return formService.saveSurvey(survey);
    } 
    // Read operation
    @GetMapping("/surveys")
    public List<StudentSurveyForm> fetchSurveyList()
    {
        return formService.fetchSurveyList();
    }
}
