package ma.FstSettat.My_Mes_App.service;

@org.springframework.stereotype.Service
public class Service {
  /*  @Autowired
/*
    private JavaMailSender mailSender;
  private ReceptionRepository receptionRepository;
   public void updateReception(Long id_reception){
       Reception reception;
     reception = receptionRepository.getById(id_reception);
    /* reception.setValide(true);
     receptionRepository.save(reception);
    }

*/


    /*
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail,String body,String subject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mounassif.fst@uhp.ac.ma");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
        System.out.println("Mail Send...");


        //le traitement d'envoie un email avec spring boot.


       }*/
    }
/*  Reception reception;
        reception = receptionRepository.getById(id_reception);

        List<Produits> produits = (List<Produits>) reception.getProduits();
       for (int i=0;i<produits.size();i++){
           if(reception.isValide()==true){
           }
           else sendEmail(id_reception,toEmail,body,subject);*/



