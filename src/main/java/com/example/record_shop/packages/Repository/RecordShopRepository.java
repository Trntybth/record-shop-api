package com.example.record_shop.packages.Repository;

import com.example.record_shop.packages.model.RecordShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordShopRepository extends JpaRepository<RecordShop, Long> {
}
