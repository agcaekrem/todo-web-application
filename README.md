## Todo Web Application
-------------------------------------------------------------------------------
Project Requirements:
----
- Get all the customers 
- Add a new customer 
- Update an customer
- Delete an customer
- perform pagination on customers list page
- perform sorting on customers list page

#### Yukarıdaki özellikleri uygulayan bir Müşteri Yönetim Sistemi için Spring MVC web uygulaması oluşturacağım.

-------------------------------------------------------------------------------
Tools and technologies used:
-----
- IDE --> Intellij Idea
- MySQL --> 8.0
- Spring Boot 2.5.3
- Spring Framework
- Maven
- java 11
- Spring Data Jpa
- Thymeleaf


-------------------------------------------------------------------------------

![](https://drive.google.com/uc?export=view&id=1YmUVFOwHwXPaUaFeZQeLGz1cdzwNMQu4)


![](https://drive.google.com/uc?export=view&id=1dKP5lA2aJfyIp2NMRsHpthlL8Oi6OQwr)


#### Yukarıdaki ekran görüntüsü, bu projede geliştirdiğim CRUD işlemlerini özetler.


-------------------------------------------------------------------------------

 Paging
----

![paging](https://drive.google.com/uc?export=view&id=1WgkK65vLNcsm6dHkYoHh-kz0xi-24B3o)

-------------------------------------------------------------------------------
Sorting:
----
##### example;
- http://localhost:8080/page/1?sortField=lastName&sortDir=asc
- http://localhost:8080/page/1?sortField=firstName&sortDir=desc
