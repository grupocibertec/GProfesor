/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.cibertec.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ldiezcan
 */
@Entity
@Table(name="profesor")
public class Profesor implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="prof_id")
    private Integer idProfesor;
    
    @Column(name="prof_nombre",length=50 )
    private String nombre;
    
    @Column(name="prof_apePaterno",length=50)
    private String apPaterno;
    
    @Column(name="prof_apeMaterno",length=50)
    private String apMaterno;
    
    @Temporal(TemporalType.DATE)
    @Column(name="prof_fechaNacimiento")
    private Date fcNacimiento;
    
    @Column(name="prof_genero",length=1,columnDefinition="M=Masculino, F=Femenino.")
    private Character genero;
    
    @Column(name="prof_dni",length=8)
    private String dni;
    
    @Column(name="prof_email",nullable=true,length=50)
    private String email;
    
    @Column(name="prof_direccion",nullable=true,length=50)
    private String direccion;
    
    @Column(name="prof_modalidad",length=1, columnDefinition="T=Titular, A=Agregado, H=Ayudante, I=Interno.")
    private Character modalidad;
    
    @Column(name="prof_nivelAcademico", length=1, columnDefinition="T=Técnico, S=Superior, M=Master")
    private Character nivel;
    
    @Column(name="prof_estado", length=1, columnDefinition="A=Activo, I=Inactivo, C=Capacitación, V=Vacaciones.")
    private Character estado;
    
    @Temporal(TemporalType.DATE)
    @Column(name="prof_fechaIngreso")
    private Date fcIngreso;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="prof_fechaRegistro",insertable=true)
    private Date fcRegistro;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="prof_fechaActualizacion", insertable=false, nullable=true)
    private Date fcActualizacion;

    
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFcNacimiento() {
        return fcNacimiento;
    }

    public void setFcNacimiento(Date fcNacimiento) {
        this.fcNacimiento = fcNacimiento;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Character getModalidad() {
        return modalidad;
    }

    public void setModalidad(Character modalidad) {
        this.modalidad = modalidad;
    }

    public Character getNivel() {
        return nivel;
    }

    public void setNivel(Character nivel) {
        this.nivel = nivel;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFcIngreso() {
        return fcIngreso;
    }

    public void setFcIngreso(Date fcIngreso) {
        this.fcIngreso = fcIngreso;
    }

    public Date getFcRegistro() {
        return fcRegistro;
    }

    public void setFcRegistro(Date fcRegistro) {
        this.fcRegistro = fcRegistro;
    }

    public Date getFcActualizacion() {
        return fcActualizacion;
    }

    public void setFcActualizacion(Date fcActualizacion) {
        this.fcActualizacion = fcActualizacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.idProfesor != null ? this.idProfesor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (this.idProfesor != other.idProfesor && (this.idProfesor == null || !this.idProfesor.equals(other.idProfesor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", nombre=" + nombre + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", fcNacimiento=" + fcNacimiento + ", genero=" + genero + ", dni=" + dni + ", email=" + email + ", direccion=" + direccion + ", modalidad=" + modalidad + ", nivel=" + nivel + ", estado=" + estado + ", fcIngreso=" + fcIngreso + ", fcRegistro=" + fcRegistro + ", fcActualizacion=" + fcActualizacion + '}';
    }
    
    
}
