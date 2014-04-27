Mapping many-to-many Association
------------------------------

* Declare member variable of Collection<AssociatedType> type in the class. 

* Many-to-many relationship requires separate join table.

* Add mapping for many-to-many in owner side’s hbm file.

* For many-to-many and one-to-many associations, lazy loading is enabled by default. Actual query will be fired only when properties of specific object is accessed.

* Many to many relationship can be unidirectional or bidirectional, any of the side can be marked as inverse (non-owner).


* For example, consider the many-to-many relationship between Student and Course entity. That means that, a student can enroll in any number of courses and the course can have any number of students.
To create this relationship, need to have a STUDENT, COURSE and STUDENT_COURSE table. 
