package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.AuthorizationRequest;
import org.dnyanyog.dto.AuthorizationResponse;

public interface AuthorizationService {
	
	AuthorizationResponse authorize(AuthorizationRequest request) ;
	
	List<AuthorizationResponse> gettAllAuthrs();
		
	

}
