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
    public String criarNinja() {
        return "Ninja Criado com sucesso";
    }

    //listar ninjas (R)
    @GetMapping("/listarNinjas")
    public List<NinjaModel> listarNinjas() {

        return ninjaService.listarNinjas();
    }

    //procurar ninja (R)
    @GetMapping("/procurarNinjas")
    public String procurarNinjas() {
        return "Ninja Procurado com sucesso";
    }

    //alterar ninja(U)
    @PutMapping("/alterarNinja")
    public String alterarNinja() {
        return "Ninja Alterado com sucesso";
    }

    //deletar ninja(D)
    @DeleteMapping("/deletarNinja")
    public String deletarNinja() {
        return "Ninja Deletado com sucesso";
    }
}
