package com.sgonzalez.myappfragmentcine;

public class DatosVo {
    private Integer imagen;
    private Integer nombre;
    private Integer duracion;
    private Integer sinopsis;
    private Integer director;
    private Integer puntuacion;
    private Integer precio;


    public DatosVo(){

    }

    public DatosVo(Integer imagen, Integer nombre, Integer duracion, Integer sinopsis, Integer director, Integer puntuacion,Integer precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.director = director;
        this.puntuacion = puntuacion;
        this.precio = precio;
    }

    public DatosVo(Integer imagen, Integer nombre, Integer duracion,Integer precio) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.duracion = duracion;
        this.precio = precio;
    }

    public DatosVo(Integer sinopsis,Integer director, Integer puntuacion) {
        this.sinopsis = sinopsis;
        this.director = director;
        this.puntuacion = puntuacion;

    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(Integer sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getDirector() {
        return director;
    }

    public void setDirector(Integer director) {
        this.director = director;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
