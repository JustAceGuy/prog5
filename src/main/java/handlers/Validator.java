package handlers;

public class Validator<T extends Comparable> {
    private T lowerBound, upperBound;
    private boolean isNullable = false;

    public Validator<T> nullable() {
        this.isNullable = true;
        return this;
    }

    public Validator<T> upper(T bound) {
        this.upperBound = bound;

        return this;
    }

    public Validator<T> lower(T bound) {
        this.lowerBound = bound;
        return this;
    }

    String request(String typ, String name) {
        String request = "Input " + name + " [" + typ; //huge костыль, fix pls
        if (!isNullable || upperBound != null || lowerBound != null) {
            if (!isNullable) { request += " | Cannot be null "; }
            if (lowerBound != null) { request += "| >" + lowerBound.toString() + " "; }
            if (upperBound != null) { request += "| <" + upperBound.toString() + " "; }
        }
        request = request.stripTrailing() + "]";
        return request + "\n>>> ";
    }

    boolean validate(T val) {
        if (val == null && isNullable) { return true; }
        else if (val == null) { return false; }
        else if (upperBound != null && (val.compareTo(upperBound) >= 0)) { return false; }
        else if (lowerBound != null && (val.compareTo(lowerBound) <= 0)) { return false; }
        return true;
    }

}
