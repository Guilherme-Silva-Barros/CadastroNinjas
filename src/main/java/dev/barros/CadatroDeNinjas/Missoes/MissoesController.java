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
    public List<MissoesDTO> mostrarMissao() {
        return services.listarMissoes();
    }

    //missoes por ID
    @GetMapping("/missoesID/{id}")
    public MissoesDTO missoesID(@PathVariable Long id) {
        return services.misssoesId(id);
    }

    //alterar missao(U)
    @PutMapping("/alterarMissao/{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizado) {
        return services.atualizarMissao(id, missoesAtualizado);
    }

    //deletar missao(D)
    @DeleteMapping("/deletarMissao/{id}")
    public void deletarMissao(@PathVariable Long id) {
        services.deletarMissao(id);
    }
}
