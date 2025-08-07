import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Nonveg } from './nonveg';

describe('Nonveg', () => {
  let component: Nonveg;
  let fixture: ComponentFixture<Nonveg>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Nonveg]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Nonveg);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
