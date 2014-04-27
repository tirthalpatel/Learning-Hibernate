package com.tirthal.learning.mapping.collection.set;

/**
 * Certificate POJO
 * 
 * @author tirthalp
 * 
 */
public class Certificate {

	private int id;
	private String certiName;

	public Certificate() {

	}

	public Certificate(int id, String certiName) {
		this.id = id;
		this.certiName = certiName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCertiName() {
		return certiName;
	}

	public void setCertiName(String certiName) {
		this.certiName = certiName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certiName == null) ? 0 : certiName.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Certificate)) {
			return false;
		}
		Certificate other = (Certificate) obj;
		if (certiName == null) {
			if (other.certiName != null) {
				return false;
			}
		} else if (!certiName.equals(other.certiName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
