package com.petcare360.azul.model;

import java.time.LocalDateTime;

public class Cita {
    private Long id;
    private Mascota mascota;
    private Veterinario veterinario;
    private Servicio servicio;
    private LocalDateTime fechaHora;
    private String motivo;

    public Cita() {}

    public Cita(Long id, Mascota mascota, Veterinario veterinario, Servicio servicio, LocalDateTime fechaHora, String motivo) {
        this.id = id;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.servicio = servicio;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }
    public Veterinario getVeterinario() { return veterinario; }
    public void setVeterinario(Veterinario veterinario) { this.veterinario = veterinario; }
    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}

