package com.petcare360.azul.repository.impl;


import com.petcare360.azul.model.Cita;
import com.petcare360.azul.repository.CitaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryCitaRepository implements CitaRepository {

    private final Map<Long, Cita> store = new ConcurrentHashMap<>();
    private final AtomicLong seq = new AtomicLong(1);

    @Override
    public Cita save(Cita cita) {
        if (cita.getId() == null) {
            cita.setId(seq.getAndIncrement());
        }
        store.put(cita.getId(), cita);
        return cita;
    }

    @Override
    public Optional<Cita> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }

    @Override
    public List<Cita> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Cita> findByVeterinarioId(Long veterinarioId) {
        return store.values().stream()
                .filter(c -> c.getVeterinario() != null && veterinarioId.equals(c.getVeterinario().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cita> findByMascotaId(Long mascotaId) {
        return store.values().stream()
                .filter(c -> c.getMascota() != null && mascotaId.equals(c.getMascota().getId()))
                .collect(Collectors.toList());
    }
}

