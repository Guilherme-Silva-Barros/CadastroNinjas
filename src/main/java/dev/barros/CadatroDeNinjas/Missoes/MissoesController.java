package dev.barros.CadatroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MissoesController {

    private MissoesServices services;

    public MissoesController(MissoesServices services) {
        this.services = services;
    }

    //criar missão(C)
    @PostMapping("/criarMissao")
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missoes) {

        return services.criarMissao(missoes);
    }

    //mostrar missao(R)
    @GetMapping("/mostrarMissao")
    public List<MissoesModel> mostrarMissao() {
        return services.listarMissoes();
    }

    //missoes por ID
    @GetMapping("/missoesID/{id}")
    public MissoesModel missoesID(@PathVariable Long id) {
        return services.misssoesId(id);
    }

    //procurar missao(R)
    @GetMapping("/procurarMissao")
    public String procurarMissao() {
        return "Missao Procurado com sucesso";
    }

    //
    //alterar missao(U)
    @PutMapping("/alterarMissao/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel missoesAtualizado) {
        return services.atualizarMissao(id, missoesAtualizado);
    }

    //deletar missao(D)
    @DeleteMapping("/deletarMissao/{id}")
    public void deletarMissao(@PathVariable Long id) {
        services.deletarMissao(id);
    }
}
