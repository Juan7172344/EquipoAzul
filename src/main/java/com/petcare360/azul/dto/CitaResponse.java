package com.petcare360.azul.dto;

import java.time.LocalDateTime;

public class CitaResponse {
    private Long id;
    private String nombreMascota;
    private Long veterinarioId;
    private String veterinarioNombre;
    private String servicioCodigo;
    private String servicioDescripcion;
    private LocalDateTime fechaHora;
    private String motivo;


    public CitaResponse(Long id, String nombreMascota, Long veterinarioId, String veterinarioNombre,
                        String servicioCodigo, String servicioDescripcion, LocalDateTime fechaHora, String motivo) {
        this.id = id;
        this.nombreMascota = nombreMascota;
        this.veterinarioId = veterinarioId;
        this.veterinarioNombre = veterinarioNombre;
        this.servicioCodigo = servicioCodigo;
        this.servicioDescripcion = servicioDescripcion;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }
    public Long getVeterinarioId() { return veterinarioId; }
    public void setVeterinarioId(Long veterinarioId) { this.veterinarioId = veterinarioId; }
    public String getVeterinarioNombre() { return veterinarioNombre; }
    public void setVeterinarioNombre(String veterinarioNombre) { this.veterinarioNombre = veterinarioNombre; }
    public String getServicioCodigo() { return servicioCodigo; }
    public void setServicioCodigo(String servicioCodigo) { this.servicioCodigo = servicioCodigo; }
    public String getServicioDescripcion() { return servicioDescripcion; }
    public void setServicioDescripcion(String servicioDescripcion) { this.servicioDescripcion = servicioDescripcion; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
}
