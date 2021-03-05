package com.edu.utez.gespro.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Employe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado")
    private long id;

    @Column(name = "nombre")
    private String firstName;
    @Column(name = "apellido")
    private String lastName;
    @Column(name = "fechaN")
    private String birthDate;
    @Column(name = "telefono")
    private String phoneNumber;
    private String curp;
    private String email;
    @Column(name = "domicilio")
    private String adress;
    @Column(name = "gradoestudio")
    private String degree;
    @Column(name = "contrasena")
    private String password;
    @Column(name = "estatus")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "idrol")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "employe")
    private List<Project> project;

    @JsonIgnore
    @OneToMany(mappedBy = "employe")
    private List<AttachedResource> attachedResource;


}
