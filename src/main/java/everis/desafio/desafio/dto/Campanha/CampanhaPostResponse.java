package everis.desafio.desafio.dto.Campanha;

import lombok.Data;
import java.util.Date;

@Data
public class CampanhaPostResponse {
    private Integer id;
    private String name;
    private Date vigenciaInicio;
    private Date vigenciaFim;
}
