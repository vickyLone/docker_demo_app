package com.anarghya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.entity.ContactEntity;

public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {

	ContactEntity findByName(String name);

	

	



	ContactEntity findByPhoneNumber(String phoneNumber);

}
