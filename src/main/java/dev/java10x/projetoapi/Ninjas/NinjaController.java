package dev.java10x.projetoapi.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
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
    @Operation(summary = "Rota de criação", description = "essa rota cria ninjas")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + ninjaDTO.getNome());
    }

    @GetMapping("/todos")
    @Operation(summary = "Rota de listagem", description = "essa rota lista todos os ninjas")
    public ResponseEntity<List<NinjaDTO>>  listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK).body(ninjas);
    }


    // Exemplo mais detalhado com documentação
    @GetMapping("/todos/{id}")
    @Operation(summary = "Rota de listagem por id", description = "essa rota pega ninjas específicas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja listado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Erro ao achar um ninja"),
            @ApiResponse(responseCode = "500", description = "Erro do servidor")
    })
    public ResponseEntity<?> mostrarNinjasID(
            @Parameter(description = "Usuário envia o id na url da requisição")
            @PathVariable Long id
    )
    {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);

        if(ninja != null){
            return ResponseEntity.status(HttpStatus.OK).body(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possível encontrar o ninja com id fornecido");
    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Rota de alterar", description = "essa rota altera ninjas específicos")
    public ResponseEntity<String> alterarNinjasID(@PathVariable Long id, @RequestBody NinjaDTO ninjaModel) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaModel);

        if(ninja != null){
            return ResponseEntity.ok("Ninja alterado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Rota de apagar por id", description = "essa rota apaga ninjas")
    public ResponseEntity<String> deletarNinjas(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.removerNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja não encontrado");
    }
}
