package everis.desafio.desafio.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import everis.desafio.desafio.dto.Campanha.CampanhaPostRequest;
import everis.desafio.desafio.dto.Campanha.CampanhaPostResponse;
import everis.desafio.desafio.dto.Campanha.CampanhaResponse;
import everis.desafio.desafio.mapper.CampanhaMapper;
import everis.desafio.desafio.model.Campanha;
import everis.desafio.desafio.service.CampanhaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/campanhas")
public class CampanhaController {
    @Autowired
    CampanhaService campanhaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampanhaResponse>> list() {
        List<CampanhaResponse> campanhaResponses = campanhaService.listAll();
        return ResponseEntity.ok(campanhaResponses);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampanhaPostResponse> create(@RequestBody CampanhaPostRequest campanhaPostRequest) {
        // return ResponseEntity.ok(campanhaService.save(campanhaPostRequest));
        return new ResponseEntity<CampanhaPostResponse>(campanhaService.save(campanhaPostRequest), HttpStatus.CREATED);
    }
}
