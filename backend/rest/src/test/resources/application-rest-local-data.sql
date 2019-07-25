--╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
--╠═════════ Banco de dados para execução local                                                                                                       ═════════╣
--╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝


--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Clientes                                                                                                                                 ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘
INSERT INTO cliente.tbl_cliente
  (id,                                 codigo,    nome,         criador,          criacao,                 modificador,     modificacao) VALUES
  ('deba2cb2fc074a4fb818648a6b9bd9af', 'CLI001', 'Cliente 001', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, 'thiagogarbazza', CURRENT_TIMESTAMP - 100),
  ('126c1f8fcb594b07b8fdfe09050415cc', 'CLI002', 'Cliente 002', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, 'thiagogarbazza', CURRENT_TIMESTAMP - 200),
  ('ad5c316d24724d1eb6f76d4c96b9b1cb', 'CLI003', 'Cliente 003', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, 'thiagogarbazza', CURRENT_TIMESTAMP - 300),
  ('fbeaf5ea671541f9a7fc71495f8ca86f', 'CLI004', 'Cliente 004', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, null            , null),
  ('3b75a592f67549ab8b8e605faff8d12d', 'CLI005', 'Cliente 005', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, null            , null);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Grupo de documentos                                                                                                                      ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘

INSERT INTO documento.tbl_grupo_documento
  (id,                                 situacao, codigo,   nome,                    criador,          criacao,                 modificador,    modificacao) VALUES
  ('3ff86184807c46c78a68f9776d1e3cf3', 2,        'GRP001', 'Grupo de documento 001', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, 'thiagogarbazza', CURRENT_TIMESTAMP - 100),
  ('9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP002', 'Grupo de documento 002', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, 'thiagogarbazza', CURRENT_TIMESTAMP - 200),
  ('8d175e3c58584cb2ab63061c0e47d951', 1,        'GRP003', 'Grupo de documento 003', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, 'thiagogarbazza', CURRENT_TIMESTAMP - 300),
  ('7928c551d1cf49fa964afe2f09d28313', 1,        'GRP004', 'Grupo de documento 004', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, null            , null),
  ('ef03744eaaa84d778d83c636577d4206', 1,        'GRP005', 'Grupo de documento 005', 'thiagogarbazza', CURRENT_TIMESTAMP - 360, null            , null);

INSERT INTO documento.his_situacao_grupo_documento
  (id,                                 grupo_documento_id,                 situacao, criador,          criacao) VALUES
  ('4fa06391bffa47bc893f8ea40b2739d3', '3ff86184807c46c78a68f9776d1e3cf3', 1,        'thiagogarbazza', CURRENT_TIMESTAMP - 360),
  ('0a033625f090409cabc6bc353530a139', '3ff86184807c46c78a68f9776d1e3cf3', 2,        'thiagogarbazza', CURRENT_TIMESTAMP - 260),
  ('5e9397ac84554d8cbfb3fa75f974183d', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'thiagogarbazza', CURRENT_TIMESTAMP - 360),
  ('7d07cd9a5a3e4f00ac8c65193fe97e6f', '8d175e3c58584cb2ab63061c0e47d951', 1,        'thiagogarbazza', CURRENT_TIMESTAMP - 360),
  ('f6752a32a1004c17a2604327f95abd4d', '7928c551d1cf49fa964afe2f09d28313', 1,        'thiagogarbazza', CURRENT_TIMESTAMP - 360),
  ('3195c0734ae24e57ba7c1ef62fc3a552', 'ef03744eaaa84d778d83c636577d4206', 1,        'thiagogarbazza', CURRENT_TIMESTAMP - 360);

--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Ddocumentos                                                                                                                              ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘



--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Ddocumentos esperados                                                                                                                    ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘



--┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐
--├───────── Ddocumentos processados                                                                                                                  ─────────┤
--└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘