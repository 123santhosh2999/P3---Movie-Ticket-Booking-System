package com.example.showmate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.showmate.service.CloudinaryService;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
public class UploadController {
    @Autowired private CloudinaryService cloudinaryService;
    @PostMapping public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) {
        String url = cloudinaryService.uploadFile(file);
        return ResponseEntity.ok(Map.of("url", url));
    }
}
