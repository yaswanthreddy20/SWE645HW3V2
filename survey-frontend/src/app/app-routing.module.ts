import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateSurveyComponent } from './create-survey/create-survey.component';
import { HomeComponent } from './home/home.component';
import { SurveyListComponent } from './survey-list/survey-list.component';

const routes: Routes = [
  {path: 'surveys',component:SurveyListComponent},
 // {path:'',redirectTo:'',pathMatch:'full'},
  {path:' ',component:HomeComponent},
  {path:'create-survey',component:CreateSurveyComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
