#language:pt

Funcionalidade: Busca coleta por ID

  Cenario: Buscar coleta existente por ID com sucesso
    Dado que existe uma coleta com ID:
      | campo | valor |
      | id | 5 |
      | tipoColeta | Papel |
      | dataColeta | 2023-05-01 |
      | nomeContato | Contato Um |
      | telefoneContato | 123456789 |
      | emailContato | contato1@example.com |
      | enderecoContato | Rua A, 123, Cidade X |
    Quando eu faço uma requisição GET para "/api/coleta/5" para procurar a coleta
    Então o status code da resposta deve ser 200

  Cenario: Buscar coleta existente por ID sem sucesso
    Dado que existe uma coleta com ID:
      | campo | valor |
      | id | 1 |
      | tipoColeta | Vidro |
      | dataColeta | 2023-05-01 |
      | nomeContato | Contato Um |
      | telefoneContato | 123456789 |
      | emailContato | contato1@example.com |
      | enderecoContato | Rua A, 123, Cidade X |
    Quando eu faço uma requisição GET para "/api/coleta/1" para procurar a coleta
    Então o status code da resposta deve ser 404
#    E o corpo de resposta de erro da api deve retornar a mensagem "Dados fornecidos são inválidos."

