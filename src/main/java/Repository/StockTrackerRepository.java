package Repository;

import model.StockTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTrackerRepository extends JpaRepository<StockTracker, Long> {
}
