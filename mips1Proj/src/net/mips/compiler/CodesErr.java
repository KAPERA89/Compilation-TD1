package net.mips.compiler;

public enum CodesErr {
   CAR_INC_ERR ("symbole inconnu"),
FIC_VIDE_ERR("Erreur dóuverture de fichier");
	private String message;
	
 
	CodesErr(String message) {
	this.message=message;
}

public String getMessage() {
return this.message;
}
public void setMessage(String msg) {
	this.message=msg;
}
}
