import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaPesquisaComponent } from '@app/comum/componentes/pagina-pesquisa/pagina-pesquisa.component';

describe('PaginaPesquisaComponent', () => {
  let component: PaginaPesquisaComponent;
  let fixture: ComponentFixture<PaginaPesquisaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaPesquisaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaPesquisaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
