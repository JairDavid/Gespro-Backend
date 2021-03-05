package com.edu.utez.gespro.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "proyecto")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproyecto")
    private long id;


    @Column(name = "nombre")
    private String name;
    @Column(name = "duracion")
    private int duration;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "nombrecliente")
    private String clientName;
    @Column(name = "fecha")
    private String date;
    @Column(name = "costo")
    private double cost;

    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "idtipo")
    private Type type;

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private List<AttachedResource> attachedResource;

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private List<ProjectPhase> projectPhase;

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private List<Progress> progress;


}
