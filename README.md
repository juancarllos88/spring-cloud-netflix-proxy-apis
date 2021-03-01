# spring-cloud-netflix-proxy-apis
[Criando proxy de APIs com Spring cloud, Zuul e Eureka](https://wp.me/p5RSbg-kW)

## Pré requisito
- Maven 3
- Java 8

## Preparando ambiente

- ```cd spring-cloud-netflix-proxy-apis```
- ```mvn clean package```

## Executando 

Service Discovery (Eureka)
- ```cd eureka```
- ```mvn spring-boot:run```

Proxy (Zuul)
- ```cd zuul```
- ```mvn spring-boot:run```

API de Customers
- ```cd customers```
- ```mvn spring-boot:run```

API de Products
- ```cd products```
- ```mvn spring-boot:run```

API de Payments
- ```cd payments```
- ```mvn spring-boot:run```

API de Providers
- ```cd providers```
- ```mvn spring-boot:run```

API de Sellers
- ```cd sellers```
- ```mvn spring-boot:run```


Acessando Eureka: http://localhost:8761
````
Instances currently registered with Eureka

Application	AMIs	Availability Zones	Status
CUSTOMERS	n/a (1)	(1)	UP (1) - 192.168.11.247:customers:8060
PRODUCTS	n/a (1)	(1)	UP (1) - 192.168.11.247:products:8070
PAYMENTS	n/a (1)	(1)	UP (1) - 192.168.11.247:payments:8020
PROVIDERS	n/a (1)	(1)	UP (1) - 192.168.11.247:providers:8030
SELLERS	n/a (1)	(1)	UP (1) - 192.168.11.247:sellers:8040
ZUUL	      n/a (1)	(1)	UP (1) - 192.168.11.247:zuul:8080
````

## Acessando APIs

#### Diretamente
- http://localhost:8070/products
- http://localhost:8060/customers
- http://localhost:8020/payments
- http://localhost:8030/providers
- http://localhost:8040/sellers

#### Via Proxy (Zuul)
- http://localhost:8080/api/products
- http://localhost:8080/api/customers
- http://localhost:8080/api/payments
- http://localhost:8080/api/providers
- http://localhost:8080/api/sellers

