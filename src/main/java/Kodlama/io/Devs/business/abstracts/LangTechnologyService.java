package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateLangTechRequest;
import Kodlama.io.Devs.entities.concretes.Language;

public interface LangTechnologyService {
    List<CreateLangTechRequest> getAll();
    CreateLangTechRequest getById(int id);
    void add(CreateLangTechRequest createLangTechRequest, Language language) throws Exception;
    void delete(int id);
    void update(int id, CreateLangTechRequest createLangTechRequest, Language language) throws Exception;
}
