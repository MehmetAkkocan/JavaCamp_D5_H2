package Kodlama.io.Devs.webApi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.LangTechnologyService;
import Kodlama.io.Devs.business.requests.CreateLangTechRequest;
import Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/langtechnology")
public class LangTechnologyController {

    private LangTechnologyService langTechnologyService;

    @Autowired
    public LangTechnologyController(LangTechnologyService langTechnologyService) {
        this.langTechnologyService = langTechnologyService;
    }
    
     
    @GetMapping("/getall")
    public List<CreateLangTechRequest> getAll(){
        return langTechnologyService.getAll();
    }
    @PostMapping("/add")    
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateLangTechRequest createLangTechRequest, Language language) throws Exception{
        langTechnologyService.add(createLangTechRequest, language);
    }
    @PutMapping("/update/{id}")
    public void update(int id , CreateLangTechRequest createLangTechRequest, Language language) throws Exception{
        langTechnologyService.update(id, createLangTechRequest,language);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") int id){
        langTechnologyService.delete(id);
    }
}
