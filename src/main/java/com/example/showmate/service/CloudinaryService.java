package com.example.showmate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.showmate.config.CloudinaryConfig;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    @Autowired
    private CloudinaryConfig cloudinary;

    // Upload file to Cloudinary and return the URL as String
    @SuppressWarnings("rawtypes")
    public String uploadFile(MultipartFile file) throws IOException {
        Map uploadResult = ((Object) cloudinary).uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("url").toString(); // ✅ only return URL
    }
}