package com.cognizant.customerservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.cognizant.customerservice.entities.Individual;
import com.cognizant.customerservice.exceptions.CustomerNotFoundException;
import com.cognizant.customerservice.repositories.IndividualRepository;
@Service
public class IndividualServiceImpl  implements IndividualService {
	@Autowired
	private IndividualRepository individualRepository;

	@Override
	public Individual addIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return individualRepository.save(individual);
	}

	@Override
	public Individual getIndividualById(Long id) {
		// TODO Auto-generated method stub
		return individualRepository.findById(id).orElseThrow(
				()->new CustomerNotFoundException("Individual with id "+id+" not found"));
	}

	@Override
	public List<Individual> getAllIndividuals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Individual updateIndividual(Long id, String email, long phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteIndividual(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Individual> getAllIndividualsByPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
