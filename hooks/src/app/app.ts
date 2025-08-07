import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  protected title = 'hooks';
  myMessage = 'Hello Lifecycle!';
  showComponent = true;

  changeMessage() {
    this.myMessage = 'Message Changed!';
  }

  toggleComponent() {
    this.showComponent = !this.showComponent;
  }
}
