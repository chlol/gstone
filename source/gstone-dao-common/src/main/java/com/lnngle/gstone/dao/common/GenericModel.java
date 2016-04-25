package com.lnngle.gstone.dao.common;

import java.io.Serializable;

public interface GenericModel<PK extends Serializable> extends Serializable {
	PK getId();
	
	void setId(PK pk);
}
