import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Survey } from './survey';

@Injectable({
  providedIn: 'root'
})
export class SurveyService {
  private baseUrl="http://34.121.35.110:8080/surveys";
  private baseUrl2="http://34.121.35.110:8080/new-survey";

  constructor(private httpClient: HttpClient) { }
  getSurveysList(): Observable<Survey[]>{
    return this.httpClient.get<Survey[]>(`${this.baseUrl}`);
  }
  createSurvey(survey: Object): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl2}`, survey);
  }
}
