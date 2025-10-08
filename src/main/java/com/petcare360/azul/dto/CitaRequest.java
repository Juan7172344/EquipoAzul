package com.petcare360.azul.dto;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class CitaRequest {
    @NotBlank
    private String nombreMascota;
    @NotBlank
    private String tipoMascota;
    @Min(0)
    private int edadMascota;
    @NotNull
    private Long veterinarioId;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaHora;
    @NotBlank
    private String motivo;
    @NotBlank
    private String servicioCodigo;

    public CitaRequest() {}


    public String getNombreMascota() { return nombreMascota; }
    public void setNombreMascota(String nombreMascota) { this.nombreMascota = nombreMascota; }
    public String getTipoMascota() { return tipoMascota; }
    public void setTipoMascota(String tipoMascota) { this.tipoMascota = tipoMascota; }
    public int getEdadMascota() { return edadMascota; }
    public void setEdadMascota(int edadMascota) { this.edadMascota = edadMascota; }
    public Long getVeterinarioId() { return veterinarioId; }
    public void setVeterinarioId(Long veterinarioId) { this.veterinarioId = veterinarioId; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getServicioCodigo() { return servicioCodigo; }
    public void setServicioCodigo(String servicioCodigo) { this.servicioCodigo = servicioCodigo; }
}
