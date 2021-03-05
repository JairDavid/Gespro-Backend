package com.edu.utez.gespro.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "avance")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Progress implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idavance")
    private long id;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "archivo",columnDefinition = "LONGVARBINARY")
    private byte[] file;

    @Column(name = "terminado")
    private boolean finish;

    @ManyToOne
    @JoinColumn(name = "idproyecto")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "idasignacion_entregables")
    private DeliverableAssigment deliverableAssigment;
}
