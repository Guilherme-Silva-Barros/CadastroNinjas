package dev.barros.CadatroDeNinjas.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.barros.CadatroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private String dificuldade;
    @OneToMany(mappedBy = "missoes") //uma missão vai ter um grupo de ninjas
    @JsonIgnore
    private List<NinjaModel> ninjas;


}
