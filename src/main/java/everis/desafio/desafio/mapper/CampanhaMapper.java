package everis.desafio.desafio.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import everis.desafio.desafio.dto.Campanha.*;
import everis.desafio.desafio.model.Campanha;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CampanhaMapper {

    Campanha toEntity(CampanhaRequest campanhaRequest);
    Campanha toEntity(CampanhaPostRequest campanhaPostRequest);
    
    CampanhaResponse toDto(Campanha campanha);

    CampanhaPostResponse de(final CampanhaPostRequest campanhaPostRequest);
   
    @InheritInverseConfiguration
    CampanhaPostRequest de(final CampanhaPostResponse campanhaPostResponse);
   
    List<CampanhaPostResponse> deRequest(final List<CampanhaPostRequest> enderecoRequests);
    List<CampanhaPostRequest> deResponse(final List<CampanhaPostResponse> enderecoResponses);
}
