import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/model/user-model';

@Component({
  selector: 'change-password',
  templateUrl:'change-password.component.html',
  providers: [ UserService ]
})

export class ChangePasswordComponent {

  user: any;
  returnedUser: any;

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) { }

  ngOnInit(): void {
   
    this.returnedUser = { newPassword: '', confirmPassword: '', email: sessionStorage.getItem('user') };
  }

  savePassword():void{
    this.userService.changePassword(this.returnedUser).subscribe(() => {
      sessionStorage.setItem('user', this.user?.email);
      this.router.navigate(['/home']);
      this.toastrService.success("Password changed successfully");
      
    },
    (err: any) => {
      this.toastrService.error('Changing password error ' + err.error.message);
    });
  }}