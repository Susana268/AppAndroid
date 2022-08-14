package com.sgonzalez.myapprecycletelefonos;

public class DatosVo {
    private String nombreTelefono;
    private String numeroTelefono;
    private Integer imageTelefono;

    public DatosVo() {
    }

    public DatosVo(String nombreTelefono, String numeroTelefono, Integer imageTelefono) {
        this.nombreTelefono = nombreTelefono;
        this.numeroTelefono = numeroTelefono;
        this.imageTelefono = imageTelefono;
    }

    public String getNombreTelefono() {
        return nombreTelefono;
    }

    public void setNombreTelefono(String nombreTelefono) {
        this.nombreTelefono = nombreTelefono;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Integer getImageTelefono() {
        return imageTelefono;
    }

    public void setImageTelefono(Integer imageTelefono) {
        this.imageTelefono = imageTelefono;
    }
}
