package chris.htw.prog2.beleg1;

import chris.htw.prog2.beleg1.utils.ConsoleHelper;

/**
 * Created by Christoph on 16.10.2014.
 */
public class VectorHelper {

    /**
     * Gibt die hoehere Dimension zweier Vektoren zurueck
     *
     * @param a Vektor
     * @param b Vektor
     * @return hoehere Dimension von a oder b
     */
    private int getHigherDimension(Vector a, Vector b){
        return a.getDimension() > b.getDimension() ? a.getDimension() : b.getDimension();
    }

    /**
     * Vergleicht die Werte zweier Vektoren und gibt true zurueck wenn alle Werte identisch sind
     *
     * @param a Vektor
     * @param b Vektor
     * @return true wenn Vektoren gleich sind, sonst falsch
     */
    public boolean compare(Vector a, Vector b){
        int dimension = getHigherDimension(a, b);
        for (int i = 0; i < dimension; i++)
            if(a.get(i) != b.get(i))
                return false;

        return true;
    }

    /**
     * Laesst den Benutzer ueber die Konsole einen Neuen Vektor erstellen.
     *
     * @return vom Benutzer erzeugter Vektor
     */
    public Vector input(){
        int dimension;
        Vector v;
        while (true){
            try{
                System.out.print("Dimension zwischen 1 und " + Vector.MaxDimension + " festlegen:");
                dimension = ConsoleHelper.readIntFromConsole();
                v = new Vector(dimension);

                for (int i = 0; i < dimension; i++) {
                    System.out.println("Wert " + (i + 1) + ":");
                    double value = ConsoleHelper.readDoubleFromConsole();
                    v.set(i, value);
                }

                break;
            } catch (NumberFormatException e){
                System.out.println("ERROR: Wert konnte nicht gelesen werden. Felermeldung=" + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR: Vektor konnte nicht erstellt werden. Felermeldung='" + e.getMessage() + "'");
            }
            System.out.println("try again...");
        }

        System.out.println("");
        return v;
    }

    /**
     * Gibt die Werte eines Vektors in der Konsole aus
     *
     * @param vector Vektor der ausgegeben werden soll
     */
    public void output(Vector vector){
        System.out.println(vector.toString());
    }

    /**
     * Addiert zwei Vektoren
     *
     * @param a Vektor
     * @param b Vektor
     * @return Summe von a und b
     */
    public Vector sum(Vector a, Vector b){
        int dimension = getHigherDimension(a, b);
        Vector c = new Vector(dimension);

        for (int i = 0; i < dimension; i++)
            c.set(i, a.get(i) + b.get(i));

        return c;
    }

    /**
     * Gibt die Differenz zweier Vektoren zurueck.
     * (Addition des Gegenvektors)
     * a - b = a + ( -b ) = c
     *
     * @param a Vektor
     * @param b Vektor
     * @return Differenz von a und b
     */
    public Vector sub(Vector a, Vector b){
        int dimension = getHigherDimension(a, b);
        Vector c = new Vector(dimension);

        for (int i = 0; i < dimension; i++)
            c.set(i, a.get(i) - b.get(i));

        return c;
    }

    /**
     * Gibt den Einheitsvektor eines Vektors aus.
     *
     * @param a Vektor
     * @return Einheitsvektor von a
     */
    public Vector getUnitVector(Vector a){
        Vector e = new Vector(a.getDimension());
        double scalar = getLength(a);

        for (int i = 0; i < a.getDimension(); i++)
            e.set(i, a.get(i) * (1/scalar));

        return e;
    }

    /**
     * Gibt die Laenge eines Vektors aus.
     *
     * @param a Vektor
     * @return Laenge von a
     */
    public double getLength(Vector a){
        double scalar = 0;

        for (int i = 0; i < a.getDimension(); i++)
            scalar += a.get(i) * a.get(i);

        return Math.sqrt(scalar);
    }

    /**
     * Gibt das Skalarprodukt zweier Vektoren zurueck.
     *
     * @param a Vektor
     * @param b Vektor
     * @return Skalarprodukte von a und b
     */
    public double getScalarProdukt(Vector a, Vector b){
        int dimension = getHigherDimension(a, b);
        double scalarProduct = 0;

        for (int i = 0; i < dimension; i++)
            scalarProduct += a.get(i) * b.get(i);

        return scalarProduct;
    }

    /**
     * Gibt das Kreuzprodukt (Vektorprodukt) zweier Vektoren zurueck
     *
     * @param a Vektor
     * @param b Vektor
     * @return Kreuzprodukt von a und b
     */
    public Vector getCrossProdukt(Vector a, Vector b){
        int dimension = getHigherDimension(a, b);
        Vector vp = new Vector(dimension);
        for (int cValue = 0; cValue < dimension; cValue++) {
            // at the end of the loop take the first row, else take the next row
            int index1 = cValue == dimension -1 ? 0 : cValue + 1;
            // at the beginning of the loop take the last row, else take the previous row
            int index2 = cValue == 0 ? dimension -1 : cValue - 1;
            // cross values
            vp.set(cValue, a.get(index1) * b.get(index2) - a.get(index2) * b.get(index1));
        }
        return vp;
    }

    /**
     * Gibt die Determinante dreier Vektoren zurueck
     *
     * @param a Vektor
     * @param b Vektor
     * @param c Vektor
     * @return Determinante von a, b und c
     */
    public double getDeterminant(Vector a, Vector b, Vector c){
        return getScalarProdukt(a, getCrossProdukt(b, c));
    }

}
