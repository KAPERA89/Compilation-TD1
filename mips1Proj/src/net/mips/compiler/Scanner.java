package net.mips.compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//My test : 
import java.io.*;

public class Scanner {
List<Symboles>motsCles;
Symboles symbCour;
char carCour;
FileReader fluxSour;
static final int EOF = 0;  
//Exception EOF;

Scanner()
{
	
}

Scanner(Symboles sybCo,char car,FileReader flux,List<Symboles>mots){
	this.symbCour=sybCo;
	this.carCour=car;
	this.motsCles=mots;
	this.fluxSour=flux;
}
 
Scanner(String f) throws Exception,ErreurCompilation
{
	File file=new File(f);
	
	if(!file.exists())
		 throw new ErreurLexicale(CodesErr.FIC_VIDE_ERR);
	else {
	  
//	  //FileReader fr = new FileReader(file);
//	  this.fluxSour = new FileReader(file);
//	  BufferedReader br = new BufferedReader(this.fluxSour);
//	  String line;
//	  while((line = br.readLine()) != null)
//	  {
//		  System.out.println(line);
//		  
//	  }
	     FileReader fr = new FileReader(file);
		  int content;
		  while((content = fr.read()) != 1) {
			  System.out.print((char) content);
		  }
	} 	
}

public List<Symboles> getMotsCles() {
	return motsCles;
}

public void setMotsCles(List<Symboles> motsCles) {
	this.motsCles = motsCles;
}

public Symboles getSymbCour() {
	return symbCour;
}

public void setSymbCour(Symboles symbCour) {
	this.symbCour = symbCour;
}

public char getCarCour() {
	return carCour;
}

public void setCarCour(char carCour) {
	this.carCour = carCour;
}

public FileReader getFluxSour() {
	return fluxSour;
}

public void setFluxSour(FileReader fluxSour) {
	this.fluxSour = fluxSour;
}


public void initMotsCles() 
{
	this.motsCles.add(new Symboles(Tokens.PROGRAM_TOKEN,"Program"));
	this.motsCles.add(new Symboles(Tokens.CONST_TOKEN,"const"));
	this.motsCles.add(new Symboles(Tokens.BEGIN_TOKEN,"Begin"));
	this.motsCles.add(new Symboles(Tokens.END_TOKEN,"End"));
	this.motsCles.add(new Symboles(Tokens.VAR_TOKEN,"Var"));
	this.motsCles.add(new Symboles(Tokens.IF_TOKEN,"If"));
	this.motsCles.add(new Symboles(Tokens.THEN_TOKEN,"then"));
	this.motsCles.add(new Symboles(Tokens.WHILE_TOKEN,"while"));
	this.motsCles.add(new Symboles(Tokens.DO_TOKEN,"do"));
	this.motsCles.add(new Symboles(Tokens.WRITE_TOKEN,"write"));
	this.motsCles.add(new Symboles(Tokens.READ_TOKEN,"read"));

}

public void codageLex() {
	String nom1=symbCour.getNom();
	for(Symboles symb:motsCles) {
		String nom2=symb.getNom();
		if(nom1.equalsIgnoreCase(nom2)) {
			symbCour.setToken(symb.getToken());
			return;
		}
	}
	symbCour.setToken(Tokens.ID_TOKEN);
}


//public void CodageLex(String m) 
//{
//    for(Symboles i:this.motsCles)
//    {
//    	if(i.getNom().equals(m)) 
//    	{
//    		 i.getToken();
//    		 return;
//    	}
//    }
//    
//     this.symbCour.setToken(Tokens.ID_TOKEN); 
//
//}

//public void Lire_Car(String f) throws IOException 
//{	
////	File fr = new File(f);
////	this.fluxSour = new FileReader(fr);
//	BufferedReader br = new BufferedReader(this.fluxSour);
//	boolean b = br.ready();	
//	List<Character> list = new ArrayList<Character>();
//	while(b) {
//          list.add((char)br.read());
//          b = br.ready();
//	}
//	
//	try
//	{
//		if(list.contains(this.carCour)) {
//		System.out.println("Found it");
//		}
//	}
//	catch(EOFException oef) {
//		System.out.println("End of File Reached");
//	}
//}

//	if(list.contains(this.carCour)) {
//        System.out.println("Found it");
//	}
//	else {
//		System.out.print(this.EOF);  //EOF => means End Of file; => donc il s'agit d'une exception.
//	}



//public void Lire_Car2(String f) 
//{
//	DataInputStream inputStream = null;
//	File fr = new File(f);
//	
//	try {
//		inputStream = new DataInputStream(new FileInputStream(f));
//		while(true) {
//			try {
//				inputStream.readChar();
//			}
//			catch(EOFException ioe) {
//				System.out.println("End of file reached");
//				break;
//			}catch(IOException ioe) {
//				ioe.printStackTrace();
//			}
//		}
//	}catch(IOException ioe) {
//        ioe.printStackTrace();
//    } finally {
//        try {
//            inputStream.close();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }	
//}

//public void lireNombre() throws IOException 
//{
//	BufferedReader br = new BufferedReader(this.fluxSour);
//	boolean b = br.ready();
//	int Num1;
//	List<Integer> Num2 = new ArrayList<Integer>();
//	while(b) {
//		Num1 = (int)br.read();
//		Num2.add((int)br.read());
//		b = br.ready();
//	}
//}
//
//public void lireMot() throws IOException 
//{
//	BufferedReader br = new BufferedReader(this.fluxSour);
//	boolean b = br.ready();
//	char id;
//	if(this.motsCles.contains(this.symbCour)) {
//		
//	}
//	
//}


public void lireCar() throws IOException {
	if (fluxSour.ready())
		carCour=(char)fluxSour.read();
	else
		carCour=EOF;
}

public void lireMot() throws IOException {
	symbCour.setNom(symbCour.getNom()+carCour);
	lireCar();
	while(Character.isLetterOrDigit(carCour)) {
		symbCour.setNom(symbCour.getNom()+carCour);
		lireCar();
	}
	codageLex();
}

public void lireNombre() throws IOException {
	symbCour.setNom(symbCour.getNom()+carCour);
	lireCar();
	while(Character.isDigit(carCour)) {
		symbCour.setNom(symbCour.getNom()+carCour);
		lireCar();
	}
	symbCour.setToken(Tokens.NUM_TOKEN);
}

public void symbSuiv() throws IOException, ErreurCompilation {
	symbCour=new Symboles();
	while(Character.isWhitespace(carCour))
		lireCar();
	if (Character.isLetter(carCour)) {
		lireMot();
		return;
	}
	if(Character.isDigit(carCour)) {
		lireNombre();
		return;
	}
	switch(carCour) {
	case '+':
		symbCour.setToken(Tokens.PLUS_TOKEN);
		lireCar();
		break;
	case '-':
		symbCour.setToken(Tokens.MOINS_TOKEN);
		lireCar();
		break;
	case '*':
		symbCour.setToken(Tokens.MUL_TOKEN);
		lireCar();
		break;
	case '/':
		symbCour.setToken(Tokens.DIV_TOKEN);
		lireCar();
		break;
	case '(':
		symbCour.setToken(Tokens.PARG_TOKEN);
		lireCar();
		break;
	case ')':
		symbCour.setToken(Tokens.PARD_TOKEN);
		lireCar();
		break;
	case '.':
		symbCour.setToken(Tokens.PNT_TOKEN);
		lireCar();
		break;
	case ',':
		symbCour.setToken(Tokens.VIR_TOKEN);
		lireCar();
		break;
	case ';':
		symbCour.setToken(Tokens.PVIR_TOKEN);
		lireCar();
		break;
	case '=':
		symbCour.setToken(Tokens.EG_TOKEN);
		lireCar();
		break;
	case EOF:
		symbCour.setToken(Tokens.EOF_TOKEN);
		break;
	case ':':
		lireCar();
		switch(carCour) {
		case '=':
			symbCour.setToken(Tokens.AFFEC_TOKEN);
			lireCar();
			break;
		default:
			symbCour.setToken(Tokens.ERR_TOKEN);
			throw new ErreurLexicale(CodesErr.CAR_INC_ERR);
		}
		break;
	case '>':
		lireCar();
		switch(carCour) {
		case '=':
			symbCour.setToken(Tokens.SUPEG_TOKEN);
			lireCar();
			break;
		default:
			symbCour.setToken(Tokens.SUP_TOKEN);
			break;
		}
		break;
	case '<':
		lireCar();
		switch(carCour) {
		case '=':
			symbCour.setToken(Tokens.INFEG_TOKEN);
			lireCar();
			break;
		case '>':
			symbCour.setToken(Tokens.DIFF_TOKEN);
			lireCar();
			break;
		default:
			symbCour.setToken(Tokens.INF_TOKEN);
			break;
		}
		break;
	default:
		throw new ErreurLexicale(CodesErr.CAR_INC_ERR);
	}
	
		
}

public static void main(String args[]) 
	throws Exception {
	Scanner scanner=new Scanner("/Users/mac/Othmane.txt");
	scanner.initMotsCles();
	scanner.lireCar();
	while(scanner.getCarCour()!=EOF) {
		scanner.symbSuiv();
		System.out.println(scanner.getSymbCour().getToken());
	}
}

}




