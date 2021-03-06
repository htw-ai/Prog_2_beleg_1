package chris.htw.prog2.beleg1;

/**
 * Created by Christoph on 16.10.2014.
 */
public class Vector {

    public static int MaxDimension = 6;
    double[] vector;

    public Vector(int dimension) {
        if(dimension > MaxDimension)
            throw new IllegalArgumentException("max. Dimension ist " + MaxDimension);
        else if(dimension < 1)
            throw new IllegalArgumentException("min. Dimension ist 1");

        vector = new double[dimension];
    }

    /**
     * Gibt einen Achsenwert des Vektors zurueck (sehr fehlertolerant)
     *
     * @param index Indexposition im Vektor
     * @return Indexwert
     */
    public double get(int index){
        try {
            return vector[index];
        }catch (ArrayIndexOutOfBoundsException e){
            // It's not necessary to reinit the vector with a higher dimension.
            // reinitializeVector(index + 1);
            return 0;
        }
    }

    /**
     * Setzt einen Achsenwert des Vektors (sehr fehlertolerant)
     *
     * @param index Indexposition im Vektor
     * @param value Wert der gesetzt werden soll
     */
    public void set(int index, double value){
        try {
            vector[index] = value;
        } catch (ArrayIndexOutOfBoundsException e){
            reinitializeVector(index + 1);
            vector[index] = value;
        }
    }

    /**
     * Reinitialisiert den Vektor mit einer neuen Dimension, dabei bleiben die alten Achsenwerte erhalten
     *
     * @param dimension Dimension des neuen Arrays
     */
    private void reinitializeVector(int dimension){
        double[] newVector = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            try {
                newVector[i] = vector[i];
            } catch (ArrayIndexOutOfBoundsException e){
                newVector[i] = 0;
            }
        }
        vector = newVector;
    }

    /**
     * Gibt die Dimension des Vektor zurueck
     *
     * @return Dimension
     */
    public int getDimension(){
        return vector.length;
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer("[ ");

        for (double d : vector)
            output.append(d + ", ");

        // removing the last ','
        output.deleteCharAt(output.length() - 2);
        output.append("]");

        return output.toString();
    }
}
