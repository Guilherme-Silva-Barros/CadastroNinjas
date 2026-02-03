package dev.barros.CadatroDeNinjas.Missoes;

import dev.barros.CadatroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesServices {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper ;

    public MissoesServices(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //criar Missao
    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
        MissoesModel missoes = new MissoesMapper().map(missoesDTO);
        missoes = missoesRepository.save(missoes);
        return missoesMapper.map(missoes);

    }
    //listar missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> listaMissoes = missoesRepository.findAll();
        return listaMissoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //listar missoes por Id
    public MissoesDTO misssoesId(Long id) {
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }
    //atualizar missoes
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missoesDTO) {
       Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
       if (missaoExistente.isPresent()) {
           MissoesModel missaoAtualizado = missoesMapper.map(missoesDTO);
           missaoAtualizado.setId(id);
           MissoesModel missaoSalva = missoesRepository.save(missaoAtualizado);
           return missoesMapper.map(missaoSalva);
       }
       return null;
    }

    //deletar missoes
    public void deletarMissao(Long id) {
        missoesRepository.deleteById(id);
    }

}
