# ⚡ Automação de API - Projeto "Reator Stark" (DIO)

## 🛠️ Sobre o projeto
Sabe aquela clássica história de construir um reator Arc numa caverna usando sucata? A vibe que eu tive nesse projeto foi exatamente essa. Este repositório guarda a minha solução prática para o desafio de automação de testes de API da DIO (Digital Innovation One). 

A minha missão principal era pegar uma API pública (Restful-booker), destrinchar a documentação e criar scripts em Java para testar as engrenagens deles de forma 100% automatizada. 

Como eu queria entregar um projeto com nível de engenharia real, levei a analogia a sério: calibrei o motor principal configurando o projeto para o Java 17, criei meus scripts de injeção de dados usando Rest Assured, acoplei uma interface gráfica para os logs e, de quebra, montei o meu próprio servidor de testes local só pra provar que eu não apenas testo sistemas alheios, mas construo os meus também.

## ⚙️ Funcionalidades do projeto
Aqui está o que eu ensinei a minha "armadura" a fazer sozinha:

* **Fluxo de Testes Completo (CRUD):** Meu código consegue ler (GET), criar (POST), atualizar (PUT) e deletar (DELETE) reservas direto no banco de dados da API Restful-booker.
* **Injeção Dinâmica de Credenciais:** O script gera o token de administrador da API automaticamente, guarda na memória e já usa para autorizar as alterações na sequência. Nada de "copiar e colar" tokens manualmente.
* **Painel de Telemetria (Allure):** Geração de relatórios visuais e gráficos através do Allure Report. Ler log em terminal preto e branco é coisa do passado; eu implementei um painel visual completo.
* **Reator Secundário (Mock Server):** Cumprindo o desafio bônus (Nível Sênior), eu criei um servidor local simulando um banco de dados de veículos do zero, e coloquei o meu código Java para se comunicar com ele e realizar injeções de dados (POST) com sucesso.

## 🔧 Ferramentas utilizadas
Estas foram as peças e tecnologias que eu usei para montar esse ecossistema:

* **Java 17** (A linguagem base do reator)
* **Maven** (Meu montador de peças e gerenciador de dependências)
* **Rest Assured** (A biblioteca tática que faz as requisições HTTP)
* **JUnit 5** (O motor de ignição que roda e valida os testes)
* **Allure Framework** (A lente do radar para gerar a interface gráfica de resultados)
* **Node.js + JSON Server** (Para rodar o meu próprio banco de dados falso offline)

## 🚀 Como ligar o reator na sua máquina
Se você quiser clonar esse projeto e rodar aí no seu computador, é só plugar os cabos:

1. Navegue até a pasta principal do projeto Java: 
   ```bash
   cd automacao-api

2. Dispare a automação e abra o painel visual com o Maven:
 ```bash
mvn clean test allure:serve

(Opcional) Para ligar o meu servidor simulado de veículos, vá na pasta dele e rode o Node:

cd mock-server
npx json-server db.json

***

##📡 Sincronização Final
Depois de salvar o arquivo no VS Code com esse texto novo, abra o terminal na pasta raiz do projeto (`Projeto de Testes API`) e mande a atualização para o GitHub:

```bash
git add README.md
git commit -m "docs: Refatora o README para apresentacao de portfolio"
git push