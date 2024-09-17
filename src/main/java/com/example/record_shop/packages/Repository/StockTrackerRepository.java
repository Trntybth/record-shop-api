package com.example.record_shop.packages.Repository;

import com.example.record_shop.packages.model.StockTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTrackerRepository extends JpaRepository<StockTracker, Long> {
}
