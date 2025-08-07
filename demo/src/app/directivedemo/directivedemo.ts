import { Component } from '@angular/core';
import { first } from 'rxjs';

@Component({
  selector: 'app-directivedemo',
  standalone: false,
  templateUrl: './directivedemo.html',
  styleUrl: './directivedemo.css'
})
export class Directivedemo {

    abc=true;
    emp = ['Anup','Suresh','Naresh','Chakri']
    
    // xyz(){
    //   for(var i = 0;i<=this.emp.length;i++){
    //     console.log(this.emp[i]) 
    //   }
    // }
    fruits=['Apple','Cherry','Graps','banana']

    addfruit(fruit:string){
      console.log(fruit)
      this.fruits.push(fruit);
    }
    emps=[
      {
        "id":100,
        "name":"naresh"
      },
      {
        "id":200,
        "name":"Suresh"
      }
    ];

    num="0";
    numb(nu:any){
        this.num=nu;
    }
}
