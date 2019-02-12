import java.util.Random;
import java.util.Scanner;

public class LottoGame {

	public static void main(String[] args) {
		
		String [] chyslaKorusyvacha = otrymatyVvedennja();
		
		int Ispivpadinnja = 0;
		int kilkistRozigrashiv = 0;
		
		while (Ispivpadinnja != 6){ 
		
			kilkistRozigrashiv++;
		
			int [] rozigrash = otrymatyChysla();
			Ispivpadinnja = spivpadinnja (chyslaKorusyvacha, rozigrash);
		
		if (Ispivpadinnja > 4){
			
		String vsiChyslaText = vygrashniStr (rozigrash);

		System.out.println("Виграшні числа: " + vsiChyslaText);
		System.out.println("Співпало: " + Ispivpadinnja);
		System.out.println("Тираж №" + kilkistRozigrashiv);
		}
		}
	}

	public static String[] otrymatyVvedennja (){
	
		Scanner sc = new Scanner (System.in);
		System.out.println("Введіть 6 чисел від 1 - 50 через кому: ");
		String chysla = sc.nextLine();
		
		String [] enteredArray = chysla.split(", ");
		
		return enteredArray;
	}	

	
	public static int [] otrymatyChysla (){
		int [] randomArray = new int [6];
		Random r = new Random();
		int chysloRozigrashy = 0;
		
		while (chysloRozigrashy != 6){
			boolean chysloVzheIsnyje = false;
			int chysloTyrazhy = r.nextInt(50+1);
			
			for (int isnyjeChyslo: randomArray){
				if (isnyjeChyslo == chysloTyrazhy){
					chysloVzheIsnyje = true;
					break;
				}
			}
				if (chysloVzheIsnyje != true){
					randomArray [chysloRozigrashy++] = chysloTyrazhy;
				}
		}
	
		return randomArray;
	}	
		
	
	public static int spivpadinnja (String [] enteredArray, int [] randomArray){
		int kilkistSpivpadin = 0;
		
		for (int k = 0; k<enteredArray.length; k++){
			int chyslo = Integer.parseInt(enteredArray[k]);
			
			for (int tseVygrashneChyslo: randomArray){
				if (tseVygrashneChyslo == chyslo){
					kilkistSpivpadin++;
				}
			}
		}
		return kilkistSpivpadin;
		
	}
		
		
	public static String vygrashniStr (int [] randomArray){	
		String vsiChyslaRozigrashy = "";
		for (int i: randomArray){
			vsiChyslaRozigrashy = vsiChyslaRozigrashy + i + ", ";
		}
		
		return vsiChyslaRozigrashy;
	}
}
