package Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

@Service
public class NameEmptyRule {
    public void isNameEmpty(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception("İsim boş olamaz!");
        }
    }
}
