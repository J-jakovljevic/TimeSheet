import { Component } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { FormControl, Validators } from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'TimeSheet-front';
  name = new FormControl('', [Validators.required]);
  constructor(private toastr: ToastrService) {
  }
 
  ngOnInit() {
  }
 
  showToaster(){
      this.toastr.success("Hello, I'm the toastr message.")
  }
}


