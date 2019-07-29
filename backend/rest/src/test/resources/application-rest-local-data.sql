--╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
--╠═════════                                                 Banco de dados para execução local                                                       ═════════╣
--║                                                                                                                                                            ║
--╟────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╢
--║  Dicas para criação da base de dados local.                                                                                                                ║
--║    * Faça a seguinte identação:                                                                                                                            ║
--║       - Linhas de INSERT devem estar na coluna zero.                                                                                                       ║
--║       - Linhas dos VALUES devem estar identado com 2 espaços.                                                                                              ║
--║       - Mantenhas as colunas de valores sempre alinhados, pois isso facilita a leitura.                                                                    ║
--║                                                                                                                                                            ║
--╟────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╢
--║  Dicas para campos do tipo:                                                                                                                                ║
--║    * Data                                                                                                                                                  ║
--║      - Data atual "CURRENT_DATE()".                                                                                                                        ║
--║      - Data atual mais 1 dia "CURRENT_DATE() + 1".                                                                                                         ║
--║      - Data atual menos 1 dia "CURRENT_DATE() - 1".                                                                                                        ║
--║    * Data-hora                                                                                                                                             ║
--║      - Data-hora atual "CURRENT_TIMESTAMP()".                                                                                                              ║
--║      - Data-hora atual mais 1 dia "CURRENT_TIMESTAMP() + 1".                                                                                               ║
--║      - Data-hora atual menos 1 dia "CURRENT_TIMESTAMP() - 1".                                                                                              ║
--║                                                                                                                                                            ║
--╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Funções customizadas                                                                                                                     ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

CREATE ALIAS EMAIL_GENERATOR FOR "com.github.thiagogarbazza.training.springangular.utiltest.h2.FunctionEmailGenerator.executar";    -- arg0=
CREATE ALIAS HTML_GENERATOR  FOR "com.github.thiagogarbazza.training.springangular.utiltest.h2.FunctionHtmlGenerator.executar";     -- arg0=
CREATE ALIAS TEXT_GENERATOR  FOR "com.github.thiagogarbazza.training.springangular.utiltest.h2.FunctionTextGenerator.executar";     -- arg0=

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Clientes                                                                                                                                 ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO cliente.tbl_cliente
  (id,                                 codigo,    nome,         criador,          criacao,                   modificador,      modificacao) VALUES
  ('deba2cb2fc074a4fb818648a6b9bd9af', 'CLI001', 'Cliente 001', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 100),
  ('126c1f8fcb594b07b8fdfe09050415cc', 'CLI002', 'Cliente 002', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 200),
  ('ad5c316d24724d1eb6f76d4c96b9b1cb', 'CLI003', 'Cliente 003', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 300),
  ('fbeaf5ea671541f9a7fc71495f8ca86f', 'CLI004', 'Cliente 004', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null),
  ('3b75a592f67549ab8b8e605faff8d12d', 'CLI005', 'Cliente 005', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Grupo de documentos                                                                                                                      ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO documento.tbl_grupo_documento
  (id,                                 situacao, codigo,   nome,                    criador,          criacao,                    modificador,    modificacao) VALUES
  ('3ff86184807c46c78a68f9776d1e3cf3', 2,        'GRP01', 'Grupo de documento 001', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 100),
  ('9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02', 'Grupo de documento 002', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 200),
  ('8d175e3c58584cb2ab63061c0e47d951', 1,        'GRP03', 'Grupo de documento 003', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 300),
  ('7928c551d1cf49fa964afe2f09d28313', 1,        'GRP04', 'Grupo de documento 004', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null),
  ('ef03744eaaa84d778d83c636577d4206', 1,        'GRP05', 'Grupo de documento 005', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null);

INSERT INTO documento.his_situacao_grupo_documento
  (id,                                 grupo_documento_id,                 situacao, criador,          criacao) VALUES
  ('4fa06391bffa47bc893f8ea40b2739d3', '3ff86184807c46c78a68f9776d1e3cf3', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('0a033625f090409cabc6bc353530a139', '3ff86184807c46c78a68f9776d1e3cf3', 2,        'thiagogarbazza', CURRENT_TIMESTAMP() - 260),
  ('5e9397ac84554d8cbfb3fa75f974183d', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('7d07cd9a5a3e4f00ac8c65193fe97e6f', '8d175e3c58584cb2ab63061c0e47d951', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('f6752a32a1004c17a2604327f95abd4d', '7928c551d1cf49fa964afe2f09d28313', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('3195c0734ae24e57ba7c1ef62fc3a552', 'ef03744eaaa84d778d83c636577d4206', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Documentos                                                                                                                               ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO documento.tbl_documento
  (id,                                 grupo_documento_id,                 situacao, codigo,        periodicidade, tipo_dispensa, impacto_dispensa, vigencia_inicio,      vigencia_fim, nome,                     criador,          criacao,                   modificador,      modificacao) VALUES
  ('b07795e0900844a1b99e1ce7925051a5', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC01', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 001 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 100),
  ('4f7d4c136f7e4fd39179be78335698d8', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC02', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 002 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 200),
  ('edfc8516d5ae478dbd763da8243ba2d7', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC03', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 003 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 300),
  ('e8a589e6ca7c4bf0af53d46a92d1aea7', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC04', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 004 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null),
  ('5b9b7b2434404e3a9c73e78bc006abae', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC05', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 005 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null);


--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Documentos esperados                                                                                                                     ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘



--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Documentos processados                                                                                                                   ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘






