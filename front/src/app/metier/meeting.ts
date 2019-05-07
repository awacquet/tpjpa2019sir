import {Date} from "./date";
import {Location} from "./location";
import {User} from "./user";

export class Meeting {
  id: number;
  title: string;
  summary: string;
  accessCode: string;
  date: Date;
  location: Location;
  attendees: User[];
}
