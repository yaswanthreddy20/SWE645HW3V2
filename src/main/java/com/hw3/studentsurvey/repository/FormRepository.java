package com.hw3.studentsurvey.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hw3.studentsurvey.entity.StudentSurveyForm;
@Repository
public interface FormRepository extends JpaRepository<StudentSurveyForm,Long> {

}
