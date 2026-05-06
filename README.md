# Compilador com IDE integrada usando GALS

Projeto desenvolvido para a disciplina de Compiladores, consistindo em uma IDE simples em Java integrada a um analisador léxico, sintático e semântico gerado com o **GALS**.

O sistema permite carregar e analisar códigos escritos na linguagem definida no projeto, exibindo o resultado do processo de compilação e auxiliando na identificação de erros léxicos, sintáticos e estruturais.

---

## Objetivo do projeto

Este projeto tem como objetivo aplicar, na prática, conceitos fundamentais da construção de compiladores, incluindo:

- análise léxica
- análise sintática
- tratamento de erros
- integração entre componentes do compilador
- execução de um analisador dentro de uma interface Java

Além da parte teórica de compiladores, o projeto também envolve a organização de código-fonte em Java e a comunicação entre a IDE e o parser gerado pelo GALS.

---

## Estrutura do projeto

```bash
CompiladoresIDE/
├── ide/
│   ├── Compiler.java
│   ├── GalsParserBridge.java
│   ├── Main.java
│   └── bin/
│
├── parser-src/
│   ├── AnalysisError.java
│   ├── Constants.java
│   ├── Lexico.java
│   ├── Sintatico.java
│   └── ...
│
├── parser-bin/
│   └── arquivos .class
│
└── README.md
```

---

## Descrição das pastas

`ide/`

Contém a interface do sistema e a integração com o compilador.

Arquivos principais:

- Compiler.java
- GalsParserBridge.java
- Main.java

---

`parser-src/`

Contém os arquivos-fonte Java gerados a partir da especificação criada no GALS.

Responsável por:

- análise léxica
- análise sintática
- mensagens de erro
- validações estruturais

---

`bashparser-bin/`

Contém os arquivos compilados **.class** gerados a partir dos arquivos de **parser-src**.

---

## Funcionamento do sistema

O projeto é dividido em duas partes principais:

### IDE

A interface permite:

- carregar código-fonte
- executar análise
- visualizar mensagens
- interagir com o compilador

### Compilador

O analisador gerado pelo GALS é responsável por:

- reconhecer tokens
- validar sintaxe
- detectar erros
- processar a linguagem definida no projeto

A comunicação entre a IDE e o compilador ocorre pelas classes Java responsáveis pela integração entre ambos.

---

## Requisitos

Para executar o projeto, é necessário ter instalado:

- Java JDK
- Recomendado: **JDK 17 ou superior**

Para verificar se o Java está configurado corretamente:

```
java -version
javac -version
```

---

## Como compilar e executar

Abra o terminal na pasta principal do projeto:\
**CompiladoresIDE**\

1. **Compilar o parse:r**
   `javac -d parser-bin parser-src\*.java`
2. **Compilar a IDE:**
   `javac -d ide\bin ide\*.java`
3. **Executar o programa:**
   `java -cp ide\bin Main`

---

## Caso o arquivo .gals seja alterado

Se a gramática ou especificação do GALS for modificada:

**Passos:**\

1. Abrir o arquivo .gals no WebGALS
2. Gerar novamente os arquivos .java
3. Substituir os arquivos dentro de parser-src/
4. Recompilar o parser:
   `javac -d parser-bin parser-src\*.java`
5. Executar normalmente o sistema

---

## Caso a IDE seja alterada

Se algum arquivo dentro da pasta `ide/` for modificado:
`javac -d ide\bin ide\*.java`\

Depois execute:
`java -cp ide\bin Main`

---

## Tecnologias e conceitos utilizados

- Java
- GALS / WebGALS
- Compiladores
- Análise Léxica
- Análise Sintática
- Tratamento de Erros
- Integração entre módulos

---

## Autores

**Candido Fachini Neto**  
**Garrik Bez Schoepping**

**Projeto acadêmico desenvolvido para a disciplina de Compiladores.**
