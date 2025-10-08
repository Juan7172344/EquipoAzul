package com.petcare360.azul.controller;

import com.petcare360.azul.dto.CitaRequest;
import com.petcare360.azul.dto.CitaResponse;
import com.petcare360.azul.model.Mascota;
import com.petcare360.azul.model.Servicio;
import com.petcare360.azul.model.Veterinario;
import com.petcare360.azul.service.AppointmentService;
import com.petcare360.azul.repository.MascotaRepository;
import com.petcare360.azul.repository.VeterinarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class CitaController {

    private final AppointmentService appointmentService;
    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    public CitaController(AppointmentService appointmentService,
                          MascotaRepository mascotaRepository,
                          VeterinarioRepository veterinarioRepository) {
        this.appointmentService = appointmentService;
        this.mascotaRepository = mascotaRepository;
        this.veterinarioRepository = veterinarioRepository;
    }

    @PostMapping("/citas")
    public ResponseEntity<CitaResponse> agendar(@Valid @RequestBody CitaRequest req) {
        // Si la mascota existe en el repo (por id) podrías reusarla; aquí creamos y guardamos en repo de mascotas.
        Mascota mascota = new Mascota();
        mascota.setNombre(req.getNombreMascota());
        mascota.setTipo(req.getTipoMascota());
        mascota.setEdad(req.getEdadMascota());
        mascota = mascotaRepository.save(mascota);

        Veterinario vet = veterinarioRepository.findById(req.getVeterinarioId())
                .orElseThrow(() -> new IllegalArgumentException("Veterinario no encontrado"));

        Servicio servicio = new Servicio(req.getServicioCodigo(), "Servicio " + req.getServicioCodigo());

        var cita = appointmentService.agendar(mascota, vet, servicio, req.getFechaHora(), req.getMotivo());

        CitaResponse resp = new CitaResponse(
                cita.getId(),
                cita.getMascota().getNombre(),
                cita.getVeterinario().getId(),
                cita.getVeterinario().getNombre(),
                cita.getServicio().getCodigo(),
                cita.getServicio().getDescripcion(),
                cita.getFechaHora(),
                cita.getMotivo()
        );

        return ResponseEntity.status(201).body(resp);
    }

    @GetMapping("/citas/{id}")
    public ResponseEntity<CitaResponse> obtener(@PathVariable Long id) {
        return appointmentService.obtener(id)
                .map(c -> new CitaResponse(
                        c.getId(),
                        c.getMascota().getNombre(),
                        c.getVeterinario().getId(),
                        c.getVeterinario().getNombre(),
                        c.getServicio().getCodigo(),
                        c.getServicio().getDescripcion(),
                        c.getFechaHora(),
                        c.getMotivo()
                ))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/citas/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        appointmentService.cancelar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/veterinarios/{id}/citas")
    public ResponseEntity<List<CitaResponse>> listarPorVeterinario(@PathVariable Long id) {
        List<CitaResponse> lista = appointmentService.listarPorVeterinario(id).stream()
                .map(c -> new CitaResponse(
                        c.getId(),
                        c.getMascota().getNombre(),
                        c.getVeterinario().getId(),
                        c.getVeterinario().getNombre(),
                        c.getServicio().getCodigo(),
                        c.getServicio().getDescripcion(),
                        c.getFechaHora(),
                        c.getMotivo()
                )).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/mascotas/{id}/citas")
    public ResponseEntity<List<CitaResponse>> listarPorMascota(@PathVariable Long id) {
        List<CitaResponse> lista = appointmentService.listarPorMascota(id).stream()
                .map(c -> new CitaResponse(
                        c.getId(),
                        c.getMascota().getNombre(),
                        c.getVeterinario().getId(),
                        c.getVeterinario().getNombre(),
                        c.getServicio().getCodigo(),
                        c.getServicio().getDescripcion(),
                        c.getFechaHora(),
                        c.getMotivo()
                )).collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
