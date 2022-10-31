package formatif2;

import java.util.Scanner;

public class SimpleCallBack {
    public static void main(String[] args) {

        SimpleCallBack app = new SimpleCallBack();

        //appelle de tous les types de call back
        //avec classe externe
        app.afficheCallBack(new ClasseExterne());

        //avec classe anonyme

        app.afficheCallBack(new Methode1() {
            @Override
            public String fait(String val) {
                return "méthode normale de ClasseExterne " + val;
            }
        });

        // avec closure
        app.afficheCallBack((String val) ->
                "méthode normale de ClasseExterne " + val
        );

        //avec l'opérateur de référence :: sur la méthode dooda de L'objet app

        app.afficheCallBack(app::dooda);

        //avec l'opérateur de référence sur la méthode static staticDooda
        app.afficheCallBack(SimpleCallBack::staticDooda);

        // manipulation de référence avec callback

        Methode1 anonyme = new Methode1() {
            @Override
            public String fait(String val) {
                return "méthode normale de ClasseExterne " + val;
            }
        };

        Methode1 closure = (String val) -> "méthode normale de ClasseExterne " + val;

        Methode1 dooda = app::dooda;


        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez un type 1,2 ou 3");
        int choix = scanner.nextInt();

        //on affiche le bon choix
        Methode1 methode1 = null;
        switch (choix) {
            case 1:
                methode1 = anonyme;
                break;
            case 2:
                methode1 = closure;
                break;
            case 3:
                methode1 = dooda;
                break;

            default:
                System.out.println("Choix inexistant");
        }
        //on appelle afficheCallBack avec le callback choisi
        app.afficheCallBack(methode1);

    }

    public void afficheCallBack(Methode1 callback) {
        System.out.println(callback.fait("Allo!"));
    }

    public String dooda(String param) {
        return "Méthode normale de SimpleCallBack " + param;
    }

    public static String staticDooda(String param) {
        return "Méthode statique de SimpleCallBack " + param;
    }

    public interface Methode1 {
        String fait(String val);
    }
}
