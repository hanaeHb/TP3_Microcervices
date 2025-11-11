package com.example.projetservice.web;

import com.example.projetservice.dto.RequestProjetDto;
import com.example.projetservice.dto.ResponseProjetDto;
import com.example.projetservice.service.ProjetServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestion des projets",
                description = "cette offre tous les méthodes pour gérer les projets",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8087"
        )
)
@RestController
@RequestMapping("/v1/projets")
public class APIRest {

    private ProjetServiceImpl  projetService;
    public APIRest(ProjetServiceImpl projetService) {
        this.projetService = projetService;
    }

    @Operation(
            summary = " Ajouter un projet",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestProjetDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseProjetDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseProjetDto> add(@RequestBody RequestProjetDto requestProjetDto) {
        ResponseProjetDto responseProjetDto = projetService.Add_Projet(requestProjetDto);
        return ResponseEntity.ok(responseProjetDto);

    }

    @Operation(
            summary = " récuperer liste des projets",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseProjetDto.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ResponseProjetDto>> getall(){
        List<ResponseProjetDto> projetDtos = projetService.GETALLProjet();
        return ResponseEntity.ok(projetDtos);

    }

    @Operation(
            summary = " récupérer projet par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseProjetDto.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseProjetDto> getProjetById(@PathVariable Integer id) {
        ResponseProjetDto responseProjetDto = projetService.GETProjetById(id);
        return ResponseEntity.ok(responseProjetDto);
    }

    @Operation(
            summary = " Modifier un projet",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestProjetDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseProjetDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseProjetDto> update(@PathVariable Integer id,
                                                       @RequestBody RequestProjetDto requestProjetDto) {
        ResponseProjetDto responseProjetDto = projetService.UPDATEProjet(id, requestProjetDto);
        return ResponseEntity.ok(responseProjetDto);
    }

    @Operation(
            summary = " supprimer projet par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
       projetService.DELETEProjetBYID(id);
        return ResponseEntity.ok().build();
    }

}
