package com.example.enseignant_service.web;

import com.example.enseignant_service.dto.RequestEnseignantDto;
import com.example.enseignant_service.dto.ResponseEnseignantDto;
import com.example.enseignant_service.service.EnseignantServiceImpl;
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
                title = "Gestion des enseignant",
                description = "cette offre tous les méthodes pour gérer les enseignants",
                version = "1.0.0"
        ),
        servers = @Server(
                url = "http://localhost:8085"
        )
)
@RestController
@RequestMapping("/v1/enseignants")
public class APIRest {
    private EnseignantServiceImpl enseignantServiceImpl;

    public APIRest(EnseignantServiceImpl enseignantServiceImpl) {
        this.enseignantServiceImpl = enseignantServiceImpl;
    }

    @Operation(
            summary = " Ajouter un enseignant",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestEnseignantDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseEnseignantDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ResponseEnseignantDto> add(@RequestBody RequestEnseignantDto requestEnseignantDto) {
        ResponseEnseignantDto responseEnseignantDto = enseignantServiceImpl.Add_Enseignant(requestEnseignantDto);
        return ResponseEntity.ok(responseEnseignantDto);

    }

    @Operation(
            summary = " récuperer liste des enseignants",

            responses = {
                    @ApiResponse(responseCode = "200", description = "bien enregiter",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ResponseEnseignantDto.class ))
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ResponseEnseignantDto>> getall(){
        List<ResponseEnseignantDto> enseignantDtos = enseignantServiceImpl.GETALLEnseignant();
        return ResponseEntity.ok(enseignantDtos);

    }

    @Operation(
            summary = " récupérer enseignant par Id",
            parameters = @Parameter(name = "id", required = true),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien récuperer",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseEnseignantDto.class )
                            )
                    ),
                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseEnseignantDto> getEnseignantById(@PathVariable Integer id) {
        ResponseEnseignantDto responseEnseignantDto = enseignantServiceImpl.GETEnseignantById(id);
        return ResponseEntity.ok(responseEnseignantDto);
    }

    @Operation(
            summary = " Modifier un enseignant",
            parameters = @Parameter(name = "id", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = RequestEnseignantDto.class )
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "bien modifier",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ResponseEnseignantDto.class )
                            )
                    ),

                    @ApiResponse(responseCode = "4xx",description = "erreur client"),
                    @ApiResponse(responseCode = "5xx",description = "erreur serveur"),
            }
    )

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseEnseignantDto> update(@PathVariable Integer id,
                                                    @RequestBody RequestEnseignantDto requestEnseignantDto) {
        ResponseEnseignantDto responseEnseignantDto = enseignantServiceImpl.UPDATEEnseignant(id, requestEnseignantDto);
        return ResponseEntity.ok(responseEnseignantDto);
    }

    @Operation(
            summary = " supprimer enseignant par Id",
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
        enseignantServiceImpl.DELETEEnseignantBYID(id);
        return ResponseEntity.ok().build();
    }



}
