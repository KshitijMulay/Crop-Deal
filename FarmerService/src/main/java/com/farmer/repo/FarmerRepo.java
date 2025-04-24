package com.farmer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmer.model.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer, Integer> {

}
 