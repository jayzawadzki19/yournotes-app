import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../notes/model/user";

@Injectable({
  providedIn: 'root'
})
export class UserApiService {

  constructor() { }
}
