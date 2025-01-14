package dev.java10x.projetoapi.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + ninjaDTO.getNome());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<NinjaDTO>>  listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK).body(ninjas);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> mostrarNinjasID(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if(ninja != null){
            return ResponseEntity.status(HttpStatus.OK).body(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o ninja com id fornecido");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinjasID(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaModel);

        if(ninja != null){
            return ResponseEntity.ok("Ninja alterado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjas(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.removerNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }
}
