package everis.desafio.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CampanhaNotFoundException extends RuntimeException {
    public CampanhaNotFoundException(String message){
        super(message);
    }
}
