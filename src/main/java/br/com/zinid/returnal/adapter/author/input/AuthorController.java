package br.com.zinid.returnal.adapter.author.input;

import br.com.zinid.returnal.application.domain.author.input.CreateAuthorInputPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final CreateAuthorInputPort authorService;
    public AuthorController(CreateAuthorInputPort authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
         authorService.execute(authorRequest.toDomain());
         return ResponseEntity.ok().build();
    }

}
