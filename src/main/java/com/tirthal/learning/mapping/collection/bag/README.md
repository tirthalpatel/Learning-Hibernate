Mapping "Bag/Collection" demo
-----------------------------

* A Bag is a java collection that stores elements without caring about the sequencing but allow duplicate elements in the list. 

* A bag is a random grouping of the objects in the list.

* A Collection is mapped with a <bag> / <idbag> element in the mapping table and initialized with java.util.ArrayList. 

* <bag> - will allow duplicate, <idbag> - will not allow duplicate


* For example, Employee is having collection of Certificates.

	Two java classes (Employee.java and Certificate.java) will be mapped to two SQL tables (BAG_DEMO_EMPLOYEE, BAG_DEMO_CERTIFICATES).
	
	(1) Java POJO created - Employee.java and Certificate.java.
	
	(2) Configured in "BagDemo.hbm.xml".
	
	(3) Added mapping file "BagDemo.hbm.xml" entry in "hibernate.cfg.xml" file.
	
	(4) Run code of "TestBagDemoApp.java" and explore it.