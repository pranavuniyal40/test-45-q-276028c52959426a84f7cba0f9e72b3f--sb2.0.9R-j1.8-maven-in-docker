package org.codejudge.sb.Dao;


import org.codejudge.sb.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LeadRepository  extends JpaRepository<Lead,Integer>{

}
