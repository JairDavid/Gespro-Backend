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
@Table(name = "fase_proyecto")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class ProjectPhase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfase_proyecto")
    private long id;

    @Column(name = "porcentaje")
    private int percent;

    @ManyToOne
    @JoinColumn(name = "idproyecto")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "idfase")
    private Phase phase;

    @JsonIgnore
    @OneToMany(mappedBy = "projectPhase")
    private List<DeliverableAssigment> deliverableAssigment;
}
