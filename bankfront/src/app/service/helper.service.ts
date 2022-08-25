import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HelperService {

  constructor() { }

  formOption () {
    const options = { 
      headers: {
        'Content-Type' : 'application/x-www-form-urlencoded'
      }
    };

    return options;
  }

  makeBody (json: any) {
    let body = [];
    for (let key in json)
      body.push(key + '=' + json[key]);
    return body.join('&');
  }
}
