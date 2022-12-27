package com.spring.jdbc.sample.controller;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jdbc.sample.dto.GenericResponse;
import com.spring.jdbc.sample.dto.UserDto;
import com.spring.jdbc.sample.service.UserService;

@RestController
@RequestMapping("/details")
public class UserController {
	@Autowired
	public UserService userService;

	@PostMapping(value = "/create")
	private GenericResponse<UserDto> createUser(@RequestBody UserDto user) throws SQLException {
		userService.save(user);
		GenericResponse<UserDto> response = new GenericResponse<UserDto>();
		response.setData(null);
		response.setDataList(null);
		response.setStatus("SUCCESS");
		response.setMessage("user saved information successfully");

		return response;

	}

	@GetMapping(value = "/get")
	private GenericResponse<UserDto> getAllUsers() throws SQLException { // userService.save(user);
		List<UserDto> users = userService.getAllUsers();
        GenericResponse<UserDto> response = new GenericResponse<UserDto>();
		response.setData(null);
		response.setDataList(users);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  fetched successfully");
		
		return response;

	}
	@PutMapping(value = "/put")
	private GenericResponse<UserDto> updateUser(@RequestBody UserDto user) throws SQLException {
		userService.update(user);
        GenericResponse<UserDto> response = new GenericResponse<UserDto>();
		response.setData(user);
		response.setDataList(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");
		
		return response;
}
	@DeleteMapping(value = "/delete")
	private GenericResponse<UserDto> deleteUser(@RequestBody UserDto user) throws SQLException {
		userService.delete(user);
        GenericResponse<UserDto> response = new GenericResponse<UserDto>();
		response.setData(user);
		response.setDataList(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");
		
		return response;
	}
	@GetMapping(value = "/getby/{id}")
	private GenericResponse<UserDto> getById(@PathVariable Integer id) throws SQLException {
		//userService.delete(user);
		UserDto user=userService.getById(id);
        GenericResponse<UserDto> response = new GenericResponse<UserDto>();
		response.setData(user);
		response.setDataList(null);
		response.setStatus("SUCCESS");
		response.setMessage("user  information  updated successfully");
		return response;
		
	}
	

    }
	
	

