package com.edu.utez.gespro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tipo")
public class Type implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo")
    private long id;

    @Column(name = "nombre")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Project> project;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<TypePhase> typePhase;

}
