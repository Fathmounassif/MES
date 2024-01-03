

var num=Math.random();
function sendEmaill(){
var params ={
form_name : "fath",
email_id : "Responsable_quality@gmail.com",
message : num+" :Merci de coller les étiquettes"
}
emailjs.send("service_546zhrk","template_x42nsyl",params).then(function(res){
alert("Votre message est envoyé");})

}



