import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { LoginUser, RegisterUser } from 'src/model/user-model';
import { LOGIN_PATH } from '../util/path';
import { REGISTRATION_PATH } from '../util/path';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  login(user: LoginUser): any {
   return this.httpClient.post(LOGIN_PATH, user);
  }

  isUserLogin(){
    let user = sessionStorage.getItem('user');
    return !(user == null)
  }

  registration(user: RegisterUser): any {
    return this.httpClient.post(REGISTRATION_PATH, user);
  }

  logOut(){
    sessionStorage.removeItem('user');
  //  sessionStorage.removeItem('role');
  }

}
