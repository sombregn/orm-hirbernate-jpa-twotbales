package sn.dev.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "etudiant_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "matricule",unique = true, length = 200 ,nullable = false)
    private String matricule;
    @Column(name = "nom", length = 200)
    private String nom;
    @Column(name = "prenom", length = 200)
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    //scpefication dun nom de cle etrangere
    @JoinColumn(name = "classe")
    private Classe classe ;
}
