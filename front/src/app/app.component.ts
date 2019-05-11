import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';
  showUsers = true;
  userBtn = 'Cacher les utilisateurs';
  showMeetings = true;
  meetingBtn = 'Cacher les réunions';

  toggleUsers() {
    this.showUsers = !this.showUsers;
    if (this.showUsers) {
      this.userBtn = 'Cacher les utilisateurs';
    } else {
      this.userBtn = 'Afficher les utilisateurs';
    }
  }

  toggleMeetings() {
    this.showMeetings = !this.showMeetings;
    if (this.showMeetings) {
      this.meetingBtn = 'Cacher les réunions';
    } else {
      this.meetingBtn = 'Afficher les réunions';
    }
  }

}
