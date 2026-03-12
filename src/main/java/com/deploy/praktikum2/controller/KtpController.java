package com.deploy.praktikum2.controller;

import com.deploy.praktikum2.model.dto.KtpAddRequest;
import com.deploy.praktikum2.model.dto.KtpDto;
import com.deploy.praktikum2.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> AddKtp(@RequestBody KtpAddRequest request) {
        try {
            KtpDto result = ktpService.AddKtp(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("status", "success", "data", result));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getAllKtp() {
        List<KtpDto> result = ktpService.getAllKtp();
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "data", result));
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> getKtpById(@PathVariable("id") Integer id) {
        try {
            KtpDto result = ktpService.getKtpById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "data", result));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @PutMapping(
            path = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> UpdateKtp(@PathVariable("id") Integer id, @RequestBody KtpAddRequest request) {
        try {
            KtpDto result = ktpService.UpdateKtp(id, request);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "data", result));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("status", "error", "message", e.getMessage()));
        }
    }

    @DeleteMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Map<String, Object>> DeleteKtp(@PathVariable("id") Integer id) {
        try {
            ktpService.DeleteKtp(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("status", "success", "message", "Data KTP berhasil dihapus"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", "error", "message", e.getMessage()));
        }
    }
}