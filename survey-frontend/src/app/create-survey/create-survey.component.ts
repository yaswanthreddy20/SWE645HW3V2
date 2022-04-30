import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Survey } from '../survey';
import { SurveyService } from '../survey.service';

@Component({
  selector: 'app-create-survey',
  templateUrl: './create-survey.component.html',
  styleUrls: ['./create-survey.component.css']
})
export class CreateSurveyComponent implements OnInit {
  survey: Survey = new Survey();
  submitted = false;
  thingsLiked!: string[];
  constructor(private surveyService: SurveyService,
  private router: Router) { }
  ngOnInit(): void {
  }

  newSurvey(): void {
    this.submitted = false;
    this.survey = new Survey();
  }

  save() {
    this.surveyService.createSurvey(this.survey).subscribe(data => console.log(data), error => console.log(error));
    this.survey = new Survey();
    
  }
  onSubmit() {
    this.survey.likedAboutCampus = this.thingsLiked.join();
    this.submitted = true;
    this.save();    
  }

  gotoList() {
        this.router.navigate(['/surveys']);
  }
 

  onCheckboxChange(event: { target: { checked: any; }; }, value:string) {
    if (event.target.checked) {

      this.thingsLiked.push(value);
    } 
    if (!event.target.checked) {

      let index = this.thingsLiked.indexOf(value);

      if (index > -1) {

        this.thingsLiked.splice(index, 1);
      }
    }
  }

}
