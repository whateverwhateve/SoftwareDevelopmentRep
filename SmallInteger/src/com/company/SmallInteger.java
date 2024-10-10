package com.company;

/**
 * This is a SmallInteger class to work with integer numbers with an absolute value < 10^4
 */
public class SmallInteger extends Number implements Comparable<SmallInteger> {

    /**
     * field of sign of a number
     */
    final int signum;
    /**
     * field of magnitude of a number
     */
    final int mag;
    /**
     * field of max possible magnitude of a number
     */

    final int MAX_MAG = 100000;


    final int MIN_MAG = 0;

    /**
     * Constructor creates new object from a String value
     *
     * @param val string value of a number
     * @throws SmallIntegerException if value of a number is above the limit
     */
    public SmallInteger(String val) throws SmallIntegerException {
        int intVal = Integer.parseInt(val);
        if (Math.abs(intVal) > MAX_MAG)
            throw new SmallIntegerException("Absolute value is bigger than 10^4", intVal);

        if (intVal > 0) {
            signum = 1;
            mag = intVal;
        }
        else if (intVal < 0) {
            signum = -1;
            mag = Math.abs(intVal);
        } else {
            signum = 0;
            mag = 0;
        }
    }

    /**
     * Constructor creates new object from an int value
     *
     * @param val string value of a number
     * @throws SmallIntegerException if value of a number is above the limit
     */
    public SmallInteger(int val) throws SmallIntegerException {
        if (Math.abs(val) > MAX_MAG)
            throw new SmallIntegerException("Absolute value is bigger than 10^4", val);

        if (val > 0) {
            signum = 1;
            mag = val;
        }
        else if (val < 0) {
            signum = -1;
            mag = Math.abs(val);
        } else {
            signum = 0;
            mag = 0;
        }
    }

    /**
     * Method of sum operation between two SmallInteger values
     * Adds the second SmallInteger value to the first SmallInteger value
     *
     * @param val the second SmallInteger operand
     * @return the result of operation
     * @throws SmallIntegerException if result of operation is above the limit
     */
    public SmallInteger add(SmallInteger val) throws SmallIntegerException {
        int result = this.intValue() + val.intValue();
        return new SmallInteger(result);
    }

    /**
     * Method of subtract operation between two SmallInteger values
     * Subtracts the second SmallInteger value from the first SmallInteger value
     *
     * @param val the second SmallInteger value
     * @return the result of operation
     * @throws SmallIntegerException if result of operation is above the limit
     */
    public SmallInteger subtract(SmallInteger val) throws SmallIntegerException {
        int result = this.intValue() - val.intValue();
        return new SmallInteger(result);
    }

    /**
     * Method of multiplication operation between two SmallInteger values
     * Multiply the second SmallInteger value to the first SmallInteger value
     *
     * @param val the second SmallInteger value
     * @return the result of operation
     * @throws SmallIntegerException if result of operation is above the limit
     */
    public SmallInteger multiply(SmallInteger val) throws SmallIntegerException {
        int result = this.intValue() * val.intValue();
        return new SmallInteger(result);
    }

    /**
     * Method of division operation between two SmallInteger values
     * Divides the first SmallInteger value on the second SmallInteger value
     *
     * @param val the second SmallInteger value
     * @return the result of operation
     * @throws SmallIntegerException if result of operation is above the limit
     */
    public SmallInteger divide(SmallInteger val) throws SmallIntegerException {
        int result = this.intValue() / val.intValue();
        return new SmallInteger(result);
    }

    /**
     * Method of converting SmallInteger value into a String value
     *
     * @return String type of a SmallInteger number
     */
    public String toString() {
        String negative = "";
        if (signum == -1) negative = "-";
        return negative.concat(String.valueOf(mag));
    }

    /**
     * Method of comparing two SmallInteger values
     *
     * @param val the second SmallInteger value
     * @return 1 if first number is bigger then the second one, -1 otherwise, 0 if its equal
     */
    @Override
    public int compareTo(SmallInteger val) {
        if (signum == val.signum) {
            return switch (signum) {
                case 1  -> (mag < val.mag) ? -1 : 1;
                case -1 -> (mag > val.mag) ? -1 : 1;
                default -> 0;
            };
        }
        return signum > val.signum ? 1 : -1;
    }

    @Override
    public int intValue() {
        return mag * signum;
    }

    @Override
    public long longValue() {
        return mag * signum;
    }

    @Override
    public float floatValue() {
        return mag * signum;
    }

    @Override
    public double doubleValue() {
        return mag * signum;
    }
}

/**
 * SmallIntegerException class to throw exceptions and to show the values
 */
class SmallIntegerException extends Exception {

    private final int number;
    public int getNumber() {return number;}
    public SmallIntegerException(String message, int num){

        super(message);
        number=num;
    }
}
