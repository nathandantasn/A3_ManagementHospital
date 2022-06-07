# Project: Management Hospital
Rest API to add, delete, update and search for patients, rooms and products being used in the hospital.
# 📁 Collection: GET, POST, PUT AND DELETE Pacient 


## End-point: GET All Pacients
Through this GET request, you can list all the patients that are recorded in the database. You can list by pagination, choosing the page number, the size of the list (number of patients on the page) and also the display order.
### Method: GET
>```
>http://localhost:8080/api/pacient
>```
### Response: 200
```json
{
    "content": [
        {
            "id": 1,
            "name": "João Guilherme Naval",
            "date": "17/04/1995",
            "age": 27,
            "registrationDate": "2022-06-07T02:47:52.456719",
            "cpf": "22345678910"
        },
        {
            "id": 2,
            "name": "Lucas Matiaz",
            "date": "21/09/1999",
            "age": 22,
            "registrationDate": "2022-06-07T02:51:06.461936",
            "cpf": "2234567122"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 3,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 2,
    "size": 3,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET Pacient By ID
Using a /{id} in the GET request link, you can list the corresponding patient. If the {id} informed is invalid, the request returns an Error STATUS 404 message.
### Method: GET
>```
>http://localhost:8080/api/pacient/id/
>```
### Response: 200
```json
{
    "id": 1,
    "name": "João Guilherme Naval",
    "date": "17/04/1995",
    "age": 27,
    "registrationDate": "2022-06-07T02:47:52.456719",
    "cpf": "22345678910"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: POST Pacient
# **POST Request Pacient**

Request to add patients to the database. If you try to add a person with the same CPF, it returns an Error 409 CONFLICT message.
### Method: POST
>```
>http://localhost:8080/api/pacient
>```
### Body (**raw**)

```json
{
    "name": "Lucas Matiaz",
    "date": "21/09/1999",
    "age": 22,
    "cpf": "2234567122"
}
```

### Response: 201
```json
{
    "id": 1,
    "name": "João Guilherme Naval",
    "date": "17/04/1995",
    "age": 27,
    "registrationDate": "2022-06-07T02:47:52.4567193",
    "cpf": "22345678910"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: PUT Pacient
With the PUT request we can update the database, changing the information with the body below, passing an {id} in the request link to locate the patient we want to change in the registration. If it does not find the patient, it returns an Error 404 Not Found message.
### Method: PUT
>```
>http://localhost:8080/api/pacient/id/
>```
### Body (**raw**)

```json
{
    "name": "João Guilherme Naval",
    "date": "17/04/1995",
    "age": 23
}
```

### Response: 200
```json
{
    "id": 1,
    "name": "João Guilherme Naval",
    "date": "17/04/1995",
    "age": 23,
    "registrationDate": "2022-06-07T02:47:52.456719",
    "cpf": "22345678910"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: DELETE Pacient
In the DELETE request we pass the {id} in the link to be able to delete the corresponding patient from the database. If {id} cannot be found, it shows an Error 404 Not Found message.
### Method: DELETE
>```
>http://localhost:8080/api/pacient/id/
>```
### Response: 200
```json
Pacient deleted successfully
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: GET, POST, PUT AND DELETE Room 


## End-point: GET All Rooms
Through this GET request, you can list all the rooms that are recorded in the database. You can list by pagination, choosing the page number, the size of the list (number of rooms on the page) and also the display order.
### Method: GET
>```
>http://localhost:8080/api/room
>```
### Response: 200
```json
{
    "content": [
        {
            "id": 2,
            "roomNumber": 37,
            "description": "Plus Room",
            "department": "B",
            "allocated": true,
            "registrationDate": "2022-06-07T03:07:20.416825"
        },
        {
            "id": 3,
            "roomNumber": 48,
            "description": "Deluxe Room",
            "department": "A",
            "allocated": true,
            "registrationDate": "2022-06-07T03:07:42.810189"
        },
        {
            "id": 4,
            "roomNumber": 25,
            "description": "Standard Room",
            "department": "C",
            "allocated": false,
            "registrationDate": "2022-06-07T03:07:59.53066"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 3,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 2,
    "totalElements": 4,
    "size": 3,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 3,
    "empty": false
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET Room By ID
Using a /{id} in the GET request link, you can list the corresponding room. If the {id} informed is invalid, the request returns an Error STATUS 404 message.
### Method: GET
>```
>http://localhost:8080/api/room/id/6
>```
### Response: 200
```json
{
    "id": 5,
    "roomNumber": 27,
    "description": "Standard Room",
    "department": "C",
    "allocated": false,
    "registrationDate": "2022-06-07T03:08:03.049484"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET Room By Room Number
Using a /{roomNumber} in the GET request link, you can list the corresponding room. If the {roomNumber} informed is invalid, the request returns an Error STATUS 404 message.
### Method: GET
>```
>http://localhost:8080/api/room/roomNumber/25
>```
### Response: 200
```json
{
    "id": 4,
    "roomNumber": 25,
    "description": "Standard Room",
    "department": "C",
    "allocated": false,
    "registrationDate": "2022-06-07T03:07:59.53066"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: POST Room
Request to add rooms to the database. If you try to add a room with the same room number, it returns an Error 409 CONFLICT message.
### Method: POST
>```
>http://localhost:8080/api/room
>```
### Body (**raw**)

```json
{
  "roomNumber": 27,
  "description": "Standard Room",
  "department": "C",
  "allocated": false
}
```

### Response: 201
```json
{
    "id": 1,
    "roomNumber": 25,
    "description": "Standard Room",
    "department": "C",
    "allocated": false,
    "registrationDate": "2022-06-07T03:02:13.4279627"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: PUT Room
With the PUT request we can update the database, changing the information with the body below, passing an {id} in the request link to locate the room we want to change in the registration. If it does not find the room, it returns an Error 404 Not Found message.
### Method: PUT
>```
>http://localhost:8080/api/room/id/10
>```
### Body (**raw**)

```json
{
  "roomNumber": 25,
  "description": "Presidential Room",
  "department": "A",
  "allocated": false
}
```

### Response: 200
```json
{
    "id": 1,
    "roomNumber": 25,
    "description": "Presidential Room",
    "department": "A",
    "allocated": false,
    "registrationDate": "2022-06-07T03:02:13.427963"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: DELETE Room
In the DELETE request we pass the {id} in the link to be able to delete the corresponding room from the database. If {id} cannot be found, it shows an Error 404 Not Found message
### Method: DELETE
>```
>http://localhost:8080/api/room/id/11
>```
### Response: 200
```json
Room deleted successfully
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: GET, POST, PUT AND DELETE Products 


## End-point: GET All Products
Through this GET request, you can list all the products that are recorded in the database. You can list by pagination, choosing the page number, the size of the list (number of products on the page) and also the display order.
### Method: GET
>```
>http://localhost:8080/api/product
>```
### Response: 200
```json
{
    "content": [
        {
            "id": 1,
            "name": "Dipirona Monoidratada",
            "description": "Medicamento analgésico e antitérmico, à base de dipirona, que pode ser utilizado no tratamento de dores e febre",
            "brand": "Novalgina",
            "price": 21,
            "date": "31/04/2025",
            "lote": "H2G7LOOOK98",
            "skuQuantity": 22,
            "registrationDate": "2022-06-07T03:27:06.236608"
        },
        {
            "id": 2,
            "name": "Cloridrato de Fexofenadina",
            "description": "destinado ao tratamento das manifestações alérgicas, tais como rinite alérgica e urticária (erupção na pele, geralmente de origem alérgica, que causa coceira).",
            "brand": "Allegra",
            "price": 80,
            "date": "31/10/2025",
            "lote": "KLJ78172HG1",
            "skuQuantity": 13,
            "registrationDate": "2022-06-07T03:32:34.174772"
        }
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "sorted": true,
            "unsorted": false
        },
        "offset": 0,
        "pageNumber": 0,
        "pageSize": 3,
        "unpaged": false,
        "paged": true
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 2,
    "size": 3,
    "number": 0,
    "sort": {
        "empty": false,
        "sorted": true,
        "unsorted": false
    },
    "first": true,
    "numberOfElements": 2,
    "empty": false
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET Product By ID
Using a /{id} in the GET request link, you can list the corresponding product. If the {id} informed is invalid, the request returns an Error STATUS 404 message.
### Method: GET
>```
>http://localhost:8080/api/product/id/2
>```
### Response: 200
```json
{
    "id": 2,
    "name": "Cloridrato de Fexofenadina",
    "description": "destinado ao tratamento das manifestações alérgicas, tais como rinite alérgica e urticária (erupção na pele, geralmente de origem alérgica, que causa coceira).",
    "brand": "Allegra",
    "price": 80,
    "date": "31/10/2025",
    "lote": "KLJ78172HG1",
    "skuQuantity": 13,
    "registrationDate": "2022-06-07T03:32:34.174772"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: POST Product
Request to add products to the database. If you try to add a room with the same lote description, it returns an Error 409 CONFLICT message.
### Method: POST
>```
>http://localhost:8080/api/product
>```
### Body (**raw**)

```json
{
    "name": "Cloridrato de Fexofenadina",
    "description": "destinado ao tratamento das manifestações alérgicas, tais como rinite alérgica e urticária (erupção na pele, geralmente de origem alérgica, que causa coceira).",
    "brand": "Allegra",
    "price": 80,
    "date": "31/10/2025",
    "lote": "KLJ78172HG1",
    "skuQuantity": 13
}

```

### Response: 201
```json
{
    "id": 1,
    "name": "Dipirona Monoidratada",
    "description": "Medicamento analgésico e antitérmico, à base de dipirona, que pode ser utilizado no tratamento de dores e febre",
    "brand": "Novalgina",
    "price": 22,
    "date": "31/04/2024",
    "lote": "H2G7LOOOK98",
    "skuQuantity": 22,
    "registrationDate": "2022-06-07T03:27:06.2366084"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: PUT Product
With the PUT request we can update the database, changing the information with the body below, passing an {id} in the request link to locate the product that we want to change in the registration. If it does not find the product, it returns an Error 404 Not Found message.
### Method: PUT
>```
>http://localhost:8080/api/product/id/1
>```
### Body (**raw**)

```json
{
    "name": "Dipirona Monoidratada",
    "description": "Medicamento analgésico e antitérmico, à base de dipirona, que pode ser utilizado no tratamento de dores e febre",
    "brand": "Novalgina",
    "price": 21,
    "date": "31/04/2025",
    "lote": "H2G7LOOOK98",
    "skuQuantity": 22
}

```

### Response: 200
```json
{
    "id": 1,
    "name": "Dipirona Monoidratada",
    "description": "Medicamento analgésico e antitérmico, à base de dipirona, que pode ser utilizado no tratamento de dores e febre",
    "brand": "Novalgina",
    "price": 21,
    "date": "31/04/2025",
    "lote": "H2G7LOOOK98",
    "skuQuantity": 22,
    "registrationDate": "2022-06-07T03:27:06.236608"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: DELETE Product
In the DELETE request we pass the {id} in the link to be able to delete the corresponding product from the database. If {id} cannot be found, it shows an Error 404 Not Found message
### Method: DELETE
>```
>http://localhost:8080/api/product/id/10
>```
### Response: 200
```json
Product deleted successfully
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

