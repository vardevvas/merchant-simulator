package com.goal.merchantsimulator.controller;


import com.goal.merchantsimulator.dto.inbound.TerminalRequest;
import com.goal.merchantsimulator.service.TerminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin()
@RequestMapping("/admin")
@RequiredArgsConstructor
public class TerminalController {

    private final TerminalService terminalService;

    @PostMapping("/terminal")
    public ResponseEntity<?> save(@Valid @RequestBody TerminalRequest terminalRequest){
        return ResponseEntity.ok().body(terminalService.save(terminalRequest));
    }

    @DeleteMapping("/terminal/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok().body(terminalService.delete(id));
    }

    @PutMapping("/terminal/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody TerminalRequest terminalRequest, @PathVariable Long id){
        return ResponseEntity.ok().body(terminalService.update(terminalRequest, id));
    }

    @GetMapping("/terminal/{id}")
    public ResponseEntity<?> getApplication(@PathVariable Long id){
        return ResponseEntity.ok().body(terminalService.getTerminal(id));
    }

    @GetMapping("/terminals")
    public ResponseEntity<?> getApplications(){
        return ResponseEntity.ok().body(terminalService.getTerminals());
    }
}
