Basic concepts for mapping
===========================

Value type vs. Entity
----------------------
* Person is Entity. Person has a mobile, in which case mobile is also separate Entity. Because mobile can exist without a person. 
* Person has a leg, in which leg is a value type. Because value type cannot exist by own, so for example leg cannot exist by own without a person.
	
	
Identifying Directionality / Navigations
-----------------------------------------
* That means which direction the data goes from one piece to another.
* Analyze your domain and requirement to know in which direction, you need to navigate the object-graph. For example - Bill -> Customer or Customer -> List<Bill>.
* Unidirectional (For example, Car ---> Wheel = car has reference to a wheel, but wheel has never reference to the car)
* Bidirectional  (For example, Car <---> Wheel = both car and wheel has reference to each other)


Identifying Multiplicity for mapping Domain Model
--------------------------------------------------
* If we are trying to identify association of entity A with entity B, ask the question 
(1) With one instance of B, how many instances of A can be associated? 
(2) With one instance of A, how many instances of B can be associated?

* If answer to both of above questions results in many, association is many-to-many.
* If one of them is one, association is many-to-one or one-to-many.
* If both answers are one, it is one-to-one.
	
	
Mapping component
------------------
[Understand by code snippet](https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/mapping/component)


Mapping value type collections
------------------------------ 
Mapping a set - only unique is allowed and it is unordered. 
Mapping a list - duplicate is allowed and is ordered. 
Mapping a map - key and value pair. 
Mapping a bag - for plain collection. 

[Understand by code snippet](https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/mapping/collection)


Mapping Association of Domain Model 
-----------------------------------
Mapping many-to-one association. 
Mapping many-to-many association. 
Mapping one-to-many association.
Mapping one-to-one association.

[Understand by code snippet](https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/mapping/association)


Mapping Inheritance
--------------------
Table per subclass - [Understand by code snippet](https://github.com/tirthalpatel/Learning-Hibernate/tree/master/src/main/java/com/tirthal/learning/mapping/inheritance)
