import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import { MaterialService } from '../../classes/material.service';
;


@Component({
  selector: 'app-site-layout',
  templateUrl: './site-layout.component.html',
  styleUrls: ['./site-layout.component.css']
})
export class SiteLayoutComponent implements OnInit, AfterViewInit {

  @ViewChild('floating') floatingRef!: ElementRef


  links = [
    {url: '/overview', name: 'Überblick'},
    {url: '/analytics', name: 'Analytik'},
    {url: '/history', name: 'Geschichte'},
    {url: '/order', name: 'Bestellung hinzufügen'},
    {url: '/categories', name: 'Sortiment'},
  ]
  constructor(private auth : AuthService,
              private router : Router) { 

  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }

  ngAfterViewInit() {
    MaterialService.initialezeFloatingButton(this.floatingRef)
      
  }

  logout(event : Event){
    event.preventDefault()
    this.auth.logout()
    this.router.navigate(['/login'])

  }
}


