import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { RegisterUser, User } from 'src/model/user-model';
import { UserService } from '../services/user.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: RegisterUser;

  constructor(private userService: UserService, private router: Router, private toastrService: ToastrService) {
    this.user = {name: '', surname: '', username: '', password: '', email: '', house_number: '', first_job_city: '', 
    grandmother_name: '', first_pet: '', oldest_child: '', first_concert: '', first_car: '', parents_meet: '',
    favorite_place: '', dream_job: '' };
   }

  ngOnInit(): void {
    
  }

  registration(): void {
    let numberOfAnsweredQuestions = 0;
    
    if(this.user.house_number !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.first_job_city !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.first_pet !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.oldest_child !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.first_concert !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.first_car !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.parents_meet !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.favorite_place !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.dream_job !== '') {
      numberOfAnsweredQuestions += 1;
    }
    if(this.user.grandmother_name !== '') {
      numberOfAnsweredQuestions += 1;
    }
    console.log(numberOfAnsweredQuestions);
    if(numberOfAnsweredQuestions < 5) {
       this.toastrService.error('You must answer at least 5 questions.');
        return;
    }

    this.userService.registration(this.user).subscribe(() => {
      this.toastrService.success('Registration is successfull!');
      this.router.navigate(['/login']);
    },
    (err: any) => {
      this.toastrService.error('User with that email/username already exists!');
    });
  }

}
