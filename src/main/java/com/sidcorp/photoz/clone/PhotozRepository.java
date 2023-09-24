package com.sidcorp.photoz.clone;

import com.sidcorp.photoz.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {


}
