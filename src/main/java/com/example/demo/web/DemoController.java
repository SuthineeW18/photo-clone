package com.example.demo.web;

import com.example.demo.model.Photo;
import com.example.demo.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class DemoController {
    private final PhotoService photoService;

    public DemoController(PhotoService photoService) {
        this.photoService = photoService;
    }
    @GetMapping("/")
    public  String hello() {
        return "Hello World";
    }
    @GetMapping("/photo")
    public Iterable<Photo> get() {
        return photoService.get();
    }
    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);
    }
    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
       return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
