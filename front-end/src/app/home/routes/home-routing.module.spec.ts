import { HomeRoutingModule } from '@app/home/routes/home-routing.module';

describe('EntradaArquivoRoutingModule', () => {
  let homeRoutingModule: HomeRoutingModule;

  beforeEach(() => {
    homeRoutingModule = new HomeRoutingModule();
  });

  it('should create an instance', () => {
    expect(homeRoutingModule).toBeTruthy();
  });
});
