/*function sendEmail(){
Email.send({
    Host : "smtp.elasticemail.com",
    Username : "mounassif.fst@uhp.ac.ma",
    Password : "gtkxatxxsnzyzltq",
    To : 'fathmounassif@gmail.com',
    From : "mounassif.fst@uhp.ac.ma",
    Subject : "hello",
    Body : "hello"
}).then(
  message => alert("send seccussfuly")
);
}*/


var num=Math.random();
function sendEmail(){
var params ={
form_name : "fathmounassif",
email_id : "Magasinier@gmail.com",
message : num+" :Merci de valider Les bobines"
}
emailjs.send("service_9x4cxcf","template_ro9gi0n",params).then(function(res){
alert("Votre message est envoyé");})

}



