package com.clmsolution.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clmsolution.api.model.User;
import com.clmsolution.api.model.pojo.LoginUserData;
import com.clmsolution.api.model.pojo.UserRequest;
import com.clmsolution.api.model.pojo.LoginRequest;
import com.clmsolution.api.model.pojo.LoginResponse;
import com.clmsolution.api.model.pojo.ValidateUserData;
import com.clmsolution.api.model.pojo.ValidateUserResponse;
import com.clmsolution.api.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository _userRepository;
	
	@PostMapping("/validateUser")
	public ValidateUserResponse validateUser(@RequestBody UserRequest request){
		ValidateUserResponse response = new ValidateUserResponse();
		ValidateUserData userData = new ValidateUserData();
		try {
			if(request == null) throw new Exception("");
			
			User user = _userRepository.getUserByUserName(request.getUsername());
			if(user == null) throw new Exception("");
			
			userData.setExist(true);
			userData.setNew_pass(false);
			response.setStatus(200);
			response.setData(userData);
		}
		catch(Exception e){
			userData.setExist(false);
			userData.setNew_pass(false);
			response.setStatus(200);
			response.setData(userData);
		}
		return response;
	}
	
	@PostMapping("/authenticate")
	public LoginResponse validateLogin(@RequestBody LoginRequest request) {
		LoginResponse loginResponse = new LoginResponse();
		LoginUserData userData = new LoginUserData();
		try {
			if(request == null) throw new Exception("");
			
			List<Object[]> objUser = _userRepository.getUserByLogin(request.getUsername(), request.getPassword());
			if(objUser == null || objUser.size() <= 0) throw new Exception("");
			
			for(Object[] ob: objUser) {
				userData.setName(ob[0] + "");
				userData.setBirthday(ob[1] + "");
				userData.setEmail(ob[2] + "");
				userData.setGender(ob[3] + "");
				userData.setCell_phone(ob[4] + "");
				loginResponse.setStatus(200);
				loginResponse.setData(userData);
			}
		}
		catch(Exception e){
			loginResponse.setStatus(401);
			loginResponse.setMessage("Usuario o contraseña incorrectos");
		}
		return loginResponse;
	}
}
