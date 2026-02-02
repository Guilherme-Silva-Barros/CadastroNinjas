package dev.barros.CadatroDeNinjas.Missoes;

import dev.barros.CadatroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesServices {

    private MissoesRepository missoesRepository;

    public MissoesServices(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }
    //criar Missao
    public MissoesModel criarMissao(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }
    //listar missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

    //listar missoes por Id
    public MissoesModel misssoesId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }
    //atualizar missoes


    //deletar missoes
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

}
