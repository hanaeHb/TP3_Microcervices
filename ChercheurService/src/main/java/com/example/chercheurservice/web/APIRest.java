package com.example.chercheurservice.web;

import com.example.chercheurservice.dto.RequestChercheurDto;
import com.example.chercheurservice.dto.ResponseChercheurDto;
import com.example.chercheurservice.service.ChercheurServiceImpl;
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
                title = "Gestion des chercheurs",
                description = "cette offre tous les méthodes pour gérer les chercheurs",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8086"
        )
)
@RestController
@RequestMapping("/v1/chercheurs")
public class APIRest {
    private ChercheurServiceImpl chercheurService;

    public APIRest(ChercheurServiceImpl chercheurService) {
        this.chercheurService = chercheurService;
    }

    @Operation(
            summary = " Ajouter un chercheur",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestChercheurDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseChercheurDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseChercheurDto> add(@RequestBody RequestChercheurDto requestChercheurDto) {
        ResponseChercheurDto responseChercheurDto = chercheurService.Add_Chercheur(requestChercheurDto);
        return ResponseEntity.ok(responseChercheurDto);

    }

    @Operation(
            summary = " récuperer liste des chercheurs",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseChercheurDto.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<ResponseChercheurDto>> getall(){
        List<ResponseChercheurDto> chercheurDtos = chercheurService.GETALLChercheur();
        return ResponseEntity.ok(chercheurDtos);

    }

    @Operation(
            summary = " récupérer chercheur par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseChercheurDto.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseChercheurDto> getChercheurById(@PathVariable Integer id) {
        ResponseChercheurDto responseChercheurDto = chercheurService.GETChercheurById(id);
        return ResponseEntity.ok(responseChercheurDto);
    }

    @Operation(
            summary = " Modifier un chercheur",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestChercheurDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseChercheurDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseChercheurDto> update(@PathVariable Integer id,
                                                        @RequestBody RequestChercheurDto requestChercheurDto) {
        ResponseChercheurDto responseChercheurDto = chercheurService.UPDATEChercheur(id, requestChercheurDto);
        return ResponseEntity.ok(responseChercheurDto);
    }

    @Operation(
            summary = " supprimer chercheur par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien supprimer"),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        chercheurService.DELETEChercheurBYID(id);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = " Nombre de chercheurs par enseignant",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Succès",
                            content = @Content(
                                    mediaType = "application/json"
                            )
                    ),
                    @ApiResponse(responseCode = "4xx", description = "Erreur client"),
                    @ApiResponse(responseCode = "5xx", description = "Erreur serveur"),
            },
            parameters = @Parameter(name = "idEnseignant", required = true)
    )
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/enseignant/{idEnseignant}")
    public ResponseEntity<List<ResponseChercheurDto>> getByEnseignant(@PathVariable Integer idEnseignant) {
        List<ResponseChercheurDto> chercheurs = chercheurService.getChercheursByEnseignant(idEnseignant);
        return ResponseEntity.ok(chercheurs);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN','SCOPE_USER')")
    @GetMapping("/projet/{idProjet}")
    public ResponseEntity<List<ResponseChercheurDto>> getByProjet(@PathVariable Integer idProjet) {
        List<ResponseChercheurDto> chercheurs = chercheurService.getChercheursByProjet(idProjet);
        return ResponseEntity.ok(chercheurs);
    }

}
