import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-create-new-password',
  templateUrl: './create-new-password.component.html',
  styleUrls: ['./create-new-password.component.css']
})

export class CreateNewPasswordComponent implements OnInit {

  returnedUser: any;

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.returnedUser = { newPassword: '', confirmPassword: '', email: '' };
  }

  savePass():void{
    this.userService.createNewPassword(this.returnedUser).subscribe(() => {
      sessionStorage.setItem('user', this.returnedUser?.email);
      sessionStorage.removeItem('user');
      this.router.navigate(['/login']);
      this.toastrService.success("New password created successfully");
      
    },
    (err: any) => {
      this.toastrService.error('Creating password error ' + err.error.message);
    });
  }}