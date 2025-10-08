package com.petcare360.azul.service.impl;



import com.petcare360.azul.model.Cita;
import com.petcare360.azul.model.Mascota;
import com.petcare360.azul.model.Servicio;
import com.petcare360.azul.model.Veterinario;
import com.petcare360.azul.repository.CitaRepository;
import com.petcare360.azul.service.AppointmentService;
import com.petcare360.azul.service.AppointmentValidationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final CitaRepository citaRepository;
    private final AppointmentValidationService validationService;

    public AppointmentServiceImpl(CitaRepository citaRepository, AppointmentValidationService validationService) {
        this.citaRepository = citaRepository;
        this.validationService = validationService;
    }

    @Override
    public Cita agendar(Mascota mascota, Veterinario veterinario, Servicio servicio, LocalDateTime fechaHora, String motivo) {
        validationService.validarNoDuplicidadVeterinario(veterinario.getId(), fechaHora);
        Cita cita = new Cita();
        cita.setMascota(mascota);
        cita.setVeterinario(veterinario);
        cita.setServicio(servicio);
        cita.setFechaHora(fechaHora);
        cita.setMotivo(motivo);
        return citaRepository.save(cita);
    }

    @Override
    public Optional<Cita> obtener(Long id) {
        return citaRepository.findById(id);
    }

    @Override
    public void cancelar(Long id) {
        citaRepository.deleteById(id);
    }

    @Override
    public List<Cita> listarPorVeterinario(Long vetId) {
        return citaRepository.findByVeterinarioId(vetId);
    }

    @Override
    public List<Cita> listarPorMascota(Long mascotaId) {
        return citaRepository.findByMascotaId(mascotaId);
    }
}
