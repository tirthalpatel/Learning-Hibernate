Hibernate learning made easy
=========================

Sample code snippet for getting started with Hibernate. Read related blog post [here](http://tirthalpatel.blogspot.in/2014/04/hibernate-learning-made-easy.html).


Steps to create new Hibernate project using Maven (Optional)
------------------------------------------------------------

(1) Create new project using Eclipse IDE or Maven command.

	Create Maven Project
	Eclipse -> New -> Maven Project
	
	or
	
	mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=com.tirthal.learning -DartifactId=HibernateQuickStart -Dversion=1.0.0
	mvn eclipse:eclipse

(2) [Install Jboss Tools Plugins in Eclipse] (http://hibernate.org/orm/tooling/).

(3) Open project in Eclipse and added dependencies for Hibernate in pom.xml file of Maven.

(4) You have project structure ready to use Hibernate.


Skip steps of creating new project, instead use this project directly for quick start 
-------------------------------------------------------------------------------------

(1) Download / Clone this project to your local machine.

(2) Just import "HibernateQuickStart" project in Eclipse and switch to Hibernate perspective. Fix build path errors, such as JRE configuration. That's it.


Database setup and configuration requirements
----------------------------------------------

(1) Create "hibernate_quick_start" schema in MySQL (or your choice of database).

(2) If you select any database other than MySQL, then ensure you configure database driver in pom.xml file for given database.

(3) please ensure correct database configuration in [hibernate.cfg.xml] (https://github.com/tirthalpatel/Learning-Hibernate/blob/master/src/main/resources/hibernate.cfg.xml) file.

(4) Excellent. You are ready to get started with learning Hibernate.


Establishing Database Connection
---------------------------------

Run and explore code of [TestDbConnectionApp.java] (https://github.com/tirthalpatel/Learning-Hibernate/blob/master/src/main/java/com/tirthal/learning/TestDbConnectionApp.java).

If you get exception, please ensure correct database configuration in [hibernate.cfg.xml] (https://github.com/tirthalpatel/Learning-Hibernate/blob/master/src/main/resources/hibernate.cfg.xml) file. Once you can run this program without any error, then only proceed further. 


Basic Mapping
-------------

[Demo code of mapping between "HelloWorld" java entity and "HELLO_WORLD" table in database] (https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/helloworld).


O/R Mapping
------------

Mapping component, Mapping value type collections (set, list, map, bag), Mapping entity relationships (one to many, one to one, many to one, many to many), Mapping inheritance

[Understand by code snippet] (https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/mapping)


Querying
--------

HQL / JPA QL (Hibernate / JPA query language), Hibernate criteria API, Native SQL

[Understand by code snippet] (https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/querying)


Annotations
------------

[Understand by code snippet] (https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/annotations)


Advance Topics
--------------

Hibernate Caching, Batch Processing, Interceptors, Listeners, Data Filters, OSGi support... 

[Explore Hibernate documentation] (http://hibernate.org/orm/documentation/)


Hibernate and Spring integration - Write less code
---------------------------------------------------

The Spring framework provides HibernateTemplate class, so you don't need to follow so many steps like create Configuration, BuildSessionFactory, Session, beginning and committing transaction etc.


Also Refer
----------
 
Hibernate Tutorials at - [tutorialspoint](http://www.tutorialspoint.com/hibernate/index.htm) & [javatpoint](http://www.javatpoint.com/hibernate-tutorial)