import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  idUser: any;
  firstname: string='';
  lastname: string='';
  birthdate: string= '';
  mail: string= '';
  password: string='';
  roleType: string='';

  constructor(public data: DataService,public router: ActivatedRoute,public route: Router) { }

  ngOnInit(): void {
    this.idUser = this.router.snapshot.paramMap.get('idUser');
    this.getUserInformation(this.idUser);
  }

  getUserInformation(idUser: any){
    const success = (response:any)=>{
      if(response['status'] == 200){
        this.firstname = response['datas']['firstname'];
        this.lastname = response['datas']['lastname'];
        this.birthdate = response['datas']['birthdate'];
        this.mail = response['datas']['mail'];
        this.password = response['datas']['password'];
        this.roleType = response['datas']['roleType'];
      }      
    };
    const error = (response: any)=>{}
    this.data.userById(idUser).subscribe(success,error);
  }

  modifier(){
    const success = (response:any)=>{
      if(response['status'] == 200){
        this.route.navigate(['/accueil']);
      }
    }
    const error = (response:any)=>{}
    this.data.updateUser(this.idUser,this.firstname,this.lastname,this.birthdate,this.mail,this.password,this.roleType)
      .subscribe(success,error);
  }
}
