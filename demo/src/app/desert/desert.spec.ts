import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Desert } from './desert';

describe('Desert', () => {
  let component: Desert;
  let fixture: ComponentFixture<Desert>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Desert]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Desert);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
