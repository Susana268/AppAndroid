package com.sgonzalez.myapprecycleviewvo;

public class DatosVo {
    private String nombreRestaurante;
    private String CalidadRestaurante;
    private Integer imagenRestaurante;

    public DatosVo() {
    }

    public DatosVo(String nombreRestaurante, String calidadRestaurante, Integer imagenRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
        CalidadRestaurante = calidadRestaurante;
        this.imagenRestaurante = imagenRestaurante;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getCalidadRestaurante() {
        return CalidadRestaurante;
    }

    public void setCalidadRestaurante(String calidadRestaurante) {
        CalidadRestaurante = calidadRestaurante;
    }

    public Integer getImagenRestaurante() {
        return imagenRestaurante;
    }

    public void setImagenRestaurante(Integer imagenRestaurante) {
        this.imagenRestaurante = imagenRestaurante;
    }
}
