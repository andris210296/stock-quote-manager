# stock-quote-manager
This is an application that communicates with an stock-manager and its responsible to store stock quote
  
##### Run Database on Docker
> docker container run -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=bootdb -p 3306:3306 -p 33060:33060 -d mysql:8 

##### Run stock-manager

> docker container run -p 8080:8080 -d lucasvilela/stock-manager
 
##### Add new stock quote
> http://localhost:8081/addQuote

```json
{ 
    "id": "petr3", 
    "quotes": 
    { 
        "2019-01-01" : "10", 
        "2019-01-02" : "11", 
        "2019-01-03" : "14" 
    } 
}
```

##### Read stock quote
> http://localhost:8081/ggbr4

##### Read all stock
> http://localhost:8081/allQuotes

