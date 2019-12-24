--╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
--╠═════════                                                 Banco de dados para execução local                                                       ═════════╣
--╠════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣
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
--├───────── Clientes                                                                                                                                 ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO cliente.tbl_cliente
  (id,                                 codigo,    nome,         criador,        criacao,                   modificador,   modificacao) VALUES
  ('deba2cb2fc074a4fb818648a6b9bd9af', 'CLI001', 'Cliente 001', 'mouse.mickey', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 100),
  ('126c1f8fcb594b07b8fdfe09050415cc', 'CLI002', 'Cliente 002', 'mouse.mickey', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 200),
  ('ad5c316d24724d1eb6f76d4c96b9b1cb', 'CLI003', 'Cliente 003', 'mouse.mickey', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 300),
  ('fbeaf5ea671541f9a7fc71495f8ca86f', 'CLI004', 'Cliente 004', 'mouse.mickey', CURRENT_TIMESTAMP() - 360, null           , null),
  ('3b75a592f67549ab8b8e605faff8d12d', 'CLI005', 'Cliente 005', 'mouse.mickey', CURRENT_TIMESTAMP() - 360, null           , null);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Grupo de documentos                                                                                                                      ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO documento.tbl_grupo_documento
  (id,                                 situacao, codigo,   nome,                     criador,        criacao,                   modificador,   modificacao) VALUES
  ('3ff86184807c46c78a68f9776d1e3cf3', 2,        'GRP001', 'Grupo de documento 001', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 260),
  ('9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP002', 'Grupo de documento 002', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 200),
  ('8d175e3c58584cb2ab63061c0e47d951', 1,        'GRP003', 'Grupo de documento 003', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 300),
  ('7928c551d1cf49fa964afe2f09d28313', 1,        'GRP004', 'Grupo de documento 004', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, null         , null),
  ('ef03744eaaa84d778d83c636577d4206', 1,        'GRP005', 'Grupo de documento 005', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, null         , null);

INSERT INTO documento.his_situacao_grupo_documento
  (id                                , grupo_documento_id                , situacao , motivo         , criador       , criacao) VALUES
  ('4fa06391bffa47bc893f8ea40b2739d3', '3ff86184807c46c78a68f9776d1e3cf3', 1        , 'criação'      , 'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('0a033625f090409cabc6bc353530a139', '3ff86184807c46c78a68f9776d1e3cf3', 2        , 'Motivo GRP001', 'duck.donald' , CURRENT_TIMESTAMP() - 260),
  ('5e9397ac84554d8cbfb3fa75f974183d', '9c7e6443a5934b098b6df530c3f6ce80', 1        , null           , 'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('7d07cd9a5a3e4f00ac8c65193fe97e6f', '8d175e3c58584cb2ab63061c0e47d951', 1        , null           , 'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('f6752a32a1004c17a2604327f95abd4d', '7928c551d1cf49fa964afe2f09d28313', 1        , null           , 'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('3195c0734ae24e57ba7c1ef62fc3a552', 'ef03744eaaa84d778d83c636577d4206', 1        , null           , 'mickey.mouse', CURRENT_TIMESTAMP() - 360);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Documentos                                                                                                                               ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO documento.tbl_documento
  (id,                                 grupo_documento_id,                 situacao, codigo,        periodicidade, tipo_dispensa, impacto_dispensa, vigencia_inicio,      vigencia_fim, nome,                     criador,          criacao,                   modificador,      modificacao) VALUES
  ('b07795e0900844a1b99e1ce7925051a5', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC01', 1,             1,             null,             CURRENT_DATE() - 360, null,         'Documento 001 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 100),
  ('4f7d4c136f7e4fd39179be78335698d8', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC02', 1,             2,             null,             CURRENT_DATE() - 360, null,         'Documento 002 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 200),
  ('edfc8516d5ae478dbd763da8243ba2d7', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC03', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 003 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 300),
  ('e8a589e6ca7c4bf0af53d46a92d1aea7', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC04', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 004 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null),
  ('5b9b7b2434404e3a9c73e78bc006abae', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP02-DOC05', 1,             0,             null,             CURRENT_DATE() - 360, null,         'Documento 005 do GRP02', 'thiagogarbazza', CURRENT_TIMESTAMP() - 360, null            , null);


--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Documentos dispensados                                                                                                                   ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO documento_esperado.tbl_documento_dispensado
  (id,                                 documento_id,                       cliente_id,                         situacao, data_base_inicio,     data_base_fim,        criador,          criacao,                   modificador,      modificacao) VALUES
  ('378e19cdabb049ecaa2a429b415c949c', 'b07795e0900844a1b99e1ce7925051a5', 'deba2cb2fc074a4fb818648a6b9bd9af', 2,        CURRENT_DATE() - 360, null,                 'thiagogarbazza', CURRENT_TIMESTAMP() - 400, 'thiagogarbazza', CURRENT_TIMESTAMP() - 100),
  ('78086fbcd95148ea8b07363c450749c8', 'b07795e0900844a1b99e1ce7925051a5', '126c1f8fcb594b07b8fdfe09050415cc', 1,        CURRENT_DATE() - 360, null,                 'thiagogarbazza', CURRENT_TIMESTAMP() - 400, null,             null),
  ('d4331dd74f4f499a81df9c2f8342cf00', '4f7d4c136f7e4fd39179be78335698d8', '126c1f8fcb594b07b8fdfe09050415cc', 1,        CURRENT_DATE() - 360, CURRENT_DATE() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 400, 'thiagogarbazza', CURRENT_TIMESTAMP() - 100),
  ('51c9c386c87c4c17bd9189f540f26077', '4f7d4c136f7e4fd39179be78335698d8', 'deba2cb2fc074a4fb818648a6b9bd9af', 1,        CURRENT_DATE() - 360, CURRENT_DATE() - 360, 'thiagogarbazza', CURRENT_TIMESTAMP() - 400, null,             null);

INSERT INTO  documento_esperado.his_situacao_documento_dispensado
  (id,                                 documento_dispensado_id,            situacao, criador,          criacao) VALUES
  ('554909b1a788424cab5d9006dbc625a4', '378e19cdabb049ecaa2a429b415c949c', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('88d76e83afa3489e973b2b3c66675e19', '378e19cdabb049ecaa2a429b415c949c', 2,        'thiagogarbazza', CURRENT_TIMESTAMP() - 260),
  ('5380bba0d9104e50a442c8137b26ffae', '78086fbcd95148ea8b07363c450749c8', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('d2a4609b1c6c40b888b5bca2c3e307a8', 'd4331dd74f4f499a81df9c2f8342cf00', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360),
  ('a7ce44dfab804c959fe33f4322ed289f', '51c9c386c87c4c17bd9189f540f26077', 1,        'thiagogarbazza', CURRENT_TIMESTAMP() - 360);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Documentos esperados                                                                                                                     ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

