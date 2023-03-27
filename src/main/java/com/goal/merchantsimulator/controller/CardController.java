package com.goal.merchantsimulator.controller;

import com.goal.merchantsimulator.dto.inbound.CardRequest;
import com.goal.merchantsimulator.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin()
@RequiredArgsConstructor
@RequestMapping("/admin")
public class CardController {

    private final CardService cardService;

    @PostMapping("/card")
    public ResponseEntity<?> save(@Valid @RequestBody CardRequest cardRequest){
        return ResponseEntity.ok().body(cardService.save(cardRequest));
    }

    @DeleteMapping("/card/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(cardService.delete(id));
    }

    @PutMapping("/card/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody CardRequest cardRequest, @PathVariable Long id){
        return ResponseEntity.ok().body(cardService.update(cardRequest, id));
    }

    @GetMapping("/card/{id}")
    public ResponseEntity<?> getApplication(@PathVariable Long id){
        return ResponseEntity.ok().body(cardService.getCard(id));
    }

    @GetMapping("/cards")
    public ResponseEntity<?> getApplications(){
        return ResponseEntity.ok().body(cardService.getCards());
    }
}
