import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  mail: string = '';
  password: string = '';
  error_msg: string='';

  constructor(public data: DataService,public route: Router) { }

  ngOnInit(): void {
    this.isLogged();
  }

  isLogged(){
    let idUser = localStorage.getItem('user');
    if(idUser !== null){
      this.route.navigate(['/accueil']);
    }
  }

  Connection(){
    const success = (response:  any) => {
      if (response['status'] == 200) {
        localStorage.setItem('user',response['datas']['idUser']);
        localStorage.setItem('role',response['datas']['roleType']);
        // redirection
        this.route.navigate(['/accueil']);
        // this.Route(response['datas']['roleType']);
      } else {
        this.error_msg = response['datas'];
      }
      console.log(response);
    };
    const error = (response: any) => {
      this.error_msg = 'Erreur connexion';
    };

    this.data.connexion(this.mail, this.password).subscribe(success, error);
  }

  // Route(idRole: string){
  //   const success = (response: any)=>{
  //     if(response['status'] == 200){
  //       if(response['datas']['roleType'] == "Admin"){
  //         this.route.navigate(['']);
  //       }else if(response['datas']['roleType'] == "Client"){
  //         this.route.navigate(['']);
  //       }
  //     }
  //   }
  //   const error = (response: any)=>{}
  //   this.data.roleById(idRole).subscribe(success,error);
  // }

}
