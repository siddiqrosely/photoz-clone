package com.sidcorp.photoz.clone.web;

import com.sidcorp.photoz.clone.model.Photo;
import com.sidcorp.photoz.clone.service.PhotozService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;


@RestController
public class PhotozController {

    @Autowired
    private PhotozService photozService;

//    public PhotozController(PhotozService photozService) {
//        this.photozService = photozService;
//    }

    @GetMapping("/")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public  Photo get(@PathVariable Integer id){
      Photo photo = photozService.get(id);
      if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
       photozService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        return photozService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());

    }

}
