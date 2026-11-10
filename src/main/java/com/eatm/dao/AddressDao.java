package com.eatm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Address;

@Repository
public class AddressDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public void saveAddress(Address address) {
		entityManager.persist(address);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void updateAddress(Address address) {
		entityManager.merge(address);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public void deleteAddress(Address address) {
		entityManager.remove(address);
		entityTransaction.begin();
		entityTransaction.commit();
	}

	public Address findAddressById(int addressId) {
		return entityManager.find(Address.class, addressId);
	}

	public List<Address> findAllAddress() {
		return entityManager.createQuery("SELECT address FROM Address address").getResultList();
	}
	
}
