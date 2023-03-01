package com.example.SpringHello.models;

/**
 *
 * @author anton
 */
public class AlumnoDTO {
    private String nombre;
    private String apellidos;
    private Integer horas_dual;
    private Integer horas_fct;
    private Integer horas_totales;
    private String empresa;
    private String tutor;

    public Integer getHoras_totales() {
        return horas_totales;
    }

    public void setHoras_totales(Integer horas_totales) {
        this.horas_totales = horas_totales;
    }

    public AlumnoDTO() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getHoras_dual() {
        return horas_dual;
    }

    public void setHoras_dual(Integer horas_dual) {
        this.horas_dual = horas_dual;
    }

    public Integer getHoras_fct() {
        return horas_fct;
    }

    public void setHoras_fct(Integer horas_fct) {
        this.horas_fct = horas_fct;
    }


    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }
   
    
}

