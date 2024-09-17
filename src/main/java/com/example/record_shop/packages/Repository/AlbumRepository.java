package com.example.record_shop.packages.Repository;

import com.example.record_shop.packages.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}




