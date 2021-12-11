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
  question: any;

  constructor(private userService: UserService, private router: Router,  private toastrService: ToastrService) { }
    
  ngOnInit(): void {
    this.returnedUser = {question: '', securityAnswer: '', mailTo: '', mailSubject: 'Reset your password', mailContent: 'Dear Sir/Madam,\nfor reseting your password please follow the link: http://localhost:4200/create-new-password \n\nBest regards,\nVegaIT'};
   
    this.userService.getRandomQuestion(this.returnedUser).subscribe((question: any) => {
      console.log(question);
    })
  }

  onSubmit(): void {
   
    this.userService.sendForgotPasswordEmail(this.returnedUser).subscribe((data: any) => {
      if(data == false) {
        this.toastrService.error("Email doesn't exists!");
        
      } else {
        sessionStorage.setItem('user', this.user?.email);
      sessionStorage.removeItem('user');
      this.router.navigate(['/login']);
      this.toastrService.success("Please check your email!");
      
      
      }
    },
    (err: any) => {
      this.toastrService.error('Reset password error ' + err.error.message);
    });
  }
}
