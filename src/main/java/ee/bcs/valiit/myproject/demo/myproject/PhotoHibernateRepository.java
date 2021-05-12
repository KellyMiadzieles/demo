package ee.bcs.valiit.myproject.demo.myproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoHibernateRepository extends JpaRepository<PhotoDatabaseEntity, Integer> {
}
