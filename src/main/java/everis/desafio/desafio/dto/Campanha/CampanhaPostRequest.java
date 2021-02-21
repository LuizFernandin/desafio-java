package everis.desafio.desafio.dto.Campanha;

import java.util.Date;
import lombok.Data;

@Data
public class CampanhaPostRequest {
    private String name;
    private Date vigenciaInicio;
    private Date vigenciaFim;
}
