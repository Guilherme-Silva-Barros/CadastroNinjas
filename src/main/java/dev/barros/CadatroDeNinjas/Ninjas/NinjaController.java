package dev.barros.CadatroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Boas vindas a minha primeira app Spring";
    }

    //Adicionar ninja (C)
    @PostMapping("/criarNinja")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {

        return ninjaService.criarNinja(ninja);
    }

    //listar ninjas (R)
    @GetMapping("/listarNinjas")
    public List<NinjaDTO> listarNinjas() {

        return ninjaService.listarNinjas();
    }

    //listar ninjas pro id
    @GetMapping("/ninjasId/{id}")
    public NinjaDTO ninjaID(@PathVariable Long id) {
        return ninjaService.listarNinjaPorId(id);
    }

    //procurar ninja (R)
    @GetMapping("/procurarNinjas")
    public String procurarNinjas() {
        return "Ninja Procurado com sucesso";
    }

    //alterar ninja(U)
    @PutMapping("/alterarNinja/{id}")
    public NinjaDTO alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        return ninjaService.alterarNinja(id, ninjaAtualizado);
    }

    //deletar ninja(D)
    @DeleteMapping("/deletarNinja/{id}")
    public void deletarNinja(@PathVariable Long id) {
         ninjaService.deletarNinja(id);
    }
}
