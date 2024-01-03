package ma.FstSettat.My_Mes_App.Respsotories;

import ma.FstSettat.My_Mes_App.entities.Reception;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
public interface ReceptionRepository extends JpaRepository<Reception,Long> {
   Page<Reception> findByNomContains(String kw, Pageable pageable);
  @Transactional
   @Modifying
   @Query("Update Reception p set p.valide= true where p.id_reception =?1")
   public void  update(Long id_reception);




}


