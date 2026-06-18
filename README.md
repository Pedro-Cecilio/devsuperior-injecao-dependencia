# Projeto Injeção de dependência - Devsuperior

### Como executar o projeto
Na raiz do projeto insira o seguinte comando, passando os argumentos desejados:
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--code=2282 --basic=800.00 --discount=10.0"
```

### O que é o projeto? 
O projeto se trata de um exercício básico para introduzir ao conceito de injeção de dependência e inversão de controle.

#### As entradas esperadas são: 
- --code: Código do pedido. Exemplo: 1034
- --basic: Valor básico do pedido. Exemplo: 1000.00
- --discount: Porcentagem de desconto disponibilizada para o pedido. Exemplo 20.00

