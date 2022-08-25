import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  user: any=[];
  userList: any=[];
  balance: number=0;
  transaction: any = [];
  depot: number= 0;
  retrait: number=0;
  transfer: number=0;
  receiver: any;
  error_msg: string='';
  message:string='';

  constructor(public data: DataService,public route: Router) { }

  ngOnInit(): void {
    this.UserDetails();
    this.allUser();
    this.Transaction();
  }
  
  // ngDoCheck(){
  // //   this.depot = 0;
  // }

  UserDetails(){
    let idUser = localStorage.getItem('user');
    const success = (response: any)=>{
      if(response['status'] == 200){
        this.user = response['datas'];
      }
    }
    const error = (response: any)=>{}
    this.data.userById(idUser).subscribe(success,error);
  }

  allUser(){
    const success = (response: any)=>{
      if(response['status'] == 200){
        this.userList = response['datas'];
      }
      console.log(this.userList);
    }
    const error = (response: any)=>{}
    this.data.users().subscribe(success,error);
  }

  Balance(){
    let idUser = localStorage.getItem('user');
    const success = (response: any)=>{
      if(response['status'] == 200){
        this.balance = response['datas']['amount'];
      }
    }
    const error = (response: any)=>{}
    this.data.balance(idUser).subscribe(success,error);
  }

  Transaction(){
    let idUser = localStorage.getItem('user');
    const success = (response: any)=>{
      if(response['status'] == 200){
        this.transaction = response['datas'];
      }
      console.log(this.transaction);
    }
    const error = (response: any)=>{}
    this.data.transactionByIdUser(idUser).subscribe(success,error);
  }

  SaveTransaction(idTransactionType:string){
    let idUser = localStorage.getItem('user');
    let amount = 0;
    if(this.depot > 0){
      amount = this.depot;
      this.receiver = idUser;
    }else if(this.retrait >0){
      amount = (-1)*this.retrait;
      this.receiver = idUser;
    }else if(this.transfer>0){
      amount = (-1)*this.transfer;
    }
    console.log(idTransactionType);
    console.log(this.receiver);
    const success = (response: any)=>{
      if(response['status'] == 200){
        // this.data.balanceSave(idUser,amount).subscribe(()=>{
          this.reloadComponent();
        // },()=>{
              // this.error_msg ='Erreur de transaction';
        // });
      }
    }
    const error = (response: any)=>{};
    if(this.transfer>0 && idUser == this.receiver){
      this.error_msg = "Le destinataire ne peut pas etre vous meme";
    }else if(this.transfer>0 && idUser != this.receiver){
      this.data.transactionSave(amount,idUser,this.receiver,idTransactionType).subscribe(success,error);
    }else if(this.depot>0 || this.retrait>0){
      this.data.transactionSave(amount,idUser,this.receiver,idTransactionType).subscribe(success,error);
    }
    
  }

  reloadComponent() {
    let currentUrl = this.route.url;
    this.route.navigateByUrl('/', {skipLocationChange: true}).then(() => {
        this.route.navigate([currentUrl]);
    });
  }

}
