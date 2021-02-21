package everis.desafio.desafio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import everis.desafio.desafio.dto.Campanha.CampanhaPostRequest;
import everis.desafio.desafio.dto.Campanha.CampanhaPostResponse;
import everis.desafio.desafio.dto.Campanha.CampanhaResponse;
import everis.desafio.desafio.exception.CampanhaNotFoundException;
import everis.desafio.desafio.mapper.CampanhaMapper;
import everis.desafio.desafio.model.Campanha;
import everis.desafio.desafio.repository.CampanhaRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class CampanhaService {
    @Autowired
    CampanhaRepository campanhaRepository;
    @Autowired
    CampanhaMapper campanhaMapper;

    public CampanhaResponse find(Integer id) {
        Campanha campanha = campanhaRepository.findById(id).get();
        CampanhaResponse campanhaResponse = campanhaMapper.toDto(campanha);
        return campanhaResponse;
    }

    public List<CampanhaResponse> listAll() {
        List<Campanha> campanha = campanhaRepository.findAll();

        if(campanha.isEmpty()){
            throw new CampanhaNotFoundException("Nenhuma Campanha existente");
        }
        List<CampanhaResponse> campanhas = campanha.stream()
        .map(campanha1 -> {
            CampanhaResponse campanhaResponse = campanhaMapper.toDto(campanha1);
            return campanhaResponse;
        })
        .collect(Collectors.toList());
        return campanhas;
    }

    public CampanhaPostResponse save(CampanhaPostRequest campanhaPostRequest) {
        Campanha campanha = campanhaMapper.toEntity(campanhaPostRequest);
        campanhaRepository.save(campanha);
        CampanhaPostResponse campanhaPostResponse = campanhaMapper.de(campanhaPostRequest);
        return campanhaPostResponse;
    }

}
