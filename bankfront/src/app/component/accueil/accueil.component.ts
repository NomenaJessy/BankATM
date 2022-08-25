import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  role: string='';


  constructor(public data: DataService) { }

  ngOnInit(): void {
    this.RoleType();
  }

  // check role type
  RoleType(){
    let idRole = localStorage.getItem('role');
    const success = (response: any)=>{
      if(response['status'] == 200){
        if(response['datas']['roleType'] === "Admin"){
          this.role = "Admin";
        }else if(response['datas']['roleType'] === "Client"){
          this.role = "Client";
        }
        console.log(response['datas']['roleType']);
      }
    }
    const error = (response: any)=>{}
    this.data.roleById(idRole).subscribe(success,error);
  }

}
