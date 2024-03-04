package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.common.ResponseCode;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	UsersRepository userRepo;

	public LoginResponse validateUser(LoginRequest loginRequest) {

		LoginResponse response = new LoginResponse();

		List<Users> liUser = userRepo.findByUsernameAndPassword(
				loginRequest.getUsername(), 
				loginRequest.getPassword()
				);
		
		if(liUser.size()==1)
		{
			response.setStatus(ResponseCode.LOGIN_SUCCESS.getStatus());
			response.setMessage(ResponseCode.LOGIN_SUCCESS.getMessage());
		}else {
			response.setStatus(ResponseCode.LOGIN_FAIL.getStatus());
			response.setMessage(ResponseCode.LOGIN_FAIL.getMessage());
		}
		return response;
	}

}
