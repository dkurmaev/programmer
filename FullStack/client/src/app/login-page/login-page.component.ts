import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { AuthService } from '../shared/services/auth.service';
import { MaterialService } from '../shared/classes/material.service';


@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})

export class LoginPageComponent implements OnInit, OnDestroy {
  form: FormGroup = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required])
  });
  aSub: Subscription = new Subscription();

  constructor(private auth: AuthService,
              private router: Router,
              private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.form = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
    });

    this.route.queryParams.subscribe((params: Params) => {
      if (params ['registered']) {
        MaterialService.toast('Теперь вы можете зайти в систему, используя свои данные')
        
      } else if (params['accessDenied']) {
        MaterialService.toast('Для начала авторизуйтесь в системе')
       
      }
    });
}

  ngOnDestroy() {
    if(this.aSub){
      this.aSub.unsubscribe()
    }
  }
  onSubmit() {
    this.form.disable();
    this.aSub = this.auth.login(this.form.value).subscribe(
      ()=> this.router.navigate(['/overview']),
      error => {
        MaterialService.toast(error.error.message)        
        this.form.enable()
      }
    )
  }   
  
}
