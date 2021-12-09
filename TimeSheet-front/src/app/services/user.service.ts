import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ChangePassword, CreateNewPassword, ForgotPassword, LoginUser, RegisterUser } from 'src/model/user-model';
import { CREATE_NEW_PASSWORD, LOGIN_PATH, PASSWORD_USER_PATH, REGISTRATION_PATH } from '../util/path';
import {FORGOT_PASSWORD} from '../util/path';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  cookieService: any;

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
  }

  changePassword(user: ChangePassword): any{
    return this.httpClient.put(PASSWORD_USER_PATH, user);
  }

  sendForgotPasswordEmail(user: ForgotPassword): any {
    return this.httpClient.post(FORGOT_PASSWORD, user)
  }

  createNewPassword(user: CreateNewPassword): any {
    return this.httpClient.put(CREATE_NEW_PASSWORD, user)
  }

}


