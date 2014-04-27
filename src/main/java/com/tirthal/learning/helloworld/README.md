Hello World for basic mapping demo
------------------------------------

Demo code of mapping between "HelloWorld" java entity and "HELLO_WORLD" table in database. 

(1) Create POJO (for example - HelloWorld.java)

(2) Create Mapping File to map Java entity with database table (for example - HelloWorld.mapping.xml)

(3) Update "hibernate.cfg.xml"
	- Add mapping file
	- Configure for automatic schema creation (ONLY RECOMMENDED FOR DEVELOPMENT. DO NOT USE IN PRODUCTION.)

(4) Save, Get/Load, Update and Read - some data using hibernate session. Run code of "TestHelloWorldApp.java" and explore it.


Hibernate Application Architecture - Key Classes [org.hiternate.*]
------------------------------------------------------------------

* Configuration - DB configuration, Class mapping setup (hibernate.cfg.xml, hibernate.properties).

* SessionFactory - Thread safe object to instantiate Session object, Heavy-weight object, Usual created on application startup and kept for later use, One SessionFactory object for per database using a separate configuration file, If multiple databases, then need multiple SessionFactory objects.

* Session - To get physical connection of db, lightweight, usually not thread-safe, instantiate for each db interaction.
 
* Transaction - Transactions in Hibernate are handled by an underlying transaction manager and transaction (from JDBC or JTA).

* Query - Query objects use SQL or Hibernate Query Language (HQL) string to retrieve data from the database and create objects. A Query instance is used to bind query parameters, limit the number of results returned by the query, and finally to execute the query.

* Criteria - Criteria object are used to create and execute object oriented criteria queries to retrieve objects.


Sample Image of Code snippet
-----------------------------

![sample hibernate code snippet] (https://raw.githubusercontent.com/tirthalpatel/Learning-Hibernate/master/images/Hibernate-GettingStartedCode.png "This shows you sample hibernate code snippet")
 