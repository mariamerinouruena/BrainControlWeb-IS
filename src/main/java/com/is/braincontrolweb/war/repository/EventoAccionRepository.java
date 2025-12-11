package com.is.braincontrolweb.war.repository;

import com.is.braincontrolweb.war.domain.EventoAccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventoAccionRepository extends JpaRepository<EventoAccion, String> {

}
