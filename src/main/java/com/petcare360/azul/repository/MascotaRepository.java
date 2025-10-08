package com.petcare360.azul.repository;



import com.petcare360.azul.model.Mascota;
import java.util.Optional;

public interface MascotaRepository {
    Mascota save(Mascota m);
    Optional<Mascota> findById(Long id);
}
