package com.microservicios.app.futfem.referees.models.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservicios.app.futfem.referees.models.entity.Referee;

public interface RefereeRepository extends JpaRepository<Referee, Long> {

	@Query("""
			select r from Referee r
			where (:search is null
					or lower(coalesce(r.name, '')) like lower(concat('%', :search, '%'))
					or lower(coalesce(r.surname, '')) like lower(concat('%', :search, '%')))
			  and (:country is null or upper(coalesce(r.country, '')) = upper(:country))
			""")
	Page<Referee> searchReferees(@Param("search") String search, @Param("country") String country, Pageable pageable);
}
