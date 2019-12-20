--╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗
--╠═════════                                                 Banco de dados para teste integração                                                     ═════════╣
--╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝

INSERT INTO documento.tbl_grupo_documento
  (id,                                 situacao, codigo,   nome,                     criador,        criacao,                   modificador,   modificacao) VALUES
  ('3ff86184807c46c78a68f9776d1e3cf3', 2,        'GRP001', 'Grupo de documento 001', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 260),
  ('9c7e6443a5934b098b6df530c3f6ce80', 1,        'GRP002', 'Grupo de documento 002', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 200),
  ('8d175e3c58584cb2ab63061c0e47d951', 1,        'GRP003', 'Grupo de documento 003', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, 'duck.donald', CURRENT_TIMESTAMP() - 300),
  ('7928c551d1cf49fa964afe2f09d28313', 1,        'GRP004', 'Grupo de documento 004', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, null         , null),
  ('ef03744eaaa84d778d83c636577d4206', 1,        'GRP005', 'Grupo de documento 005', 'mickey.mouse', CURRENT_TIMESTAMP() - 360, null         , null);

INSERT INTO documento.his_situacao_grupo_documento
  (id,                                 grupo_documento_id,                 situacao, criador,        criacao) VALUES
  ('4fa06391bffa47bc893f8ea40b2739d3', '3ff86184807c46c78a68f9776d1e3cf3', 1,        'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('0a033625f090409cabc6bc353530a139', '3ff86184807c46c78a68f9776d1e3cf3', 2,        'duck.donald' , CURRENT_TIMESTAMP() - 260),
  ('5e9397ac84554d8cbfb3fa75f974183d', '9c7e6443a5934b098b6df530c3f6ce80', 1,        'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('7d07cd9a5a3e4f00ac8c65193fe97e6f', '8d175e3c58584cb2ab63061c0e47d951', 1,        'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('f6752a32a1004c17a2604327f95abd4d', '7928c551d1cf49fa964afe2f09d28313', 1,        'mickey.mouse', CURRENT_TIMESTAMP() - 360),
  ('3195c0734ae24e57ba7c1ef62fc3a552', 'ef03744eaaa84d778d83c636577d4206', 1,        'mickey.mouse', CURRENT_TIMESTAMP() - 360);
