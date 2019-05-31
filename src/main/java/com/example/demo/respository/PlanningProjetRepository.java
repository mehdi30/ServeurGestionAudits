package com.example.demo.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.PlanningProjet;
import com.example.demo.entity.PlanningProjetPk;
import com.example.demo.util.EtatPlanningEnum;

public interface PlanningProjetRepository extends JpaRepository<PlanningProjet, Long>{

	@Query("SELECT p FROM PlanningProjet p ORDER BY p.start ASC")
	List<PlanningProjet> findAllOrderBydate();
	
	/*@Query("SELECT p FROM PlanningProjet p WHERE p.etat = 'TRUE'")
	List<PlanningProjet> findAllRealise();*/
	

	PlanningProjet findByNumPlanning(Long numPlanning);
	
	@Query("SELECT COUNT(p) FROM PlanningProjet p  WHERE EXTRACT(YEAR FROM p.start) = YEAR(CURRENT_DATE) GROUP BY EXTRACT(MONTH FROM p.start)")
	List<PlanningProjet> countByMonths();
	
	/*@Query(value = "SELECT COUNT(p), to_char(to_timestamp (date_part('month',(p.start1))::text, 'MM'), 'Month') FROM Planning_Projet p  WHERE EXTRACT(YEAR FROM p.start1) = 2019 GROUP BY EXTRACT(MONTH FROM p.start1)",
			nativeQuery=true)
	List<PlanningProjet> countByMonths();*/
	

    @Query("Select count(c) from PlanningProjet c where c.etatPlanning=:e")
    long countPlanningByEtat(@Param("e") EtatPlanningEnum e);
    
}
