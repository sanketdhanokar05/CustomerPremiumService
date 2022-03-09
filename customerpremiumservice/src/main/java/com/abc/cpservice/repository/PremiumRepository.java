package com.abc.cpservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.cpservice.entity.Premium;
@Repository
public interface PremiumRepository extends JpaRepository<Premium,Integer> {

}
