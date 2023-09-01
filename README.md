<h1 align="center">
  API AERO
</h1>


O projeto foi elaborado para o desafio Horizon.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Postgree](https://www.postgresql.org/download/)

## Práticas adotadas

- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro


## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/aeroapi-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).


## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/downloads/):
antes de começar tenha a collection:
importe ela  para o postman.

## Execute Querys no sql:
crie um banco de dados com nome iata no postgree;
va em main, resources e copie e cole as querys do data sql no postgree.
## Configuração de login:
No postman vá na pasta login;
Rota Registrar Usuario:
```
{
"login": "renatocelo",
"password": "123",
"role": "ADMIN"  
}
```
Depois vai na rota login:
```
$http://localhost:8080/auth/login
{
"login": "renatocelo",
"password": "123"  
}
```
vai ser gerado e token no retorno para ser usado na rotas protegidas:
Na rota aonde fica auth, adicione um type: Bearer Token gerados nestas rotas então ela são 
liberadas para teste:
 "/voos")
"/voos/passageiro")
"/voos")
 "/voos")
"/voos")
 "/aeroportos")
 "/passagem/cadastrapassagem")
 "/passagem/alterarpreco")
 "/passagem/passageirolistavoo"
"/passagem/passagemvoo"

Rotas públicas:

POST, "/auth/login")
POST, "/auth/register")
GET, "/voos").permitAll()
PATCH, "/passagem/cancelarcompra")
PATCH, "/passagem/comprarpassagem")
GET, "/passagem/compras")
GET, "/passagem/cpf")
POST, "/passagem/emitirvoucher")
POST, "/passagem/emitiretiquetabagagem")

- Listar Aeroportos
```
$ http GET :8080/aeroportos nome="Todo 1" 

```

- Listar Voos
```
$ http GET :8080/voos
```

- Cadastrar Voos
```
$ http POST :8080/voos 

{
    "numero": "1",
    "dataHoraPartida": "01/10/2023 06:40:00",
    "origemAeroporto": 1,
    "destinoAeroporto": 2,
    "flagVooCancelado": false,
    "classes": [
        {
            "tipo": "Regular",
            "capacidadeMaxima": 200,
            "valorAssento": 200
        },
        {
            "tipo": "Especial",
            "capacidadeMaxima": 200,
            "valorAssento": 400
        }
    ]
}
```

- Atualizar Voos
```
http PUT :8080/voos?idVoo=1
Params:
idVoo: 1
{
    "numero": "1",
    "dataHoraPartida": "01/10/2023 06:40:00",
    "origemAeroporto": 1,
    "destinoAeroporto": 2,
    "flagVooCancelado": true
}
```

- Cancelar Voo
```
http PATCH :8080/voos?idVoo=1&flagVooCancelado=false
Params:
idVoo: 1
flagVooCancelado: FALSE
1
```

- Cadastrar Passagens
```
http POST :8080/passagem/cadastrapassagem
{ 
            "precoTotal": 200,
            "classe": 2,
            "passageiro": null,
            "voo": 1
}    
```
- Emitir voucher Passagem
```
http POST :8080/passagem/emitirvoucher
{ 
            "numeroPassagem": "1",
            "numeroVoo": "1",
            "origem": "Salvador Bahia Airport",
            "destino": "Aeroporto Internacional de São Paulo-Guarulhos",
            "passageiro": 1,
            "despachoBagagem": true
}         
```
- Emitir etiqueta bagagem Passagem
```
http POST :8080/passagem/emitiretiquetabagagem
{ 
            "numeroVoo": "1",
            "numeroPassagem": "1",
            "numeroBagagem": "1",
            "nomePassageiro": "Renato Marcelo"
}         
```
- Atualizar preços de passagem
```
http PATCH :8080/passagem/alterarpreco?idPassagem=1&precoTotal=550
Params:
idPassagem: 1
idPassagem: 550
    
```
- Cancelar compra de passagem
```
http PATCH :8080/passagem/cancelarcompra?idPassagemidPassagem=1&idVoo=550&cpf
Params:
idPassagemidPassagem: 1
idVoo: 1
cpf: 99999
```

- Ver passageiros de um voo
```
http PATCH :8080/passagem/passageirolistavoo?idVoo=1
Params:
idVoo: 550

```

- Ver obter passagens por cpf
```
http PATCH :8080/passagem/cpf?cpf=999999
Params:
cpf: 999999

```
- Obter passagens por cpf
```
http PATCH :8080/passagem/cpf?cpf=999999
Params:
cpf: 999999

```
- obter passagens voo
```
http PATCH :8080/passagem/passagemvoo?origem=1&destino=2&data=01/10/2023 06:40:00&precoPassagem=200
Params:
origem: 1
destino: 2
data: 01/10/2023 06:40:00
precoPassagem: 200
```
