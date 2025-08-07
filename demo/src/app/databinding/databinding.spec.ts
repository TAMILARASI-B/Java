import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Databinding } from './databinding';

describe('Databinding', () => {
  let component: Databinding;
  let fixture: ComponentFixture<Databinding>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Databinding]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Databinding);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
