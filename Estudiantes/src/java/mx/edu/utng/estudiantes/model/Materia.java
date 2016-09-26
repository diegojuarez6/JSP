/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.estudiantes.model;

/**
 *
 * @author Diego
 */
public class Materia {
   private int idMateria;
   private String descripcion;
   private String fechaInicio;
   private String fechaFin;
   private int totalHoras;

   public Materia() {
        this(0,"","","",0);
    }
    
    public Materia(int idMateria, String descripcion, String fechaInicio, String fechaFin, int totalHoras) {
        this.idMateria = idMateria;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalHoras = totalHoras;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", totalHoras=" + totalHoras + '}';
    }
}
