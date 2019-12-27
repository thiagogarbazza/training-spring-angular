# Configurações do ambiente

## Propriedades de sistema

| Propriedade | Descrição                                             | Valores conhecidos |
|-------------|-------------------------------------------------------|--------------------|
| **ENV_ID**  |                                                       | dsen, homo, prod.  |

## Estrutura de diretórios no armazenamento/storage

| Diretório                               | Descrição                                    |
|-----------------------------------------|----------------------------------------------|
| /../documento/```${documentoId}```/anexo/ | Usado para armazenar os anexos do documento. |

> Observações:
>
> 1. No caminho do diretório a expressão ```${key}``` representa um parâmetro.
> 1. Os arquivos são salvos preferencialmente usando o id da entidade que representam.

## Arquivos de configuracação

Cada arquivo de configuração possui valores diferentes para as respectivas chaves conforme o ambiente de execução.

> Arquivo de configuração que se encontram alocados nos ambientes e é gerenciado pelo cliente.
