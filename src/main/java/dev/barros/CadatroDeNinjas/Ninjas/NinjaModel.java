package dev.barros.CadatroDeNinjas.Ninjas;

import dev.barros.CadatroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "rank")
    private String rank;

    @Column(name="idade")
    private int idade;

    @ManyToOne //um ninja vai ter somente uma missão
    @JoinColumn(name ="missoes_id") //chave estrangeira
    private MissoesModel missoes;

}

