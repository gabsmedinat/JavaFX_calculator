package application;

public class Calculatrice {
		public enum Operation{
			Vide,
			Addition,
			Soustraction,
			Multiplication,
			Division
		}

		
//	public Calculatrice(, Operation op) {
//		this.valeur1 = val1;
//		this.valeur2 = val2;
//		this.op = op;
//	}
//	
	public static float calculer(float val1, float val2, Operation typeCalcul) {
		float resultat = 0;
		switch(typeCalcul) {
		case Vide:
			resultat = 0;
			break;
		case Addition:
			resultat = val1 + val2;
			break;
		case Soustraction:
			resultat = val1 - val2;
			break;
		case Multiplication:
			resultat = val1 * val2;
			break;
		case Division:
			resultat = val1 / val2;
			break;
		}
		return resultat;
	}

}
