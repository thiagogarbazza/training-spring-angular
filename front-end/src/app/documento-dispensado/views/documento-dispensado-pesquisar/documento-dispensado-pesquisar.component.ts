import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';

import { DocumentoDispensadoParaPesquisarResource } from '@app/documento-dispensado/models/documento-dispensado-para-pesquisar-resource';

@Component({
  selector: 'app-documento-dispensado-pesquisar',
  templateUrl: './documento-dispensado-pesquisar.component.html',
  styleUrls: ['./documento-dispensado-pesquisar.component.sass']
})
export class DocumentoDispensadoPesquisarComponent implements OnInit {

  public paraPesquisarResource: DocumentoDispensadoParaPesquisarResource;
  public pesquisarFormGroup: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder
  ) { }

  public ngOnInit() {
    this.paraPesquisarResource = this.route.snapshot.data.resolver as DocumentoDispensadoParaPesquisarResource;
    this.criarFormGroup();
  }

  private criarFormGroup() {
    this.pesquisarFormGroup = this.formBuilder.group({
      situacao: [null],
    });
  }
}
