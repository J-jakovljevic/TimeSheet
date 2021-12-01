import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/model/user-model';
import { UserService } from '../services/user.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: any;
  name: any;
  surname: any;
  username: any;
  password: any;
  confirmPassword: any;
  email: any;

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) { }


  ngOnInit(): void {
    this.user = {name: '', surname: '', username: '', password: '', confirmPassword: '', email: ''};
  }

  registration(): void {
    this.userService.registration(this.user).subscribe((returnedUser: User) => {
      this.toastrService.success('Registration is successfull!');
      this.router.navigate(['/login']);
    },
    (err: any) => {
      this.toastrService.error('Registration error ' + err.error.message);
    });
  }

}
