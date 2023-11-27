
    
### Build no projeto localmente

    $ mvn clean install

### Rodando o projeto localmente

Na raiz da aplicação: 

    $ mvn spring-boot:run

ou

    $ cd /target
    $ java -jar b2vn-radar-api.jar



## Instalação (Docker)


###  Criar network frm
    $ docker network create frm

### Build dos projetos
 
    $ docker image build -t frm-api .


### Criar o container com o parametro --name para especificar o network

    $ docker container run --network frm --name radar -p 8081:8081 -d frm-api
   



### Criar base de dados PostgreSQL para B2VN Auth API

    $ docker pull postgres

    $ docker pull dpage/pgadmin4

    $ docker run --name frm-db --network frm -e "POSTGRES_PASSWORD=frm-auth" -p 5432:5432 -v C:\db -d postgres

    $ docker run --name pgadmin4 --network frm -p 15432:80 -e "PGADMIN_DEFAULT_EMAIL=teste@gmail.com" -e "PGADMIN_DEFAULT_PASSWORD=frm-auth" -d dpage/pgadmin4]
    
### Acesso à base de dados

    Acesso em: localhost:15432

    host: frm-db
    port: 5432
    db: postgres
    username: postgres
    password: frm-auth

### Script de criação da base de dados e inserção dos dados iniciais

    CREATE DATABASE frm
        WITH 
        OWNER = postgres
        ENCODING = 'UTF8'
        LC_COLLATE = 'en_US.utf8'
        LC_CTYPE = 'en_US.utf8'
        TABLESPACE = pg_default
        CONNECTION LIMIT = -1;

    CREATE TABLE public.log (
        id int4 NOT NULL,
        usuario_id int4 NOT NULL,
        usuario_nome varchar(120) NOT NULL,
        usuario_email varchar(120) NOT NULL,
        usuario_permissao varchar(120) NOT NULL,
        usuario_descricao varchar(120) NOT NULL,
        tipo_operacao varchar(15) NOT NULL,
        data_acesso timestamp NOT NULL,
        metodo varchar(10) NOT NULL,
        url_acessada varchar(255) NOT NULL,
        servico_nome varchar(20) NOT NULL,
        servico_descricao varchar(20) NOT NULL,
        CONSTRAINT log_pkey PRIMARY KEY (id)
    );

    CREATE TABLE public.permissao (
        id int4 NOT NULL,
        descricao varchar(255) NOT NULL,
        codigo varchar(10) NULL,
        rate_limit int4 NULL,
        CONSTRAINT permissao_pkey PRIMARY KEY (id)
    );

    CREATE TABLE public.usuario (
        id int4 NOT NULL,
        cpf varchar(14) NULL,
        data_cadastro timestamp NOT NULL,
        email varchar(255) NOT NULL,
        nome varchar(120) NOT NULL,
        senha varchar(255) NOT NULL,
        ultimo_acesso timestamp NOT NULL,
        fk_permissao int4 NOT NULL,
        CONSTRAINT usuario_pkey PRIMARY KEY (id),
        CONSTRAINT fkqa04ym7nxtsl5oyyw205c4l2q FOREIGN KEY (fk_permissao) REFERENCES permissao(id)
    );

    INSERT INTO public.permissao (id,descricao,codigo,rate_limit) VALUES 
    (1,'Administrador','ADMIN',5)
    ,(2,'Usuário','USER',2)
    ;

    INSERT INTO public.usuario (id,cpf,data_cadastro,email,nome,senha,ultimo_acesso,fk_permissao) VALUES 
    (1,'103.324.589-54','2019-09-19 00:00:00.000','admin@admin.com','Usuário Administrador','$2a$10$NL.sPHyZeR/4Iu8hgbbWSej6qe89F96vwXLnagIDROvS8OShM5ase','2019-11-17 21:21:26.928',1);

    CREATE SEQUENCE public.hibernate_sequence
        INCREMENT BY 1
        MINVALUE 1
        MAXVALUE 9223372036854775807
        START 10038
        CACHE 1
        NO CYCLE;



## Documentação (Swagger)

### Documentação da autenticação
http://localhost:8080/swagger-ui.html

### Documentação dos radares
http://localhost:8081/swagger-ui.html


