package com.clmsolution.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clmsolution.api.model.User;

public interface AccountStatusRepository extends JpaRepository<User, Long>  {
	
	@Query(value = "exec SP_GET_ACCOUNT_STATUS :pCedula", nativeQuery = true)
	List<Object[]> getAccountStatus(@Param("pCedula") String pCedula);
	
}
