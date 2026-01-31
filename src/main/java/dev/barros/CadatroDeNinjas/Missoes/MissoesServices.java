package dev.barros.CadatroDeNinjas.Missoes;

import dev.barros.CadatroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesServices {

    private MissoesRepository missoesRepository;
    public  MissoesServices(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel>listarMissoes() {
        return missoesRepository.findAll();
    }
}
