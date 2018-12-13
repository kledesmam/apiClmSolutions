package com.clmsolution.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clmsolution.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User getUserByUserName(@Param("pLogin") String login);
	
	@Query(value = "exec SP_VALIDATE_USER :pLogin, :pPassword", nativeQuery = true)
	List<Object[]> getUserByLogin(@Param("pLogin") String login, @Param("pPassword") String password);
		
	@Query(value = "exec sp_get_user :pLogin", nativeQuery = true)
	List<Object[]> getUser(@Param("pLogin") String login);
}
