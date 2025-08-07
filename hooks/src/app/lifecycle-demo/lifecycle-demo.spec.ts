import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LifecycleDemo } from './lifecycle-demo';

describe('LifecycleDemo', () => {
  let component: LifecycleDemo;
  let fixture: ComponentFixture<LifecycleDemo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LifecycleDemo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LifecycleDemo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
