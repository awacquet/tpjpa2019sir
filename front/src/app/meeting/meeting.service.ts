import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';


import { Observable } from 'rxjs';

import { Meeting } from '../metier/meeting';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable()
export class MeetingService {
  meetingUrl = 'api/meeting/';

  constructor(
    private http: HttpClient) {
  }

  getMeetings (): Observable<Meeting[]> {
    return this.http.get<Meeting[]>(this.meetingUrl);
  }


}
