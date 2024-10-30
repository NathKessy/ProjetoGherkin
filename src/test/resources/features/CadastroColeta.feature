#language:pt


Funcionalidade: Cadastro de coleta

  Cenario: Inserir uma coleta com sucesso
    Dado que eu tenha os seguintes dados da coleta:
      | campo           | valor                              |
      | tipoColeta      | Vidro                              |
      | dataColeta      | 2023-05-01                         |
      | nomeContato     | Bernabau Alves                     |
      | telefoneContato | 11912345678                        |
      | emailContato    | bernabau@example.com               |
      | enderecoContato | Rua do Paraiso, 123 - Assunção, SP |
    Quando eu enviar a requisicao POST para o endpoint "/api/coleta" para cadastro da coleta
    Então o status code deve retornar 201

