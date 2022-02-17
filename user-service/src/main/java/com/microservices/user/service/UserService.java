package com.microservices.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.VO.Department;
import com.microservices.user.VO.ResponseTemplateVO;
import com.microservices.user.entity.User;
import com.microservices.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inseid Save User Service: " + user);
		return userRepository.save(user);
	}

	public ResponseTemplateVO findUserWithDepartment(Long userId) {
		log.info("Inseid Find User Service: " + userId);
		User user = userRepository.findUserByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(),
				Department.class);
		return new ResponseTemplateVO(user, department);
	}

}
