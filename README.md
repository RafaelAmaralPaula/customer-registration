# API Cadastro De Clientes 

# Sobre o projeto

 - É um projeto referente ao desafio do bootcamp da **Dev Superior**.
 
 - Consiste basicamente em uma API na qual iremos cadastrar um cliente

# Enunciado do desafio 
 Você deverá entregar um projeto Spring Boot 2.4.x ou superior contendo um CRUD completo de web services REST para acessar um recurso de clientes, contendo as cinco operações básicas aprendidas no capítulo:

  - Busca paginada de recursos
  - Busca de recurso por id
  - Inserir novo recurso
  - Atualizar recurso
  - Deletar recurso

O projeto deverá estar com um ambiente de testes configurado acessando o banco de dados H2, deverá usar Maven como gerenciador de dependência, e Java 11 ou 17 como linguagem.

Um cliente possui nome, CPF, renda, data de nascimento, e quantidade de filhos. A especificação da entidade Client é mostrada a seguir (você deve seguir à risca os nomes de classe e atributos mostrados no diagrama):

  - Seu projeto deverá fazer um seed de pelo menos 10 clientes com dados SIGNIFICATIVOS (não é para usar dados sem significado como “Nome 1”, “Nome 2”, etc.).

**Atenção: crie um novo projeto para este trabalho. Não é para simplesmente acrescentar a classe Client no DSCatalog feitos nas aulas.**

**Atenção: lembre-se de que por padrão a JPA transforma nomes de atributos em camelCase para snake_case, como foi o caso do campo imgUrl do DSCatalog, que no banco de dados tinha o nome img_Url. Assim, o campo birthDate acima será criado no banco de dados como birth_Date, então seu script SQL deverá seguir este padrão.**

**Atenção: cuidado para não salvar no seu projeto arquivos e pastas que não devem ser salvas no Git, tais como a pasta .metadata do Eclipse.**


# Endpoints

  ### Busca paginada de clientes
  ```
  GET /clients?page=0&linesPerPage=6&direction=ASC&orderBy=name
  ```

  ### Busca de cliente por id
  ```
  GET /clients/1
  ```

  ### Inserção de novo cliente
  ```
  POST /clients
  {
    "name": "Maria Silva",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
  }
  ```

  ### Atualização de cliente
  ```
  PUT /clients/1
  {
    "name": "Maria Silvaaa",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
  }
  ```

### Deleção de cliente
```
DELETE /clients/1
```
 
# Tecnologias utilizadas 
 
## Back-end 
- Java
- Maven 
- Spring Data JPA
- Spring MVC
- Spring Boot
  
# Autor 
 
Rafael Amaral De Paula

LINKEDIN
-https://www.linkedin.com/in/rafael-amaral-449558148/

YOUTUBE
-https://www.youtube.com/channel/UC2QC0Jpjn1f0gHkk0TvvL_g


