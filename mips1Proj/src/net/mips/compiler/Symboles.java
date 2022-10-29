package net.mips.compiler;

public class Symboles{
	
	Tokens token;
	String nom;

public Symboles() {
	this.nom="";
}		
	
public Symboles(Tokens t,String n) {
	this.token=t;
	this.nom=n;
}

public Symboles(String n) 
{
	this.nom = n;
}
public String getNom() {
	return this.nom;
}
public void setNom(String n) {
	this.nom=n;
}
public Tokens getToken() {
	return token;
}
public void setToken(Tokens t) {
	this.token=t;
}
}
