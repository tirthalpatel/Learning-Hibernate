Options in Hibernate to query database?
---------------------------------------

* Hibernate Query Language (HQL) 

	- It is same as SQL (Structured Query Language) but it doesn't depends on the table of the database. 
	- Instead of table name, we use class name in HQL. So it is database independent query language.
	- For example,
	
			Query query = session.createQuery("from User");		// Here User is java class name
			List<User> users = (List<User>) query.list();
			for(User user : users)
			{
				System.out.println(user.getName());
			}


* Hibernate Criteria Query Language (HCQL) / Criteria API

	- The Hibernate Criteria Query Language (HCQL) is much more object oriented approach to query hibernate and it used to fetch the records based on the specific criteria. 
	- The Criteria interface provides methods to apply criteria such as retrieving all the records of table whose salary is greater than 50000 etc.
	- For example,		
					
			List<User> users = (List<User>) session.createCriteria(User.class).list();			
			for(User user : users)
			{
				System.out.println(user.getName());
			}
			// Get user with "Tirthal" name
			User user = (User) session.createCriteria(User.class).add(Restrictions.eq("name", "Tirthal")).uniqueResult();
			System.out.println(user.getName());
			
			
* Native SQL

	- You can use native SQL to express database queries if you want to utilize database-specific features such as query hints or the CONNECT keyword in Oracle. 
	- Hibernate 3.x allows you to specify handwritten SQL, including stored procedures, for all create, update, delete, and load operations. 
	- Not recommended approach to use native SQL, but sometimes it is easiest to use raw SQL in legacy code.
	- For example,
	
			List<User> users = (List<User>) session.createSQLQuery("SELECT * FROM User").addEntity(User.class).list();
			List<User> users = (List<User>) query.list();
			for(User user : users)
			{
				System.out.println(user.getName());
			}