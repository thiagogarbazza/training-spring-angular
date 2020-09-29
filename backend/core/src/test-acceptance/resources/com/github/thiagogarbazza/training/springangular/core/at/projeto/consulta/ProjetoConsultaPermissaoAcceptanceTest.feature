# language: pt

Funcionalidade: Controle de acesso a consulta de projetos

  Esquema do Cenário:  01 - Validar acesso à consulta de projetos
    Dado que o usuário "<Login do usuário>" está logado no sistema como "<Perfil do usuário>".
    Quando o usuário tenta acessar a funcionalidade de consulta de projetos.
    Então o sistema deverá verificar se o usuário "<Permite>" pode acessar a funcionalidade.
    Exemplos:
      | Login do usuário | Perfil do usuário | Permite |
      | DEINF.ESCALDA    | Funcionário       | Não     |
