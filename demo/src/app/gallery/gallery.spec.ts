import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Gallery } from './gallery';

describe('Gallery', () => {
  let component: Gallery;
  let fixture: ComponentFixture<Gallery>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Gallery]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Gallery);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
