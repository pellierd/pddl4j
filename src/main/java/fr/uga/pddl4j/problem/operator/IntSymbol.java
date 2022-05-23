package fr.uga.pddl4j.problem.operator;

import fr.uga.pddl4j.parser.Symbol;

import java.util.Objects;

public class IntSymbol implements Symbol, Comparable<IntSymbol> {

    /**
     * The integer used to represent teh symbol.
     */
    private Integer value;

    /**
     * The constructor is private to break the inheritance from object.
     */
    private IntSymbol() {
        super();
    }

    /**
     * Creates a new IntSymbol with a specified value.
     *
     * @param value the value of the symbol.
     */
    public IntSymbol(final Integer value) {
        this.value = value;
    }

    /**
     * Creates a new IntSymbol with a specified image.
     *
     * @param image the image of the symbol.
     */
    public IntSymbol(final String image) {
        this.value = Integer.valueOf(image);
    }

    /**
     * Creates from a other IntSymbol. This constructor creates a deep copy of the object in paramater.
     *
     * @param other the other object.
     */
    public IntSymbol(final IntSymbol other) {
        this(other.getValue());
    }

    /**
     * Returns the int value of the symbol.
     *
     * @return the int value of the symbol.
     */
    public final Integer getValue() {
        return this.value;
    }

    /**
     * Sets the int value of the symbol.
     *
     * @param value the value to set.
     */
    public final void setValue(final Integer value) {
        this.value = value;
    }

    /**
     * Returns the image of the symbol.
     *
     * @return the image of the symbol.
     */
    public final String getImage() {
        return this.toString();
    }
    /**
     * Returns a deep copy of this IntSymbol.
     *
     * @return a deep copy of this IntSymbol.
     */
    public IntSymbol clone() {
        return new IntSymbol(this);
    }

    /**
     * Returns if this symbol is equals to an other object. This method returns <code>true</code> if the object in
     * parameter has the same class as IntSymbol and has the same value.
     *
     * @param object the object to compared.
     * @return This method returns <code>true</code> if the object in parameter has the same class as IntSymbol and has
     *      the same value; <code>false</code> otherwise.
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object != null && object instanceof IntSymbol) {
            IntSymbol other = (IntSymbol) object;
            return Objects.equals(this.getValue(), other.getValue());
        }
        return false;
    }

    /**
     * Returns the hash code value of the symbol.
     *
     * @return the hash code value of the symbol.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getValue());
    }

    /**
     * Compares the symbol to another symbol.
     *
     * @param other the other symbol to be compared.
     * @return the numeric distance between this symbol and the symbol in pararameter.
     */
    @Override
    public int compareTo(final IntSymbol other) {
        return this.getValue().compareTo(other.getValue());
    }

    /**
     * Returns a string representation of this symbol.
     *
     * @return a string representation of this symbol.
     */
    public String toString() {
        return this.getValue().toString();
    }


}
