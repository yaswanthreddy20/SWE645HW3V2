import { Component, OnInit } from '@angular/core';
import { map, tap } from 'rxjs';
import { Survey } from '../survey';
import { SurveyService } from '../survey.service';
@Component({
  selector: 'app-survey-list',
  templateUrl: './survey-list.component.html',
  styleUrls: ['./survey-list.component.css']
})
export class SurveyListComponent implements OnInit {
  constructor(private surveyService: SurveyService) { }
  surveys!: Survey[];

  ngOnInit(): void {
    this.getSurveys();
    
}

private getSurveys(){
  this.surveyService.getSurveysList().subscribe(data => {
  this.surveys=data;
});
}
}
/*
    this.surveys=[{
      "id":1,
      "firstName": "test",
    "lastName": "test",
    "streetAddress": "test",
    "city": "test",
    "state": "test",
    "zipCode": "test",
    "telephoneNumber": "test",
    "email": "test",
    "dateOfSurvey": new Date(),
    "likedAboutCampus": "test",
    "heardFrom": "test",
    "recommend": "test",
    },
    {
      "id":1,
      "firstName": "test",
    "lastName": "test",
    "streetAddress": "test",
    "city": "test",
    "state": "test",
    "zipCode": "test",
    "telephoneNumber": "test",
    "email": "test",
    "dateOfSurvey": new Date(),
    "likedAboutCampus": "test",
    "heardFrom": "test",
    "recommend": "test",
    }
  ];
  }
*/