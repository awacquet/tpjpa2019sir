import { Component, OnInit } from '@angular/core';
import {Meeting} from "../metier/meeting";
import {MeetingService} from "./meeting.service";

@Component({
  selector: 'app-meeting',
  templateUrl: './meeting.component.html',
  providers: [ MeetingService ],
  styleUrls: ['./meeting.component.css']
})
export class MeetingComponent implements OnInit {
  meetings: Meeting[];

  constructor(private meetingService: MeetingService) { }

  ngOnInit() {
    this.getMeetings();
  }

  getMeetings(): void {
    this.meetingService.getMeetings()
      .subscribe(meetings => this.meetings = meetings);
  }

}
