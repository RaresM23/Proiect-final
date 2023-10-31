package src.pricipal.proiect_final;

import javax.swing.JOptionPane;

public class PetShop {

    private static String usernameCorect = "rares";
    private static String parolaCorecta = "123456";

    public static void main(String[] args) {

        Meniu meniulMeu = new Meniu();

        while (true) {
            int optiune = afisareMeniu();

            if (optiune == 1) {
                if (signIn(usernameCorect, parolaCorecta)) {
                    JOptionPane.showMessageDialog(null, "Autentificare reușită! Programul poate continua.");
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Autentificare eșuată! Încercați din nou.");
                }
            } else if (optiune == 2) {
                createAccount();
            } else {
                JOptionPane.showMessageDialog(null, "Opțiune invalidă. Încercați din nou.");
            }
        }
    }

    // Funcția de Log In
    private static boolean signIn(String usernameCorect, String parolaCorecta) {
        String username = JOptionPane.showInputDialog("Introduceți username:");
        String parola = JOptionPane.showInputDialog("Introduceți parola:");

        return username != null && parola != null && username.equals(usernameCorect) && parola.equals(parolaCorecta);
    }

    // Funcția de Creare Cont Nou
    private static void createAccount() {
        String usernameNou = JOptionPane.showInputDialog("Introduceți un nou username:");
        String parolaNoua = JOptionPane.showInputDialog("Introduceți o nouă parolă:");

        if (usernameNou != null && parolaNoua != null) {
            usernameCorect = usernameNou;
            parolaCorecta = parolaNoua;
            JOptionPane.showMessageDialog(null, "Cont creat cu succes!");
        } else {
            JOptionPane.showMessageDialog(null, "Crearea contului a eșuat. Asigurați-vă că ați introdus username și parolă valide.");
        }
    }

    // Funcție pentru afișarea meniului
    private static int afisareMeniu() {
        String[] optiuni = {"Log-in", "Creare Cont Nou"};
        int optiuneSelectata = JOptionPane.showOptionDialog(
                null,
                "Alegeți o opțiune:",
                "Log-in",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                optiuni,
                optiuni[0]
        );
        return optiuneSelectata + 1;
    }
}