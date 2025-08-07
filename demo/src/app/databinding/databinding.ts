import { Component } from '@angular/core';

@Component({
  selector: 'app-databinding',
  standalone: false,
  templateUrl: './databinding.html',
  styleUrl: './databinding.css'
})
export class Databinding {
  company ="IBM";

  abc(){
    console.log("Hi Button cliked...!")
  }
  xyz(un:string){
    console.log("Hi XYZ "+un)
  }
  TOTALAMOUNT=0; 
  emi=0;
  cal(p:string,t:string,r:string){
    var p1=parseInt(p);
    var t1=parseInt(t);
    var r1= parseInt(r);
    this.TOTALAMOUNT=(p1 * t1 * r1 ) / 100;
   this.emi= this.TOTALAMOUNT/t1;
    console.log(this.TOTALAMOUNT)
  }

  roi=0;
  onChange(event:any){ 
    console.log(event.target.value)
    if(event.target.value=="CAR"){
      this.roi=8;
    }
    else   if(event.target.value=="PERSONAL"){
      this.roi=15;
    }
    else   if(event.target.value=="EDU"){
      this.roi=12;
    } 
    else   if(event.target.value=="HOME"){
      this.roi=10;
    }
  }
}
