import { Component, OnInit, Input } from '@angular/core';

import { animacaoPesquisa } from '@shared/components/pagina-pesquisa/animacao';

@Component({
  selector: 'app-pagina-pesquisa',
  templateUrl: './pagina-pesquisa.component.html',
  styleUrls: ['./pagina-pesquisa.component.scss'],
  animations: animacaoPesquisa
})
export class PaginaPesquisaComponent implements OnInit {

  @Input() formularioVisivel: boolean = true;
  @Input() resultadoVisivel: boolean = true;
  @Input() camposObrigatorios: boolean = false;

  constructor() { }

  ngOnInit() { }

}
