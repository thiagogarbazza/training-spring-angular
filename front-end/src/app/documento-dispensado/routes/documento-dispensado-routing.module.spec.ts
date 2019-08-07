import { DocumentoDispensadoRoutingModule } from '@app/documento-dispensado/routes/documento-dispensado-routing.module';

describe('EntradaArquivoRoutingModule', () => {
  let routingModule: DocumentoDispensadoRoutingModule;

  beforeEach(() => {
    routingModule = new DocumentoDispensadoRoutingModule();
  });

  it('should create an instance', () => {
    expect(routingModule).toBeTruthy();
  });
});
