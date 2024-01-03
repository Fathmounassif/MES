package ma.FstSettat.My_Mes_App.Respsotories;

import ma.FstSettat.My_Mes_App.entities.Reception;
import ma.FstSettat.My_Mes_App.entities.ValiderReception;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ValiderReceptionRepository extends JpaRepository<ValiderReception,Long> {
   Page<ValiderReception> findByNomContains(String kw, Pageable pageable);
}


