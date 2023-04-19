package Kodlama.io.Devs.business.rules;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageRules {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageRules(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public void isNameExist(Language language) throws Exception {
        List<Language> languageList = languageRepository.findAll();
        for (Language elementLanguage : languageList) {
            if (language.getLangName().equals(elementLanguage.getLangName())) {
                throw new Exception("Zaten bu isimde bir programlama dili mevcut!");
            }
        }
    }
}
