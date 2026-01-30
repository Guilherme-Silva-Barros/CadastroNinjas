package dev.barros.CadatroDeNinjas.Ninjas;

import dev.barros.CadatroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    private int idade;
    @ManyToOne //um ninja vai ter somente uma missão
    @JoinColumn(name ="missoes_id") //chave estrangeira
    private MissoesModel missoes;

}

