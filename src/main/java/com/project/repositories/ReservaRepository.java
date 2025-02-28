package com.project.repositories;

import com.project.domains.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Optional<Reserva> findByCodigoBarras(String codigoBarras);

}
