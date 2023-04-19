package Kodlama.io.Devs.business.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.dataAccess.abstracts.LangTechnologyRepository;
import Kodlama.io.Devs.entities.concretes.LangTechnology;

@Service
public class LangTechnologyRules {
    private LangTechnologyRepository langTechnologyRepository;

    @Autowired
    public LangTechnologyRules(LangTechnologyRepository langTechnologyRepository) {
        this.langTechnologyRepository = langTechnologyRepository;
    }

    public void isNameExist(LangTechnology langTechnology) throws Exception {
        List<LangTechnology> langTechnologyList = langTechnologyRepository.findAll();
        for (LangTechnology e : langTechnologyList) {
            if (langTechnology.getLangTechName().equals(e.getLangTechName())) {
                throw new Exception("Zaten bu isimde bir programlama dili mevcut!");
            }
        }
    }
}
