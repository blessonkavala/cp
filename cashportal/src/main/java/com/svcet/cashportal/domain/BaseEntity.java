package com.svcet.cashportal.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orientechnologies.orient.core.annotation.OId;
import com.orientechnologies.orient.core.annotation.OVersion;

/**
 * Base entity for OrientDB Hornbill data transfer object Contains id and
 * version
 * 
 * @author gekaczur
 *
 */
@JsonIgnoreProperties("handler")
public abstract class BaseEntity {

	@OVersion
	private Long version;

	@OId
	private String rid;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rid == null) ? 0 : rid.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		BaseEntity other = (BaseEntity) obj;
		if (rid == null) {
			if (other.rid != null)
				return false;
		} else if (!rid.equals(other.rid))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}