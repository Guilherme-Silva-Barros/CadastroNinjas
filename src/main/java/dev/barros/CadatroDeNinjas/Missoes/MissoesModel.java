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
public class MissoesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    @OneToMany(mappedBy = "missoes") //uma missão vai ter um grupo de ninjas
    @JsonIgnore
    private List<NinjaModel> ninjas;

    public MissoesModel(Long id) {
        this.id = id;
    }

    public MissoesModel(Long id, String nome, String dificuldade) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }

}
