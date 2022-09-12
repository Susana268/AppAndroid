package com.sgonzalez.myappswlocal.basedatossw;

public class ProductoVO {
    private Integer codProducto;
    private String nombreProducto;
    private String marcaProducto;
    private String modeloProducto;
    private String fechaIngresoProducto;
    private Double unidadMedidaProducto;

    public ProductoVO() {
    }

    public ProductoVO(Integer codProducto, String nombreProducto, String marcaProducto, String modeloProducto, String fechaIngresoProducto, Double unidadMedidaProducto) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.marcaProducto = marcaProducto;
        this.modeloProducto = modeloProducto;
        this.fechaIngresoProducto = fechaIngresoProducto;
        this.unidadMedidaProducto = unidadMedidaProducto;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(String modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public String getFechaIngresoProducto() {
        return fechaIngresoProducto;
    }

    public void setFechaIngresoProducto(String fechaIngresoProducto) {
        this.fechaIngresoProducto = fechaIngresoProducto;
    }

    public Double getUnidadMedidaProducto() {
        return unidadMedidaProducto;
    }

    public void setUnidadMedidaProducto(Double unidadMedidaProducto) {
        this.unidadMedidaProducto = unidadMedidaProducto;
    }
}
