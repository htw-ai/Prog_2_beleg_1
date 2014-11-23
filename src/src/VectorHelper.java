import utils.ConsoleHelper;

/**
 * Created by Christoph on 16.10.2014.
 */
public class VectorHelper {

    /**
     * gibt die hoehere Dimension zweier Vektoren zurueck
     *
     * @param a
     * @param b
     * @return
     */
    private int getHigherDimension(Vector a, Vector b){
        return a.getDimension() > b.getDimension() ? a.getDimension() : b.getDimension();
    }

    /**
     * Vergleicht die Werte zweier Vektoren und gibt true zurueck wenn alle Werte identisch sind
     *
     * @return
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
     * @return
     */
    public Vector input(){
        System.out.print("Dimension zwischen 1 und " + Vector.MaxDimension + ":");
        int dimension = ConsoleHelper.readIntFromConsole();
        Vector v = new Vector(dimension);

        for (int i = 0; i < dimension; i++) {
            System.out.println("Wert " + (i + 1) + ":");
            double value = ConsoleHelper.readDoubleFromConsole();
            v.set(i, value);
        }

        System.out.println("");

        return v;
    }

    /**
     * gibt die Werte eines Vektors in der Konsole aus
     *
     * @param vector
     */
    public void output(Vector vector){
        System.out.println(vector.toString());
    }

    /**
     * addiert zwei Vektoren
     *
     * @param a
     * @param b
     * @return
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
     * @param a
     * @param b
     * @return
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
     * @param a
     * @return
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
     * @param a
     * @return
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
     * @param a
     * @param b
     * @return
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
     * @param a
     * @param b
     * @return
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
     * @param a
     * @param b
     * @param c
     * @return
     */
    public double getDeterminant(Vector a, Vector b, Vector c){
        return getScalarProdukt(a, getCrossProdukt(b, c));
    }

}
