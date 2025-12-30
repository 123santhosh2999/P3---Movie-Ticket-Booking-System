package com.example.showmate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

@Service
public class CloudinaryService {
    @Value("${cloudinary.cloud_name:}") private String cloudName;
    @Value("${cloudinary.api_key:}") private String apiKey;
    @Value("${cloudinary.api_secret:}") private String apiSecret;

    public String uploadFile(MultipartFile file) {
        if (cloudName == null || cloudName.isBlank()) {
            return "https://res.cloudinary.com/demo/image/upload/v1/placeholder/" + UUID.randomUUID() + ".jpg";
        }
        return "https://res.cloudinary.com/" + cloudName + "/image/upload/" + UUID.randomUUID() + ".jpg";
    }
}
