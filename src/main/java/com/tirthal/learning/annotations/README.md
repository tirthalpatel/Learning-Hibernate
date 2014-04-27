Hibernate Annotations
----------------------

* Hibernate 3.5 and onward contains Hibernate Annotations - Starting with version 3.5 (currently trunk), Annotations and EntityManager have been merged back into the Hibernate Core codebase as individual modules.

* Run "TestAnnotationsDemoApp.java" and check "COUNTRY" table in database

* Below annotations are used in sample code snippet "Country.java".

	@Entity - declares the class as an entity (i.e. a persistent POJO class)
	
	@Table - is set at the class level; it allows you to define the table, catalog, and schema names for your entity mapping. If no @Table is defined the default values are used: the unqualified class name of the entity.
	
	@Id - declares the identifier property of this entity.
	
	@GeneratedValue - is used to specify the primary key generation strategy to use. If the strategy is not specified by default AUTO will be used.
	
	@Column - is used to specify the details of the column to which a field or property will be mapped. If the @Column annotation is not specified by default the property name will be used as the column name.


List of some of hibernate annotations 
-------------------------------------

	@Entity - Class level annotation that designates class as persistent entity
	
	@Id - Used to define primary key property. Can be applied on primitives, primitive wrapper, String or Date type. Equivalent to <id>.
	
	@Embeddable & @Embedded - Equivalent to <component> in hbm file. Component class is defined as @Embeddable. Owning class need annotate component property by @Embedded.
	
	@OneToOne - Use mappedBy attribute in this annotation to declare the side as inverse i.e. side at other end is treated as owner. cascade options can be specified in attribute.
	
	@ManyToOne - ManyToOne side of association can not be marked with mappedBy.
	
	@OneToMany - Generally used with mappedBy element, which refers to @ManyToOne side property of associated class. If OneToMany side need to be owner of the relationship, separate mapping table should be used to map the relationship.
	
	@ManyToMany - If ManyToMany association is bidirectional, non-owner side can contain mappedBy element. Separate join table is must for many-to0many relationship.
	
	@JoinColumn - Association annotations infer column names based on property names of the associated classes. Default column names for these foreign key columns can be overridden by @JoinColumn table.
	
	@Inheritance - Class level annotation used in root of inheritance hierarchy to define inheritance strategy.
	
	@MappedSuperclass - To define state & mapping information that is common for multiple classes. It is not treated as persistent entity. Mapping information can be overridden in subclasses using @AttributeOverride annotation.
	
	@Table - Class level annotation to specify primary table for annotated entity.
	
	@UniqueConstraint - To specify unique columns in generated DDL.
	
	@GeneratedValue - To specify primary key generation type. 
	
	@Column - To override default column name & specify length, nullability etc for the column. 
	
	@Version - Equivalent to <version> in mapping file.
	
	@Temporal - Used on Date type to specify whether to treate Date as DATE, TIME or TIMESTAMP.
	
	@Enumerated - To map enums. Default is ORDINAL, STRING can also be specified.


Also Refer
----------
[Hibernate Annotations Reference Guide](http://docs.jboss.org/hibernate/stable/annotations/reference/en/html/)