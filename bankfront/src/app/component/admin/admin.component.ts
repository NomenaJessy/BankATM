import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  users: any=[];
  transactions: any=[];
  message: string= "";

  constructor(public data: DataService,public route:Router,public activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.allUser();
    this.allTransaction();
  }

  allUser(){
    const success = (response: any)=>{
      if(response['status'] == 200){
        let data = response['datas'];
        for(let details of data){
          this.data.balance(details['idUser']).subscribe((solde:any)=>{
            details['solde'] = solde['datas']['amount']; 
            this.users.push(details);
          });
        }
      }
      console.log(this.users);
    }
    const error = (response: any)=>{}
    this.data.allUsers().subscribe(success,error);
  }

  allTransaction(){
    const success = (response:any)=>{
      if(response['status'] == 200){
        let datas = response['datas'];
        for(let details of datas){
          this.data.transactionType(details['idTransactionType']).subscribe((operationType:any)=>{
            details['operationType'] = operationType['datas']['operationType'];
          });
          this.data.userById(details['idUser']).subscribe((user:any)=>{
            details['firstname'] = user['datas']['firstname'];
            details['lastname'] = user['datas']['lastname'];
            details['mail'] = user['datas']['mail'];
          });
          details['details'] = false;
          this.transactions.push(details);
        }
        // this.transactions = response['datas'];
      }
      console.log(this.transactions);
    };
    const error = (response:any)=>{};
    this.data.transactions().subscribe(success,error);
  }


  showDetails(index: any){
    this.transactions[index]['details'] = !this.transactions[index]['details'];
    console.log(this.transactions[index]['details']);
  }

  modifier(idUser: any){
    // this.activatedRoute.queryParams.subscribe(params=>{

    // });
    this.route.navigate(['/user',{idUser: idUser}]);
  }

  delete(idUser: any){
    const success = (response:  any) => {
      if (response['status'] == 200) {
        this.message = "Utilisateur supprime avec succes";
      }
    };
    const error = (response: any) => {};
    this.data.deleteUser(idUser).subscribe(success, error);
  }
}
