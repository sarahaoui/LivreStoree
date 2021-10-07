package DAO;

import java.util.List;

import Metier.entities.Livre;


public class Test {

	public static void main(String[] args) {
		InterfaceImplDAO imp = new InterfaceImplDAO();
		
		
        List<Livre> livres= imp.LivresparMC("sparql");
		
		for(Livre p :livres) {
			System.out.println(p.toString());
		}

	}

}
