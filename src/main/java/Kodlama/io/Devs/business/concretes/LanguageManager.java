package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LanguageService;
import Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Kodlama.io.Devs.business.rules.LanguageRules;
import Kodlama.io.Devs.business.rules.NameEmptyRule;
import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;
    private NameEmptyRule nameEmptyRule;
    private LanguageRules languageRules;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository, NameEmptyRule nameEmptyRule,
            LanguageRules languageRules) {
        this.languageRepository = languageRepository;
        this.nameEmptyRule = nameEmptyRule;
        this.languageRules = languageRules;
    }

    @Override
    public List<CreateLanguageRequest> getAll() {
        List<Language> languages = languageRepository.findAll();
        List<CreateLanguageRequest> languagesResponses = new ArrayList<CreateLanguageRequest>();
        for (Language language : languages) {
            CreateLanguageRequest responseItem = new CreateLanguageRequest();
            responseItem.setLangName(language.getLangName());
            languagesResponses.add(responseItem);
        }
        return languagesResponses;
    }

    @Override
    public CreateLanguageRequest getById(int id) {
        CreateLanguageRequest responseItem = new CreateLanguageRequest();
        responseItem.setLangName(languageRepository.getReferenceById(id).getLangName());
        return responseItem;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language = new Language();
        language.setLangName(createLanguageRequest.getLangName());
        nameEmptyRule.isNameEmpty(language.getLangName());
        languageRules.isNameExist(language);
        languageRepository.save(language);
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public void update(int id, CreateLanguageRequest createLanguageRequest) throws Exception {
        Language language = new Language();
        language.setLangName(createLanguageRequest.getLangName());
        nameEmptyRule.isNameEmpty(language.getLangName());
        languageRules.isNameExist(language);
        language.setId(id);
        languageRepository.save(language);
    }

}
