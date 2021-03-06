package chris.htw.prog2.beleg1;

import chris.htw.prog2.beleg1.utils.ConsoleHelper;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Christoph on 16.10.2014.
 */
public class start {
    private static VectorHelper vectorHelper;

    private static Map<String, Vector> vectors = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Programmieren II - Belegarbeit I");
        System.out.println("--------------------------------");
        System.out.println("");

        vectorHelper = new VectorHelper();
        initVectors();

        System.out.println("");
        System.out.println("Testing:");
        System.out.println("--------");
        System.out.println("Test 'UnitVector' returned : " + testUnitVector());
        System.out.println("Test 'ScalarProduct' returned : " + testScalarProduct());
        System.out.println("Test 'CrossProdukt' returned : " + testCrossProduct());
        System.out.println("Test 'Determinant' returned : " + testDeterminant());

//        ConsoleHelper.clearConsole();
        showMainMenu();
    }

    /**
     * initialisiert die drei default Testvektoren
     *
     */
    private static void initVectors() {
        System.out.println("initialize default vectors ['a', 'b', 'c']...");
        Vector a = new Vector(3);
        Vector b = new Vector(3);
        Vector c = new Vector(3);

        a.set(0, -4);
        a.set(1, 5);
        a.set(2, 9);

        b.set(0, 2.5);
        b.set(1, 6);
        b.set(2, 10);

        c.set(0, 3);
        c.set(1, 4);
        c.set(2, -9);

        vectors.put("a", a);
        vectors.put("b", b);
        vectors.put("c", c);
    }

    private static boolean testUnitVector() {
        System.out.println("");
        System.out.println("Calculate unit vector:");

        double length = vectorHelper.getLength(vectors.get("b"));
        Vector comparer = new Vector(3);
        Vector b = vectors.get("b");

        int i = 0;
        comparer.set(i, b.get(i++) / length);
        comparer.set(i, b.get(i++) / length);
        comparer.set(i, b.get(i) / length);


        Vector unitVector = vectorHelper.getUnitVector(vectors.get("b"));
        System.out.print("vector 'b': ");
        vectorHelper.output(b);
        System.out.print("result: ");
        vectorHelper.output(unitVector);

        return vectorHelper.compare(unitVector, comparer);
    }

    private static boolean testScalarProduct() {
        System.out.println("");
        System.out.println("Calculate scalar product of 'c' and 'b':");
        Vector c = vectors.get("c");
        System.out.print("vector 'c': ");
        vectorHelper.output(c);
        Vector b = vectors.get("b");
        System.out.print("vector 'b': ");
        vectorHelper.output(b);

        double scalarProduct = vectorHelper.getScalarProdukt(c, b);
        System.out.println("result: " + scalarProduct);

        return scalarProduct == -58.5;
    }

    private static boolean testCrossProduct() {
        System.out.println("");
        System.out.println("Calculate cross product of 'c' and 'a':");
        Vector c = vectors.get("c");
        System.out.print("vector 'c': ");
        vectorHelper.output(c);
        Vector a = vectors.get("a");
        System.out.print("vector 'a': ");
        vectorHelper.output(a);

        Vector comparer = new Vector(3);
        comparer.set(0, 81);
        comparer.set(1, 9);
        comparer.set(2, 31);

        Vector crossProduct = vectorHelper.getCrossProdukt(c, a);
        System.out.println("result: ");
        vectorHelper.output(crossProduct);
        return vectorHelper.compare(crossProduct, comparer);
    }

    private static boolean testDeterminant() {
        System.out.println("");
        System.out.println("Calculate determinant of 'a', 'b' and 'c':");
        System.out.println("a: " + vectors.get("a").toString() + ", b: " + vectors.get("b").toString() + ", c: " + vectors.get("c").toString());

        double result = vectorHelper.getDeterminant(vectors.get("a"), vectors.get("b"), vectors.get("c"));
        System.out.println("result: " + result);

        return result == 566.5;
    }

    private static void showMainMenu() {
        String input;

        do {
            System.out.println("");
            System.out.println("Hauptmenue:");
            System.out.println("-----------");
            System.out.println(" 1) Vektoren verwalten");
            System.out.println(" 2) Summe");
            System.out.println(" 3) Differenz");
            System.out.println(" 4) Skalarprodukt");
            System.out.println(" 5) Einheitsvektor");
            System.out.println(" 6) Laenge eines Vektors");
            System.out.println(" 7) Vektorprodukt");
            System.out.println(" 8) Determinante (Spatprodukt) (n=3)");
            System.out.println("10) Beenden");

            input = ConsoleHelper.readFromConsole();
            Vector v1, v2, v3;

            try{

                switch (input) {
                    case "1":
                        showVectorsAdministration();
                        break;
                    case "2":
                        System.out.println("Welche Vektoren sollen addiert werden?");
                        v1 = getVectorByUser();
                        v2 = getVectorByUser();
                        System.out.println("Ergebnis: ");
                        vectorHelper.output(vectorHelper.sum(v1, v2));
                        break;
                    case "3":
                        System.out.println("Welche Vektoren sollen subtrahiert werden?");
                        v1 = getVectorByUser();
                        v2 = getVectorByUser();
                        System.out.println("Ergebnis: ");
                        vectorHelper.output(vectorHelper.sub(v1, v2));
                        break;
                    case "4":
                        System.out.println("Skalarprodukt welcher Vektoren?");
                        v1 = getVectorByUser();
                        v2 = getVectorByUser();
                        System.out.print("Ergebnis: ");
                        System.out.println(vectorHelper.getScalarProdukt(v1, v2));
                        break;
                    case "5":
                        System.out.println("Einheitsvektor welches Vektors?");
                        v1 = getVectorByUser();
                        System.out.print("Ergebnis: ");
                        vectorHelper.output(vectorHelper.getUnitVector(v1));
                        break;
                    case "6":
                        System.out.println("Laenge welchen Vektors?");
                        v1 = getVectorByUser();
                        System.out.print("Ergebnis: ");
                        System.out.println(vectorHelper.getLength(v1));
                        break;
                    case "7":
                        System.out.println("Vektorprodukt welcher Vektoren?");
                        v1 = getVectorByUser();
                        v2 = getVectorByUser();
                        System.out.print("Ergebnis: ");
                        vectorHelper.output(vectorHelper.getCrossProdukt(v1, v2));
                        break;
                    case "8":
                        System.out.println("Determinante welcher Vektoren? (n=3)");
                        v1 = getVectorByUser();
                        v2 = getVectorByUser();
                        v3 = getVectorByUser();
                        System.out.print("Ergebnis: ");
                        System.out.println(vectorHelper.getDeterminant(v1, v2, v3));
                        break;
                    case "10":
                        System.out.println("Good bye :)");
                        break;
                    default:
                        System.out.println("Fehlerhafte Eingabe! Bitte erneut versuchen");
                        break;
                }
            } catch (UserInputException e){
                // do nothing, just show the main menu again...
            }

        } while (!input.equals("10"));
    }

    private static void showVectorsAdministration() {
        String input;

        do {
            System.out.println("Vektorenverwaltung:");
            System.out.println("-------------------");
            System.out.println("");
            System.out.println("aktuell definierte Vektoren:");
            for (Map.Entry<String, Vector> vEntry : vectors.entrySet()) {
                System.out.print(vEntry.getKey() + ": ");
                vectorHelper.output(vEntry.getValue());
            }
            System.out.println("");
            System.out.println(" 1) Hinzufuegen / Bearbeiten");
            System.out.println(" 2) Loeschen");
            System.out.println(" 3) Vektoren zuruecksetzen");
            System.out.println("10) Abbrechen");

            input = ConsoleHelper.readFromConsole();
            String subInput;
            switch (input) {
                case "1":
                    System.out.print("Name des Vektors:");
                    subInput = ConsoleHelper.readFromConsole();
                    Vector v = vectorHelper.input();
                    vectors.put(subInput, v);
                    break;
                case "2":
                    System.out.print("Welcher Vektor soll geloescht werden?");
                    subInput = ConsoleHelper.readFromConsole();
                    vectors.remove(subInput);
                    break;
                case "3":
                    System.out.print("Vektoren wirklich zuruecksetzen? (j/n)");
                    subInput = ConsoleHelper.readFromConsole();
                    if (subInput.toLowerCase(Locale.ROOT).startsWith("j")) {
                        vectors.clear();
                        initVectors();
                    }
                    break;
                case "10":
                    break;
                default:
                    System.out.println("Fehlerhafte Eingabe! Bitte erneut versuchen");
                    break;
            }
        } while (!input.equals("10"));
    }

    private static Vector getVectorByUser() throws UserInputException {
        while (true) {
            try{
                System.out.print("Vektorname: ");
                String vName = ConsoleHelper.readFromConsole();
                if (!vectors.containsKey(vName)){
                    System.out.println(vName + " ist kein definierter Vektor. Geben sie einen gueltigen Namen ein");
                    continue;
                }
                return vectors.get(vName);
            } catch (Exception e) {
                System.out.println("ERROR: Vektor konnte nicht gefunden werden. Fehlermeldung=" + e.getMessage());
                throw new UserInputException();
            }
        }
    }

}
