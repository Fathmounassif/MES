package ma.FstSettat.My_Mes_App.Respsotories;

import ma.FstSettat.My_Mes_App.entities.Controle_qualite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ResponsableQualityRepository extends JpaRepository<Controle_qualite,Long> {
   Page<Controle_qualite> findByNomContains(String kw, Pageable pageable);
   @Transactional
   @Modifying
   @Query("Update Controle_qualite p set p.valide= true where p.id_operation =?1")
   public void  update(Long id_operation);




}


