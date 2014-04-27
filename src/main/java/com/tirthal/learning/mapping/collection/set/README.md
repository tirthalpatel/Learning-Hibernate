Mapping "Set" demo
------------------

* Use set when you don’t want to allow duplicates in collection elements & ordering is not required.

* To map collection, we need separate mapping table to hold collection values. 

* Objects to be added to a set must implement both the equals() and hashCode() methods so that Java can determine whether any two elements/objects are identical.

* A Set is mapped with a <set> element in the mapping table and initialized with java.util.HashSet. You can use Set collection in your class when there is no duplicate element required in the collection.

* SortedSet instance can be used in entity class to have ordering.


* For example, Employee is having collection of Certificates.

	Two java classes (Employee.java and Certificate.java) will be mapped to two SQL tables (SET_DEMO_EMPLOYEE, SET_DEMO_CERTIFICATES).
	
	(1) Java POJO created - Employee.java and Certificate.java.
	
	(2) Configured in "SetDemo.hbm.xml".
	
	(3) Added mapping file "SetDemo.hbm.xml" entry in "hibernate.cfg.xml" file.
	
	(4) Run code of "TestSetDemoApp.java" and explore it.