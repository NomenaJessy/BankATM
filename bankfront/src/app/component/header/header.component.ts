import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public route: Router) { }

  ngOnInit(): void {
    this.isLogged();
  }

  isLogged(){
    const user = localStorage.getItem('user'); 
    if(user === null){
      this.route.navigate(['/login']);
    }else{
      this.route.navigate(['/accueil']);
    }
  }

  Deconnecter(){
    localStorage.removeItem('user');
    localStorage.removeItem('role');
    this.route.navigate(['/login'])
  }
}
