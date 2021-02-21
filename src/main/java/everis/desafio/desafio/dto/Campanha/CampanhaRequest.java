package everis.desafio.desafio.dto.Campanha;

import lombok.Data;
import java.util.Date;

@Data
public class CampanhaRequest {
    private String name;
    private Date vigenciaInicio;
    private Date vigenciaFim;
}
