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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){
        return ninjaService.criarNinja(ninja);
    }

    @GetMapping("/all")
    public List<NinjaDTO> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    @GetMapping("/todos/{id}")
    public NinjaDTO mostrarNinjasID(@PathVariable Long id){
        return ninjaService.listarNinjaPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public NinjaDTO alterarNinjasID(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel){
        return ninjaService.atualizarNinja(id, ninjaModel);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarNinjas(@PathVariable Long id){
        ninjaService.removerNinja(id);
    }
}
