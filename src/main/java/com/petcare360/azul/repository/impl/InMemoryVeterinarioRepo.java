package com.petcare360.azul.repository.impl;

import com.petcare360.azul.model.Veterinario;
import com.petcare360.azul.repository.VeterinarioRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryVeterinarioRepo implements VeterinarioRepository {

    private Map<Long, Veterinario> veterinarios = new HashMap<>();

    @Override
    public Veterinario save(Veterinario v) {
        veterinarios.put(v.getId(), v);
        return v;
    }

    @Override
    public Optional<Veterinario> findById(Long id) {
        return Optional.ofNullable(veterinarios.get(id));
    }
}

