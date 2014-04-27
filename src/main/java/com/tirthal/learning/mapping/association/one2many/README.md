Mapping one-to-many Association
------------------------------

* A One-to-Many mapping can be implemented using a collection. Declare member variable of Collection<AssociatedType> type in the class.

* One-to-many association can be mapped in two ways,
(i) As an “inverse” of one-to-many association (bidirectional by foreign key)
(ii) As many-to-many association, but marking associated entity as unique (can be unidirectional or bidirectional, requires join table)

* For example, consider one-to-many relationship between Bill and BillLineItem - that means one bill can have many bill line items, but each bill line item can belong to one bill. 
