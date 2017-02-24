package com.enset.web;

import com.enset.entities.Compte;
import com.enset.entities.Operation;
import com.enset.metier.BanqueMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by naoufal on 23/02/2017.
 */
@Controller
public class BanqueController {

    @Autowired
    private BanqueMetierImpl banqueMetier;

    @RequestMapping("/operations")
    public String index(){
        return "comptes";
    }
    @RequestMapping("/consulterCompte")
    public String consulter(Model model, String codeCompte,
                            @RequestParam(name = "page",defaultValue = "0") int page,
                            @RequestParam(name="size",defaultValue = "5") int size){
        model.addAttribute("codeCompte",codeCompte);
        try {
            Compte cp=banqueMetier.consulterCompte(codeCompte);
            Page<Operation> operations=banqueMetier.listOperation(codeCompte,page,size);
            model.addAttribute("listOperations",operations.getContent());
            int[] pages=new int[operations.getTotalPages()];
            model.addAttribute("pages",pages);
            model.addAttribute("compte",cp);
        } catch (Exception e) {
            model.addAttribute("exception",e);
        }
        return "comptes";
    }
    @RequestMapping(value = "/saveOperation",method = RequestMethod.POST)
    public String saveOperation(Model model,String codeCompte,String typeOperation,
                                double montant,String codeCompte2){
        try {
            if(typeOperation.equals("Retrait")){
                banqueMetier.retirer(codeCompte,montant);
            }
            else
                if(typeOperation.equals("Versement")){
                    banqueMetier.verser(codeCompte,montant);

                }
                else
                    if(typeOperation.equals("Virement")){


                                banqueMetier.virement(codeCompte,codeCompte2,montant);
                    }
        } catch (Exception e) {
            return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+(e.getMessage());
        }
        return "redirect:/consulterCompte?codeCompte="+codeCompte;
    }

}
