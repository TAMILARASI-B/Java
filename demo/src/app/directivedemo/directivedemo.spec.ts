import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Directivedemo } from './directivedemo';

describe('Directivedemo', () => {
  let component: Directivedemo;
  let fixture: ComponentFixture<Directivedemo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Directivedemo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Directivedemo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
