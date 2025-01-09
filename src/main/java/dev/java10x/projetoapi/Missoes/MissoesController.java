package dev.java10x.projetoapi.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {
    @PostMapping("/criar")
    public String criarMissao(){
        return "Criado com sucesso!";
    }

    @GetMapping("/all")
    public String allMissoes(){
        return "Missoes";
    }

    @GetMapping("/todosID")
    public String mostrarMissaoID(){
        return "Missoes por ID";
    }

    @PutMapping("/alterarID")
    public String alterarMissoesID(){
        return "Alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarMissoes(){
        return "Deletado com sucesso!";
    }
}
