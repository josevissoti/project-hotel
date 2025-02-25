package com.project.repositories;

import com.project.domains.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepositories extends JpaRepository<Reserva, Long> {

}
