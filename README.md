# Projeto DevOps - Checkpoint 4 (Segundo Semestre)

## Descrição
Aplicação Java com Spring Boot para gerenciamento de transações, utilizando **MySQL** como banco de dados.  

O objetivo principal deste projeto é demonstrar a orquestração de containers usando **Docker Compose**, integrando a aplicação Java com o banco de dados de forma automática.

## Funcionalidades
- Subir containers da aplicação e do banco de dados com um único comando.  
- Rede, variáveis de ambiente e volumes configurados automaticamente pelo Docker Compose.  
- Persistência de dados no MySQL via volume.  

## Como Rodar
1. Clone o repositório:  
   ```bash
    git clone https://github.com/christianmilfont/CP4-DEVOPS.git
   ```

   Navegue ate a pasta do projeto
```
   cd dimdim-compose
```

   Execute o Docker Compose
```
  docker compose up -d
```
