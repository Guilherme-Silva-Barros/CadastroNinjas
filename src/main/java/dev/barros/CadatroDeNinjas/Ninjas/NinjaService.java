package dev.barros.CadatroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    // C R U D
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //criar ninjas
    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    //listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    //listar ninjas por id
    public NinjaModel listarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }
    // atualizar ninjas
    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAtualizado) {
        if(ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    //deletar ninjas - tem que ser VOID
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
    }


}
