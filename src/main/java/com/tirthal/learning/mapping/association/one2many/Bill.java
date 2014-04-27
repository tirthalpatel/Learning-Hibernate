package com.tirthal.learning.mapping.association.one2many;

import java.util.Collection;

/**
 * Bill POJO
 * 
 * @author tirthalp
 * 
 */
public class Bill {

	private long id;
	private String billRefNo;
	private Collection<BillLineItem> lineItems;

	public Bill() {

	}

	public Bill(String billRefNo) {
		this.billRefNo = billRefNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBillRefNo() {
		return billRefNo;
	}

	public void setBillRefNo(String billRefNo) {
		this.billRefNo = billRefNo;
	}

	public Collection<BillLineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(Collection<BillLineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billRefNo == null) ? 0 : billRefNo.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lineItems == null) ? 0 : lineItems.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (billRefNo == null) {
			if (other.billRefNo != null)
				return false;
		} else if (!billRefNo.equals(other.billRefNo))
			return false;
		if (id != other.id)
			return false;
		if (lineItems == null) {
			if (other.lineItems != null)
				return false;
		} else if (!lineItems.equals(other.lineItems))
			return false;
		return true;
	}

}
