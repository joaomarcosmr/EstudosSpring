package dev.java10x.projetoapi.Ninjas;

import dev.java10x.projetoapi.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rank;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private int idade;

    @ManyToOne
    @JoinColumn(name = "missoes_id") // foreign key
    private MissoesModel missoes;
}
