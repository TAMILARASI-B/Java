import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Veg } from './veg';

describe('Veg', () => {
  let component: Veg;
  let fixture: ComponentFixture<Veg>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Veg]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Veg);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
