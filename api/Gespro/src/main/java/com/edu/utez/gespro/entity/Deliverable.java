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
@Table(name = "entregable")
//@JsonIdentityInfo(scope = Deliverable.class,generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Deliverable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identregable")
    private long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "archivo", columnDefinition = "LONGVARBINARY")
    private byte[] file;

    @JsonIgnore
    @OneToMany(mappedBy = "deliverable")
    private List<DeliverableAssigment> deliverableAssigment;
}
