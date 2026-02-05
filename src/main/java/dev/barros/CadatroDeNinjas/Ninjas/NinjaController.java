package dev.barros.CadatroDeNinjas.Ninjas;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Boas vindas a minha primeira app Spring";
    }

    //Adicionar ninja (C)
    @PostMapping("/criarNinja")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "ID: " + novoNinja.getId());
    }

    //listar ninjas (R)
    @GetMapping("/listarNinjas")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    //listar ninjas pro id
    @GetMapping("/ninjasId/{id}")
    public ResponseEntity<?> ninjaID(@PathVariable Long id) {

        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
        }
    }

    //alterar ninja(U)
    @PutMapping("/alterarNinja/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrada");
        }
    }

    //deletar ninja(D)
    @DeleteMapping("/deletarNinja/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID:" + id + " apagado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID: " + id + " não encontrado");
        }
    }
}
