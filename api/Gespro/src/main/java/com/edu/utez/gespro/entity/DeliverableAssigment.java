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
@Table(name = "asignacion_entregables")
//@JsonIdentityInfo(scope = DeliverableAssigment.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class DeliverableAssigment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idasignacion_entregables")
    private long id;

    @Column(name = "porcentaje")
    private int percent;

    @ManyToOne
    @JoinColumn(name = "idfase_proyecto")
    private TypePhase typePhase;

    @ManyToOne
    @JoinColumn(name = "identregable")
    private Deliverable deliverable;

    @JsonIgnore
    @OneToMany(mappedBy = "deliverableAssigment")
    private List<Progress> progress;
}
