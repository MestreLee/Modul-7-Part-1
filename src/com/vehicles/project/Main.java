package com.vehicles.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int triarVehicle(int triaVehicle) {
		int tria = triaVehicle;
		Boolean bool =  false;
		while (tria !=0 && tria != 1){
			Scanner Obj0 = new Scanner(System.in);
			if (!bool) {
				System.out.println("Escriu 0 per cotxe i 1 per moto:");
			}
			try {
				tria = Obj0.nextInt();
				bool =  false;
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				Obj0.nextLine();
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte! escriu 0 per cotxe o 1 per moto:");
				 bool =  true;
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 Obj0.nextLine();
			 }
		}
		return tria;
	}
	
	static double comprovarDiametre(double diametre){
		double diam = diametre;
		boolean bool = false;
		while (diam < 0.4 || diam > 4) {
			Scanner Obj1 = new Scanner(System.in);
			if (!bool) {
				System.out.println("Diàmetre incorrecte! Ha de ser més gran de 0.4 i més petit de 4:");
			}
			try {
				diam = Obj1.nextDouble();
				bool = false;
			}catch (InputMismatchException e) {
				System.out.println("Format incorrecte! escriu un número entre el 0,4 i el 4:");
				bool = true;
			}		  
		}
	    return diam;
	}
	static boolean comprovarMatricula(String matricula){
		boolean bool = true;
		String str = matricula;
		if (str.length() > 7 || str.length() < 6) {
			System.out.println("La matrícula no pot tenir més de 7 ni menys de 6 caracters!");
	    	bool = false;
	    }
		int i = 0;
		while (i < str.length() && bool == true) {
			Boolean flag = Character.isDigit(str.charAt(i));
	    	if (i < 4) {
	    		if(!flag) {
	    			System.out.println("Els primers 4 caracters han de ser dígits!");
	    			bool = false;
		        }
	    	}else{
	    		if(flag) {
	    			System.out.println("Els últims caracters han de ser lletres!");
	    			bool = false;
		        }
	    	} 
	    	
	    	i++;
		}    	
		return bool;
	}

	public static void main(String[] args) {
		//Preguntem a l'usuari si vol crear un cotxe o una moto
		Scanner myObj = new Scanner(System.in);
		System.out.println("Vols crear un cotxe (0) o una moto (1) ?");
		int triaVehicle = 5; //Número random que no sigui 0 ni 1
		while (triaVehicle !=0 && triaVehicle != 1){
			try {
				triaVehicle = myObj.nextInt();
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				myObj.nextLine();
				triaVehicle = triarVehicle(triaVehicle);
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte! escriu 0 per cotxe i 1 per moto:");
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 myObj.nextLine();
			 }
		}		 
		
		//Demanem a l'usuari que introdueixi la matrícula, la marca i el color del vehicle
		
		System.out.println("Introdueix la matrícula del vehicle:");
		String matriculaVehicle = myObj.nextLine();
		Boolean bool =  false;		
		while(!bool) {
			bool = comprovarMatricula(matriculaVehicle);
			if (!bool) {
				System.out.println("Introdueix la matrícula del vehicle:");
				matriculaVehicle = myObj.nextLine();
			}
		}
		
		System.out.println("Introdueix la marca del vehicle:");
		String marcaVehicle = myObj.nextLine();
		System.out.println("Introdueix el color del vehicle:");
		String colorVehicle = myObj.nextLine();

		/*if (triaVehicle == 0) {
			Car cotxe = new Car(matriculaVehicle, marcaVehicle, colorVehicle);
		} else {
			Bike moto = new Bike(matriculaVehicle, marcaVehicle, colorVehicle);
		}*/
		
	
		//Demanem a l'usuari la marca i el diàmetre de les rodes del darrere
		double diametreRodaDarrere = 0;
		double diametreRodaDavant = 0;
		System.out.println("Introdueix la marca de la roda del darrere:");
		String marcaRodaDarrere = myObj.nextLine();
		System.out.println("Introdueix el diàmetre de la roda del darrere:");
		
		bool = false;
		
		while (!bool){
			try {
				diametreRodaDarrere = myObj.nextDouble();
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				myObj.nextLine();
				comprovarDiametre(diametreRodaDarrere);
				bool = true;
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte! escriu un número entre el 0,4 i el 4:");
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 myObj.nextLine();
			 }
		}		 
		 
		Wheel rodaDarrere = new Wheel (marcaRodaDarrere, diametreRodaDarrere);
				
		System.out.println("Introdueix la marca de la roda del davant:");
		String marcaRodaDavant = myObj.nextLine();
		System.out.println("Introdueix el diàmetre de la roda del davant:");
		
        bool = false;
		
		while (!bool){
			try {
				diametreRodaDavant = myObj.nextDouble();
				//Llegim la new-line que causa problemes amb l'scanner si no es fa:
				myObj.nextLine();
				comprovarDiametre(diametreRodaDavant);
				bool = true;
			 }catch (InputMismatchException e) {
				 System.out.println("Format incorrecte! escriu un número entre el 0,4 i el 4:");
				 //Llegim la new-line que causa problemes amb l'scanner si no es fa:
				 myObj.nextLine();
			 }
		}		 
		
		Wheel rodaDavant = new Wheel (marcaRodaDavant, diametreRodaDavant);
		
		if (triaVehicle == 0) {
			Car cotxe = new Car(matriculaVehicle, marcaVehicle, colorVehicle);
			List<Wheel> rodesDarrere = new ArrayList<Wheel>();
			rodesDarrere.add(rodaDarrere);
			rodesDarrere.add(rodaDarrere);	
			List<Wheel> rodesDavant = new ArrayList<Wheel>();
			rodesDavant.add(rodaDavant);
			rodesDavant.add(rodaDavant);
			//cotxe.addWheels(rodesDarrere, rodesDavant);
			
			try {
				cotxe.addWheels(rodesDarrere, rodesDavant);
			}catch(Exception x) {
				System.out.print(x.getMessage());
			}
			
			System.out.print(cotxe.toString());
		}else {
			Bike moto = new Bike(matriculaVehicle, marcaVehicle, colorVehicle);
			//moto.addWheels(rodaDarrere, rodaDavant);
			
			try {
				moto.addWheels(rodaDarrere, rodaDavant);
			}catch(Exception x) {
				System.out.print(x.getMessage());
			}
			
			System.out.print(moto.toString());
			
		}
		
	}

}
