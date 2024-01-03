package ma.FstSettat.My_Mes_App;

import ma.FstSettat.My_Mes_App.Respsotories.FornisseurRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ProduitsRepository;
import ma.FstSettat.My_Mes_App.Respsotories.ReceptionRepository;
import ma.FstSettat.My_Mes_App.entities.Fornisseur;
import ma.FstSettat.My_Mes_App.entities.Produits;
import ma.FstSettat.My_Mes_App.entities.Reception;
import ma.FstSettat.My_Mes_App.security.sevice.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ReceptionsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceptionsMvcApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}


	
	@Bean
	// pour executer le code automatiquement aprés le démarage et executer la méthode.
	CommandLineRunner commandLineRunner(ReceptionRepository receptionRepository) {
		return args -> {


receptionRepository.save(new Reception(null, "Omar",new Date(), new Fornisseur(2L, "Ahmed"), new Produits(1L, "GBL", 10, 20, "Z100",true),"AA", "1000", false));
receptionRepository.save(new Reception(null, "Ali",new Date(), new Fornisseur(2L, "Ahmed"), new Produits(1L, "GBL", 10, 20, "Z100",true),"KK", "1000", false));
receptionRepository.save(new Reception(null, "Ahmed",new Date(), new Fornisseur(1L, "brahim"), new Produits(1L, "GBL", 10, 20, "Z100",true),"GG", "1000", false));
receptionRepository.save(new Reception(null, "Badr",new Date(), new Fornisseur(1L, "brahim"), new Produits(3L, "LAF", 10, 20, "Z200",true),"MM", "1000", false));


			receptionRepository.findAll().forEach(p -> {
				System.out.println(p.getN_de_lot());
			});
		};

	}
	//@Bean
	CommandLineRunner Produit(ProduitsRepository produitsRepository) {
		return args -> {
			produitsRepository.save(new Produits(null, "GBL", 10, 20, "Z100",true));
			produitsRepository.save(new Produits(null, "LAC", 10, 20, "Z150",false));
			produitsRepository.save(new Produits(null, "LAF", 10, 20, "Z200",false));


		};
	}

	//@Bean
	CommandLineRunner saveFornissuer(FornisseurRepository fornisseurRepository) {
		return args -> {
			fornisseurRepository.save(new Fornisseur(null, "brahim"));
			fornisseurRepository.save(new Fornisseur(null, "Ahmed"));
			fornisseurRepository.save(new Fornisseur(null, "Ali"));

		};
	}
	private ProduitsRepository produitsRepository;
	private FornisseurRepository fornisseurRepository;
	private ReceptionRepository receptionRepository;
  //@Bean
	CommandLineRunner saveMagazin(ReceptionRepository receptionRepository){
		return args -> {
			System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			List<Reception> reception=receptionRepository.findAll();
			receptionRepository.findAll().forEach(p -> {
				System.out.println(p.getId_reception());
			});

		};
	}
//@Bean
CommandLineRunner saveUsers(SecurityService securityService){
	return args -> {
		securityService.saveNewUser(null,"Jalal","1234","1234");
		securityService.saveNewUser(null,"Ali","1234","1234");
		securityService.saveNewUser(null,"Hassan","1234","1234");




		securityService.saveNewRole("MAGASINIER","");
		securityService.saveNewRole("ADMIN","");
		securityService.saveNewRole("RECEPENSABL_QAUALITE","");




		securityService.addRoleToUser("Jalal","RECEPENSABL_QAUALITE");
		securityService.addRoleToUser("Jalal","MAGASINIER");
		securityService.addRoleToUser("Jalal","ADMIN");
		securityService.addRoleToUser("Ali","MAGASINIER");
		securityService.addRoleToUser("Hassan","RECEPENSABL_QAUALITE");



	};
}
	//@Bean
	CommandLineRunner update(ReceptionRepository receptionRepository){
		return args -> {
			System.out.println("tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt");
			receptionRepository.update(1L);

		};
}
}
