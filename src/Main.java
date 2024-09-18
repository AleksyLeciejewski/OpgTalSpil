import java.lang.runtime.SwitchBootstraps;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        do {
            startSpil();
            //Gemmer begrænsningen for det generede tal
            int maxNumb = diff();

            //Overfører værdien af maxNumb til gaet metoden
            gaet(maxNumb);
        }while(spilIgen());

        }

    public static void startSpil(){
        System.out.println("Velkommen til spillet Gæt et tal");

        System.out.println("Vælg en sværhedsgrad for dit næste spil: ");
        System.out.println("1. Let: 1-10");
        System.out.println("2. Mellem 1-50");
        System.out.println("3. Svær 1-100");
    }
        //Metode 'void' anvendes kun, når der ikke sendes data retur
    public static int diff() {
        int maxNumb = 0;
        Scanner diff = new Scanner(System.in);
        int difficulty = diff.nextInt();


        if (difficulty == 1) {
            System.out.println("Jeg har tænkt på et tal mellem 1 og 10, kan du gætte det?");
            maxNumb = 10;
        } else if (difficulty == 2) {
            System.out.println("Jeg har tænkt på et tal mellem 1 og 50, kan du gætte det?");
            maxNumb = 50;
        } else if (difficulty == 3) {
            System.out.println("Jeg har tænkt på et tal mellem 1 og 100, kan du gætte det?");
            maxNumb = 100;
        }
        return maxNumb;
    }
        //Ved at anvende maxNumb ved metodens variabel afgrænsede vi maksimum til det generede tal
    public static boolean gaet(int maxNumb) {
        Scanner guess = new Scanner(System.in);
        Random random = new Random();
        int tal = random.nextInt(maxNumb) + 1; // +1 skal tilføjes, da komputere altid operer fra 0

        while (true) {

            System.out.println("Angiv dit gæt: ");

            int svar = guess.nextInt();

            if (tal == svar) {
                System.out.println("Dit gæt er korrekt!");
                return true;
            } else if (tal > svar) {
                System.out.println("Dit gæt er for lavt");
            } else if (tal < svar) {
                System.out.println("Dit gæt er for højt");
            }

        }

    }
        // Ja/Nej cases fungerede ikke før de blev skrevet med småt pga. .toLowerCase. Forstår ikke, hvorfor.
    public static boolean spilIgen() {
        Scanner gentag = new Scanner(System.in);
        System.out.println("Vil du spille igen? (Ja/Nej)");
        String svar2 = gentag.next().toLowerCase();
        switch(svar2){
            case "ja":
                return true;
            case "nej":
                return false;
            default:
                System.out.println("Ugyldigt svar");
                return false;
        }
    }
}