package com.petcare360.azul.repository.impl;

import com.petcare360.azul.model.Mascota;
import com.petcare360.azul.repository.MascotaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryMascotaRepo implements MascotaRepository {

    private Map<Long, Mascota> mascotas = new HashMap<>();

    @Override
    public Mascota save(Mascota m) {
        mascotas.put(m.getId(), m);
        return m;
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return Optional.ofNullable(mascotas.get(id));
    }
}
