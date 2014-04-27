Mapping Inheritance
=====================
* Object oriented systems model both “is-a” and “has-a” relationships, when relational model supports “has-a” relationships only.

* For example, In Java - Book (title, author, bookType) and Laptop (brand, modelNo, processorType) are sub-classes of Item (id, itemCode, itemName) class.   

* There are three ways to map object inheritance model - (1) Table per concrete class (2) Table per class hierarchy (3) Table per subclass.


Table per concrete class
-------------------------
* Discard polymorphism and inheritance relationship completely from the relational model.

* Tables are created for lowest level classes of class hierarchy. 

* In our example three tables will be created - Item(id, itemCode, itemName), Book (id, itemCode, itemName, title, author, bookType) & Laptop (id, itemCode, itemName, brand, modelNo, processorType)

* What are key points?
	- Poor support for polymorphic queries
	- Need SQL UNION or separate select queries retrieve superclass objects
	- Very efficient in CRUD operations when the instance on which we are operating is known
	- Use <union-subclass> to map using this approach


Table per class hierarchy
-------------------------
* Enable polymorphism by de-normalizing relational model and adding type (discriminator) column to know the particular instance.

* One table is created for complete inheritance hierarchy.

* In our example one table will be created - Item (id, it_code, it_name, it_type, title, author, brand, model_no, etc...). Here "it_type" value can be Book / Laptop.

* What are key points?
	- Fastest in all inheritance models because no joins are required
	- Save or update requires single insert/update query
	- Larger and deep inheritance hierarchy will result in table with many & mainly empty columns
	- Use <subclass> to map using this approach


Table per subclass
------------------
* Represent “is-a” (inheritance) relationship as “has-a” (foreign key) relationship.

* Root of hierarchy is represented by a single table new table is created for each subclass, which contains only those fields which are declared by that subclass.

* In our example three tables will be created - Item (id, itemCode, itemName), Book (id, title, author, bookType), Laptop (id, brand, modelNo, processorType). Here "id" is primary key of Item table, and foreign key in Book and Laptop tables. 

* What are key points?
	- Primary key of subclass table serves as foreign key to primary key of superclass table
	- Supports polymorphic queries
	- Requires one or more JOINs to be performed to instantiate instances of subclasses
	- Requires insert/update queries to be fired in multiple tables
	- Use <joined-subclass> to map using this approach
