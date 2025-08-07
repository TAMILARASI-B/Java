import { Component,OnInit,
  OnDestroy,
  OnChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked,
  Input,
  SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-lifecycle-demo',
  standalone: false,
  templateUrl: './lifecycle-demo.html',
  styleUrl: './lifecycle-demo.css'
  
})
export class LifecycleDemo implements
  OnInit, OnDestroy, OnChanges, DoCheck,
  AfterContentInit, AfterContentChecked,
  AfterViewInit, AfterViewChecked {

  @Input() message: string = '';

  constructor() {
    console.log('constructor() called');
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges() called', changes);
  }

  ngOnInit(): void {
    console.log('ngOnInit() called');
  }

  ngDoCheck(): void {
    console.log('ngDoCheck() called');
  }

  ngAfterContentInit(): void {
    console.log('ngAfterContentInit() called');
  }

  ngAfterContentChecked(): void {
    console.log('ngAfterContentChecked() called');
  }

  ngAfterViewInit(): void {
    console.log('ngAfterViewInit() called');
  }

  ngAfterViewChecked(): void {
    console.log('ngAfterViewChecked() called');
  }

  ngOnDestroy(): void {
    console.log('ngOnDestroy() called');
  }
}
