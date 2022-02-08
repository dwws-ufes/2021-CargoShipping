# 2021-CargoShipping
Assignment for the 2021 edition of the "Web Development and the Semantic Web" course, by Maurício Antônio Buffon Júnior, Fernando Guerra Rodrigues Machado, Rebeca Cecco de Oliveira and Matheus de Abreu Bozzi

Passo 1:
docker container prune -f
docker image prune -f
docker volume prune -f (verificar se você não vai perder nada importante)

Passo 2:
docker build --pull --rm -f "Dockerfile" -t dwws/wildfly:24.0.1-preview "." 

Passo 3:
docker-compose up -d

Acesso ao PGADMIN: http://localhost:5050
Usuário: user@dwws.ufes.br
Senha: secret

Acesso ao WILDFLY (admin console): http://localhost:9990
Usuário: wildfly-manager
Senha: 1234

Passo 4:

a)- Depois de logar no PGADMIN, mapear a conexão com o postgres:
host: postgres
port: 5432
username: postgres
password: secret


b)- Criar 'Login/Group Role'
name: APP
password: secret
can login: yes

c)- Criar base de dados 'cargo-shipping' e conceder ao usuário APP permissão de conexão

d)- TODO: por escrever (executar script de criação das tabelas localizado na pasta documents e eventual script de carga)

Passo 5: compilar a aplicação (mvn clean package)

Passo 6: Logar na console admin do WILDFLY e fazer o deploy

