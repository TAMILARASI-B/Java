import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Galary } from './galary';

describe('Galary', () => {
  let component: Galary;
  let fixture: ComponentFixture<Galary>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Galary]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Galary);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
