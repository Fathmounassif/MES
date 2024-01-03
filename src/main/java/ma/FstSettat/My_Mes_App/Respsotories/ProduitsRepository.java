package ma.FstSettat.My_Mes_App.Respsotories;

import ma.FstSettat.My_Mes_App.entities.Fornisseur;
import ma.FstSettat.My_Mes_App.entities.Produits;
import ma.FstSettat.My_Mes_App.entities.Reception;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitsRepository extends JpaRepository<Produits,Long> {
   /* @Query("select p from Produits p where p.Num_bobine =?1 ")
    public Produits findByIdProduit(long id);*/
}


