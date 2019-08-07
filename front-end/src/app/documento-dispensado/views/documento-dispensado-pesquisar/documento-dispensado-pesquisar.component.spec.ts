import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentoDispensadoPesquisarComponent } from './documento-dispensado-pesquisar.component';

describe('DocumentoDispensadoPesquisarComponent', () => {
  let component: DocumentoDispensadoPesquisarComponent;
  let fixture: ComponentFixture<DocumentoDispensadoPesquisarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocumentoDispensadoPesquisarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentoDispensadoPesquisarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
