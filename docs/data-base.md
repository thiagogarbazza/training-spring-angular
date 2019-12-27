# Padrões utilizados para criar a Base de Dados

## Convenção de nomenclatura 

### Nome de tabelas

| Tipo           | Prefix | Preview                       | Descrição                                                                                                        |
|----------------|--------|-------------------------------|------------------------------------------------------------------------------------------------------------------|
| Schema         |        | NomeUnicoSchema               | Para criar um schema para agrupar as tabelas relacionadas, i.e. relacionadas como a segurança, usuario e perfil. |
| Table          |  tbl_  | tbl\_NomeTabela               | Para criar uma tabela de dados, como para os usuários e suas permissões.                                         |
| Relacionamento |  rel_  | rel\_NomeTabela1\_NomeTabela2 | Para criar tabelas que são puramente relacionamento, como o relacionamento entre usuário e suas permissões.      |
| View           |  viw_  | viw\_NomeView                 | Para criar uma view, muito utilizada para melhorar processo de pesquisa.                                         |
| Histórico      |  his   | his\_NomeTabela               | Para criar uma tabela que represente um histórico de uma situação ou de uma tabela                               |

### Nome de colunas

| Nome | Tipo           | Descrição                                                                                                         |
|------|----------------|-------------------------------------------------------------------------------------------------------------------|
| id   | uuid versão 4  | Campo que representa o identificador da tabela.                                                                   |
| cor  | varchar(21)    | Campo para armazenar cor `#F1D4D4` ou `rgba(241, 212, 212, 0.3)` ou `hsla(00%,53%,89%,0.3)`.                      |
|      |                |                                                                                                                   |


### Nome de chaves/restrições

| Tipo              | Prefix | Preview                                                | Descrição                               |
|-------------------|------- |--------------------------------------------------------|-----------------------------------------|
| Primary keys      |        | TableName\_id                                          | Informar a chave primária da tabela.    |
| Foreign keys      |   fk_  | fk\_ChildTable\_ChildColumn\_ParentTable\_ParentColumn | Informar a chave extrangeira na tabela. |
| Indexes           |  idx_  | idx\_TableName\_ColumnOne\_ColumnTwo\_uniq\_clust      | Informar o index do campo na tabela.    |
| Sequences         |  seq_  | seq\_TableName\_ColumnOne                              | Sequences a serem criadas.              |
| Unique constraint |   uc_  | uc\_TableName\_ColumnOne\_ColumnTwo                    | Unique constraints a serem criadas      |


### Nome de arquivos e suas extensões

| Tipo                  | Extensão | Preview              | Descrição                                                                                    |
|-----------------------|----------|----------------------|----------------------------------------------------------------------------------------------|
| Package specification | .pck.pks | nome-package.pck.pks | Criar um arquivo para cada [package specification][URL-PACKAGES] existente na base de dados. |
| Package definition    | .pck.pkd | nome-package.pck.pkd | Criar um arquivo para cada [package definition][URL-PACKAGES] existente na base de dados.    |
| Procedures            |   .prc   | nome-procedure.prc   | Criar um arquivo para cada [procedure][URL-PROCEDURES] existente na base de dados.           |
| Functions             |   .fnc   | nome-function.fnc    | Criar um arquivo para cada [function][URL-FUNCTIONS] existente na base de dados.             |
| Triggers              |   .trg   | nome-trigger.trg     | Criar um arquivo para cada [trigger][URL-TRIGGERS] existente na base de dados.               |

### Regras gerais

- Todas as palavras em minúscula, possivelmente separados por underscore.
- O nome da tabela deve estar sempre no singular (Exemplo: tbl_usuario no lugar de tbl_usuarios);
- Evite usar abreviações, se necessário use as conhecidas e documente;
- Evite o uso de números nos nomes de tabelas e colunas;
- Não utilize acentuações ou caracteres especiais, use da regex para validar os nomes ```^([a-z])[a-z_]+([a-z])$```.


[URL-FUNCTIONS]: http://www.tutorialspoint.com/plsql/plsql_functions.htm
[URL-PACKAGES]: http://www.tutorialspoint.com/plsql/plsql_packages.htm
[URL-PROCEDURES]: http://www.tutorialspoint.com/plsql/plsql_procedures.htm
[URL-TRIGGERS]: http://www.tutorialspoint.com/plsql/plsql_triggers.htm
