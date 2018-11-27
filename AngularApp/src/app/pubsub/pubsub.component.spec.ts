import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PubsubComponent } from './pubsub.component';

describe('PubsubComponent', () => {
  let component: PubsubComponent;
  let fixture: ComponentFixture<PubsubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PubsubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PubsubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
