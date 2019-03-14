import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    mobile: new FormControl('', [Validators.required,Validators.minLength(10),Validators.pattern(/^-?(0|[1-9]\d*)?$/)]),
    password: new FormControl('', [Validators.required,Validators.minLength(6)])
  });
  constructor() { }

  ngOnInit() {
  }
  showPassword() {
    var inputPassword = document.querySelector('#input-password');
    inputPassword.setAttribute('type', 'text');
  }
}
