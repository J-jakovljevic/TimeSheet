import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/model/user-model';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  user: any;
  returnedUser: any;

  constructor(private userService: UserService, private router: Router,  private toastrService: ToastrService) { }
    
  ngOnInit(): void {
    this.returnedUser = {mailTo: '', mailSubject: 'Reset your pasword', mailContent: 'Dear Sir/Madam,\nfor reseting your password please follow the link: http://localhost:4200/login \n\nBest regards,\nVegaIT'};
 
  }

  onSubmit(): void {
    
    this.userService.sendForgotPasswordEmail(this.returnedUser).subscribe((data: any) => {
      if(data == false) {
        this.toastrService.error("Email doesn't exists!");
        
      } else {
      sessionStorage.setItem('user', this.user?.email);
      this.router.navigate(['/home']);
      this.toastrService.success("Please check your email!");
      }
    },
    (err: any) => {
      this.toastrService.error('Reset password error ' + err.error.message);
    });
  }
}
