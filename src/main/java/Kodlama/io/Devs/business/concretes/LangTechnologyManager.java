package Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.LangTechnologyService;
import Kodlama.io.Devs.business.requests.CreateLangTechRequest;
import Kodlama.io.Devs.business.rules.LangTechnologyRules;
import Kodlama.io.Devs.business.rules.NameEmptyRule;
import Kodlama.io.Devs.dataAccess.abstracts.LangTechnologyRepository;
import Kodlama.io.Devs.entities.concretes.LangTechnology;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LangTechnologyManager implements LangTechnologyService {

    private LangTechnologyRepository langTechnologyRepository;
    private NameEmptyRule nameEmptyRule;
    private LangTechnologyRules langTechnologyRules;

    @Autowired
    public LangTechnologyManager(LangTechnologyRepository langTechnologyRepository, NameEmptyRule nameEmptyRule,
            LangTechnologyRules langTechnologyRules) {
        this.langTechnologyRepository = langTechnologyRepository;
        this.nameEmptyRule = nameEmptyRule;
        this.langTechnologyRules = langTechnologyRules;
    }

    @Override
    public List<CreateLangTechRequest> getAll() {
        List<LangTechnology> langTechnologies = langTechnologyRepository.findAll();
        List<CreateLangTechRequest> allLangTechResponses = new ArrayList<>();
        for (LangTechnology langTechnology : langTechnologies) {
            CreateLangTechRequest responseItem = new CreateLangTechRequest();
            responseItem.setLangTechName(langTechnology.getLangTechName());
            responseItem.setLanguage(langTechnology.getLanguage());
            allLangTechResponses.add(responseItem);
        }
        return allLangTechResponses;
    }

    
    @Override
    public CreateLangTechRequest getById(int id) {
        CreateLangTechRequest responseItem = new CreateLangTechRequest();
        responseItem.setLangTechName(langTechnologyRepository.getReferenceById(id).getLangTechName());
        return responseItem;
    }

    @Override
    public void add(CreateLangTechRequest createLangTechRequest, Language language) throws Exception {
        LangTechnology langTechnology = new LangTechnology();
        langTechnology.setLangTechName(createLangTechRequest.getLangTechName());
        langTechnology.setLanguage(language);
        nameEmptyRule.isNameEmpty(language.getLangName());
        langTechnologyRules.isNameExist(langTechnology);
        langTechnologyRepository.save(langTechnology);
    }

    @Override
    public void delete(int id) {
       langTechnologyRepository.deleteById(id);
    }

    @Override
    public void update(int id, CreateLangTechRequest createLangTechRequest, Language language) throws Exception {
        LangTechnology langTechnology = new LangTechnology();
        langTechnology.setLangTechName(createLangTechRequest.getLangTechName());
        langTechnology.setLanguage(language);
        langTechnology.setId(id);
        nameEmptyRule.isNameEmpty(language.getLangName());
        langTechnologyRules.isNameExist(langTechnology);
        langTechnologyRepository.save(langTechnology);
    }

}
