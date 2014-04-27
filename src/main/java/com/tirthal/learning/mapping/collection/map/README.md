Mapping "Map" demo
------------------

* A Map is a java collection that stores elements in key-value pairs and does not allow duplicate elements in the list. 

* A Map is mapped with a <map> element in the mapping table and an unordered map can be initialized with java.util.HashMap.

* If ordering is needed in map, use TreeMap instance in entity class & add sort attribute in map element to specify Comparator class or natural order.


* For example, Employee is having collection of Certificates.

	Two java classes (Employee.java and Certificate.java) will be mapped to two SQL tables (MAP_DEMO_EMPLOYEE, MAP_DEMO_CERTIFICATES).
	
	(1) Java POJO created - Employee.java and Certificate.java.
	
	(2) Configured in "MapDemo.hbm.xml".
	
	(3) Added mapping file "MapDemo.hbm.xml" entry in "hibernate.cfg.xml" file.
	
	(4) Run code of "TestMapDemoApp.java" and explore it.