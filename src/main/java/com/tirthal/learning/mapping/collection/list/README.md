Mapping "List" demo
------------------

* Use when you want to store elements in sequence and allow duplicate elements. 

* A List is mapped with a <list> element in the mapping table and initialized with java.util.ArrayList.

* <list-index> element is used to keep the position of the element and map with the index column in the collection table. The index of the persistent list starts at zero. You could change this, for example, with <list-index base="1" /> in your mapping.


* For example, Employee is having collection of Certificates.

	Two java classes (Employee.java and Certificate.java) will be mapped to two SQL tables (LIST_DEMO_EMPLOYEE, LIST_DEMO_CERTIFICATES).
	
	(1) Java POJO created - Employee.java and Certificate.java.
	
	(2) Configured in "ListDemo.hbm.xml".
	
	(3) Added mapping file "ListDemo.hbm.xml" entry in "hibernate.cfg.xml" file.
	
	(4) Run code of "TestListDemoApp.java" and explore it.