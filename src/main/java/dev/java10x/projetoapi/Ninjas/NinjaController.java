package dev.java10x.projetoapi.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Boas-vindas - Olá mundo!";
    }

    @PostMapping("/criar")
    public String criarNinja(){
        return "Criado com sucesso!";
    }

    @GetMapping("/all")
    public String allNinjas(){
        return "Ninjas";
    }

    @GetMapping("/todosID")
    public String mostrarNinjasID(){
        return "Ninjas por ID";
    }

    @PutMapping("/alterarID")
    public String alterarNinjasID(){
        return "Alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarNinjas(){
        return "Deletado com sucesso!";
    }
}
