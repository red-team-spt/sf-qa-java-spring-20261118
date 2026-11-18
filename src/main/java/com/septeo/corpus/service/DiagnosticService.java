package com.septeo.corpus.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class DiagnosticService {

    public String lookup(String host) throws IOException {
        Process p = Runtime.getRuntime().exec(new String[] {"sh", "-c", "nslookup " + host});
        try (BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            return r.lines().collect(Collectors.joining("\n"));
        }
    }
}
