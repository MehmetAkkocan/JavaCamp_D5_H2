package Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlama.io.Devs.entities.concretes.LangTechnology;

public interface LangTechnologyRepository extends JpaRepository<LangTechnology,Integer>{
    
}
