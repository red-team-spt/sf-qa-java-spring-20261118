package com.septeo.corpus.controller;

import com.septeo.corpus.service.DiagnosticService;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/diagnostics")
public class DiagnosticController {

    private final DiagnosticService diagnostics;

    public DiagnosticController(DiagnosticService diagnostics) {
        this.diagnostics = diagnostics;
    }

    @GetMapping("/dns")
    public String dns(@RequestParam String host) throws IOException {
        return diagnostics.lookup(host);
    }
}
