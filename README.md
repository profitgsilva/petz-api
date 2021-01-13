# Petz-api
Rest API Petz.

#Observações p/ realização dos testes.

A API está publicada em ambiente Cloud Red Hat OpenShift, onde também encontra-se o banco de dados PostgreSQL.
Você pode utilizar o Postman ou SoapUI 5.5 para realizar os testes.

Na pasta documents do projeto encontra-se os scripts e modelagem para criação do banco de dados, bem como as
collections Json para inportação no SoapUI.

#Operações da API.

#Clientes

POST: Cadastro de clientes
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/create/customer
Payload
{
	"name" : "Rachel Zane",
	"email" : "zane@gmail.com"
}

GET: Consulta de cliente por ID
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/read/customer/1

PUT: Atualização do cadastro de clientes
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/update/customer/1
Payload
{
	"name" : "Rachel Zane",
	"email" : "zane@gmail.com"
}

DELETE: Exclusão de clientes cadastrado
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/delete/customer/1

#Pets

POST: Cadastro de pets
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/create/pet
Payload
{
	"name" : "Sptiz",
	"age" : 2,
	"customer": {
		"id" : 1
	}
}

Observações: 
Essa operação lança uma ConstraintViolationException caso um Pet seja cadastrado para um cliente não cadastrado.
A idéia aqui é, um cliente pode ser cadastrado sem ter um Pet, porém um pet não pode ser cadastrado sem um dono.
Existe uma FK entre as tabelas Customer e Pet.

GET: Consulta de pet por ID
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/read/pet/1

Observações:
Ao consultar o PET pelo ID as informações do dono também serão carregadas.

PUT: Atualização do cadastro de pets
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/update/pet/1
Payload
{
	"name" : "Sptiz Alemão",
	"age" : 2,
	"customer": {
		"id" : 1
	}
}

DELETE: Exclusão de pets cadastrado
http://petz-api-profit-saas-listbus.b9ad.pro-us-east-1.openshiftapps.com/petz/api/v1/public/delete/pet/1


