import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { base_url } from 'src/environments/environment';
import { HelperService } from './helper.service';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(public http: HttpClient,public helper: HelperService) { }

  // user
  users(){
    return this.http.get(base_url+'/user');
  }

  userById(idUser: any){
    return this.http.get(base_url+'/user/'+idUser);
  }

  allUsers(){
    return this.http.get(base_url+'/users');
  }

  updateUser(idUser: any,firstname: string,lastname: string,birthdate: string,mail: string,password: string, accounttype: string){
    const options = this.helper.formOption();
    let body = this.helper.makeBody({
      'Firstname' : firstname,
      'Lastname' : lastname,
      'Birthdate': birthdate,
      'Mail': mail,
      'Password': password,
      'Roletype': accounttype
    });
    console.log(body);
    return this.http.put(base_url+'/user/'+idUser,body,options);
  }

  connexion(mail: string, password: string){
    const options = this.helper.formOption();
    let body = this.helper.makeBody({
      'mail' : mail,
      'password' : password
    });
    console.log(body);
    return this.http.post(base_url+'/connexion',body,options);
  }

  inscription(firstname: string,lastname: string,birthdate: string,mail: string,password: string, accounttype: string){
    const options = this.helper.formOption();
    let body = this.helper.makeBody({
      'Firstname' : firstname,
      'Lastname' : lastname,
      'Birthdate': birthdate,
      'Mail': mail,
      'Password': password,
      'Roletype': accounttype
    });
    return this.http.post(base_url+'/inscription',body,options);
  }

  deleteUser(idUser: any){
    return this.http.delete(base_url+'/user/'+idUser);
  }
  
  // role
  role(){
    return this.http.get(base_url+'/role');
  }

  roleById(idRole: any){
    return this.http.get(base_url+'/role/'+idRole);
  }

  //balance
  balance(idUser: any){
    return this.http.get(base_url+'/balance/'+idUser);
  }

  balanceSave(idUser: any,amount: number){
    const options = this.helper.formOption();
    let body = this.helper.makeBody({
      'Amount': amount
    });
    return this.http.put(base_url+'/balance/'+idUser,body,options);
  }

  //Transaction
  transactions(){
    return this.http.get(base_url+'/transaction');
  }

  transactionByIdUser(idUser: any){
    return this.http.get(base_url+'/transaction/'+idUser);
  }

  transactionSave(amount: number,idUser: any,receiver: any,transactionType: string){
    const options = this.helper.formOption();
    let body = this.helper.makeBody({
      'idUser': idUser,
      'amount': amount,
      'receiver': receiver,
      'operationType': transactionType
    });
    return this.http.post(base_url+'/transaction',body,options);
  }

  //TransactionType
  transactionType(idTransactionType: any){
    return this.http.get(base_url+'/transactionType/'+idTransactionType);
  }
}
