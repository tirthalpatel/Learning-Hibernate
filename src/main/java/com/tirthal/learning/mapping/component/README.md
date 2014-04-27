Component mapping demo
----------------------

* Composition relationship in java that have a value type are called components.

* Used when you need to store child object details in the owner entity’s table.

* A Component mapping is a mapping for a class having a reference to another class as a member variable. A single table would be used to keep the attributes contained inside the class variable.

* Use <component> element in the hibernate mapping file.


* For example - Employee has an Address. 

	Two java classes (Employee.java and Address.java) will be mapped to single SQL table (EMPLOYEE_ADDRESS). 
	
	(1) Java POJO created - Employee.java and Address.java
	
	(2) Configured in "ComponentDemo.hbm.xml". Here Address (component) is not considered as an entity. 
	
	(3) Added mapping file "ComponentDemo.hbm.xml" entry in "hibernate.cfg.xml" file.
	
	(4) Run code of "TestComponentDemoApp.java" and explore it.