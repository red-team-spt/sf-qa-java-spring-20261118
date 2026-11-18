package com.septeo.corpus.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Value("${reports.dir}")
    private String reportsDir;

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("file") String fileName) throws IOException {
        File report = new File(reportsDir, fileName);
        byte[] body = Files.readAllBytes(report.toPath());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).body(body);
    }

    @GetMapping("/latest")
    public ResponseEntity<byte[]> latest() throws IOException {
        File report = new File(reportsDir, "latest.csv");
        return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(Files.readAllBytes(report.toPath()));
    }
}
