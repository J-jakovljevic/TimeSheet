import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/model/user-model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any;
  password: any;

  constructor(private userService: UserService, private router: Router,  private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.user = { username:'', password: ''};
   
  }

  login(): void {
    this.userService.login(this.user).subscribe((response: User) => {
      sessionStorage.setItem('user', this.user.email);
      this.router.navigate(['/home']);
      this.toastrService.success("User logged in successfully!")
    },
    (err: any) => {
      this.toastrService.error("User is not registered!");
    }
    );
  }

}
