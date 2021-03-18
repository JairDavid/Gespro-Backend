package com.edu.utez.gespro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "asignar_adscrito")
//@JsonIdentityInfo(scope = AttachedResource.class, generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class AttachedResource implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignar_adscrito")
    private long id;

    @ManyToOne
    @JoinColumn(name = "idempleado")
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "idproyecto")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "idpuesto")
    private Labor labor;
}
