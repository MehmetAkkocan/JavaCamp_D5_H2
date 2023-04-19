package Kodlama.io.Devs.business.responses;

import Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLangTechResponse {    
    private int id;
    private String langTechName;
    private Language language;
}
