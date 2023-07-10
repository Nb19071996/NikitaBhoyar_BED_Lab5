package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeRepository;
import com.gl.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository empRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theempRepository) {
		empRepository = theempRepository;
	}

	@Override
	public List<Employee> findAll() {

		List<Employee> theEmps = empRepository.findAll();
		return theEmps;
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = empRepository.findById(theId);

		Employee theemp = null;

		if (result.isPresent()) {
			theemp = result.get();
		} else {
			// we didn't find the emp
			throw new RuntimeException("Did not find employee id - " + theId);
		}

		return theemp;
	}

	@Override
	public void save(Employee thetheemp) {
		empRepository.save(thetheemp);
	}

	@Override
	public void deleteById(int theId) {
		empRepository.deleteById(theId);
	}

}
