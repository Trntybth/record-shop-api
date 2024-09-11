package Repository;

import model.RecordShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordShopRepository extends JpaRepository<RecordShop, Long> {
}
