package com.example.demo.repository;
import com.example.demo.model.Photo;
import org.springframework.data.repository.CrudRepository;
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
