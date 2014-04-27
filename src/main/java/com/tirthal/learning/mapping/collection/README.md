Collections Mappings
--------------------

* If an entity or class has collection of values for a particular variable, then we can map those values using any one of the collection interfaces available in java. 

* Hibernate can persist instances of java.util.Map, java.util.Set, java.util.SortedMap, java.util.SortedSet, java.util.List, and any array of persistent entities or values.

* Collection type	Mapping 	--- 	Description

	- java.util.Set				---		This is mapped with a <set> element and initialized with java.util.HashSet.
	- java.util.SortedSet			---		This is mapped with a <set> element and initialized with java.util.TreeSet. The sort attribute can be set to either a comparator or natural ordering.
	- java.util.List				---		This is mapped with a <list> element and initialized with java.util.ArrayList.
	- java.util.Collection		---		This is mapped with a <bag> or <ibag> element and initialized with java.util.ArrayList.
	- java.util.Map				---		This is mapped with a <map> element and initialized with java.util.HashMap.
	- java.util.SortedMap			---		This is mapped with a <map> element and initialized with java.util.TreeMap. The sort attribute can be set to either a comparator or natural ordering.

* Arrays are supported by Hibernate with <primitive-array> for Java primitive value types and <array> for everything else. 

* If you want to map a user defined collection interfaces which is not directly supported by Hibernate, you need to tell Hibernate about the semantics of your custom collections which is not very easy and not recommend to be used.