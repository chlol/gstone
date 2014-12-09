package com.chlol.gstone.metadata.validator;

import org.springframework.stereotype.Component;

@Component
public interface MetadataValidator {
	public boolean validate(String jsonData);
}
