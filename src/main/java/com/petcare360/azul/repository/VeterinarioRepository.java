package com.petcare360.azul.repository;


import com.petcare360.azul.model.Veterinario;
import java.util.Optional;

public interface VeterinarioRepository {
    Optional<Veterinario> findById(Long id);
    Veterinario save(Veterinario v);
}

