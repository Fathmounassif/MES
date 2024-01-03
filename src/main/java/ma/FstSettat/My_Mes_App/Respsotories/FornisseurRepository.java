package ma.FstSettat.My_Mes_App.Respsotories;

import ma.FstSettat.My_Mes_App.entities.Fornisseur;
import ma.FstSettat.My_Mes_App.entities.Reception;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornisseurRepository extends JpaRepository<Fornisseur,Long> {


}


