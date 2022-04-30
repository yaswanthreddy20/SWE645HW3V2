import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateSurveyComponent } from './create-survey/create-survey.component';
import { SurveyListComponent } from './survey-list/survey-list.component';

const routes: Routes = [
  {path: 'surveys',component:SurveyListComponent},
  {path:'',redirectTo:'surveys',pathMatch:'full'},
  {path:'create-survey',component:CreateSurveyComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
