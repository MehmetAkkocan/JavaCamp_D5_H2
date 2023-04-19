package Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Kodlama.io.Devs.business.requests.CreateLanguageRequest;

public interface LanguageService {
    List<CreateLanguageRequest> getAll();
    CreateLanguageRequest getById(int id);
    void add(CreateLanguageRequest createLanguageRequest) throws Exception;
    void delete(int id);
    void update(int id, CreateLanguageRequest createLanguageRequest) throws Exception;
}
