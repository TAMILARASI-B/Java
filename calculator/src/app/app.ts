import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  title = 'calculator';
  display: string = '';

  appendInput(value: string): void {
    this.display += value;
  }

  clear(): void {
    this.display = '';
  }

  calculate(): void {
    try {
      this.display = eval(this.display);
    } catch (e) {
      this.display = 'Error';
    }
  }
}