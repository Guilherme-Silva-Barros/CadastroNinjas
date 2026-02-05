package dev.barros.CadatroDeNinjas.Missoes;

import dev.barros.CadatroDeNinjas.Ninjas.NinjaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesServices services;

    public MissoesController(MissoesServices services) {

        this.services = services;
    }

    //criar missão(C)
    @PostMapping("/criarMissao")
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoes) {
        MissoesDTO novaMissao = services.criarMissao(missoes);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missão criado com sucesso: " + novaMissao.getNome() + " (ID): " + novaMissao.getId());
    }

    //mostrar missao(R)
    @GetMapping("/mostrarMissao")
    public ResponseEntity<List<MissoesDTO>> mostrarMissao() {
        List<MissoesDTO> missoes = services.listarMissoes();
        return ResponseEntity.ok(missoes);
    }

    //missoes por ID
    @GetMapping("/missoesID/{id}")
    public ResponseEntity<?> missoesID(@PathVariable Long id) {

        MissoesDTO missoesID = services.misssoesId(id);

        if (missoesID != null) {
            return ResponseEntity.ok(missoesID);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada");
        }
    }

    //alterar missao(U)
    @PutMapping("/alterarMissao/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesAtualizado) {
        MissoesDTO missao = services.atualizarMissao(id, missoesAtualizado);

        if (missao != null) {
            return ResponseEntity.ok(missao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão não encontrada");
        }
    }

    //deletar missao(D)
    @DeleteMapping("/deletarMissao/{id}")
    public ResponseEntity<String> deletarMissao(@PathVariable Long id) {
        if (services.misssoesId(id) != null) {
            services.deletarMissao(id);
            return ResponseEntity.ok()
                    .body("Misão ID: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de ID: " + id + " inexistente!");
        }
    }
}
