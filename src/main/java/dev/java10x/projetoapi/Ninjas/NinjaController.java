package dev.java10x.projetoapi.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Boas-vindas - Olá mundo!";
    }

    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel){
        return ninjaService.criarNinja(ninjaModel);
    }

    @GetMapping("/all")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/todos/{id}")
    public NinjaModel mostrarNinjasID(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinjasID(@PathVariable Long id, @RequestBody NinjaModel ninjaModel){
        return ninjaService.atualizarNinja(id, ninjaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjas(@PathVariable Long id){
        ninjaService.removerNinja(id);
    }
}
