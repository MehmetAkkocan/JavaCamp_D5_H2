package Kodlama.io.Devs.business.requests;

import Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLangTechRequest {
    private String langTechName;
    private Language language;
}
