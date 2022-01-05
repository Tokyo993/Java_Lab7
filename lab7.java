package com.company;

/**
 * The basic integrator class to integrate functions
 * @author Masyukevych Nikita
 */
abstract class FunctionIntegrator{

    /**
     * Constant 1
     */
    private double c1;

    /**
     * Constant 2
     */
    private double c2;

    /**
     * Constructor
     * @param c1 constant 1
     * @param c2 constant 2
     */
    FunctionIntegrator(double c1, double c2){
        this.c1 = c1;
        this.c2 = c2;
    }


    /**
     * The function to integrate (not implemented)
     * @param x the x of function
     * @return the function value
     * @throws Exception the exception that might occur
     */
    public abstract double function(double x) throws Exception;

    // getters and setters

    /**
     * Getter for constant 1
     * @return the value of constant 1
     */
    public double getC1(){
        return c1;
    }

    /**
     * Setter for constant 1
     * @param c1 constant 1 value
     */
    public void setC1(double c1){
       this.c1 = c1;
    }

    /**
     * getter for constant 2
     * @return the value of constant 2
     */
    public double getC2(){
        return c2;
    }

    /**
     * Setter for constant 2
     * @param c2 constant 2 value
     */
    public void setC2(double c2){
        this.c2 = c2;
    }

    /**
     * The integration function, using the Simpson's Rule
     * @see <a href="https://en.wikipedia.org/wiki/Simpson%27s_rule">See more about the Simpson's Rule</a>
     * @param a the lower limit
     * @param b the upper limit
     * @param n the number of components
     * @return the integration result
     * @throws Exception an exception which might occur
     */
    public double integrateSimpson(double a, double b, int n) throws Exception{
        double result;
        if (n == 0){
            throw new Exception("n cannot be 0");
        }
        try {
            double delta = (b-a) / n;
            double sn = delta / 3;
            double sum = 0;
            int c = 1;
            for (double i = a; i <= b; i += delta){
                if (i != a && i != b){
                    if (c == 2) {
                        c = 4;
                    } else {
                        c = 2;
                    }
                } else c = 1;
                sum += c * function(i);
            }
            result = sn * sum;
        } catch (Exception e){
            throw e;
        }
        return result;
    }

    /**
     * The integration function, using the Rectangular method
     * @see <a href="http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/07/rectangle-method.html">See more about the Rectangular Method</a>
     * @param a the lower limit
     * @param b the upper limit
     * @param n the number of components
     * @return the integration result
     * @throws Exception an exception which might occur
     */
    public double integrateRectangle(double a, double b, int n) throws Exception{
        if (n == 0){
            throw new Exception("n cannot be 0");
        }
        double result = 0;
        try {
            double delta = (b-a) / n;
            for (double i = a; i < b; i += delta){
                double midpoint = (i + i+delta) / 2;
                result += delta * function(i);
            }
        } catch (Exception e){
            throw e;
        }
        return result;
    }

    /**
     * The integration function, using the Trapezoidal Rule
     * @see <a href="https://en.wikipedia.org/wiki/Trapezoidal_rule">See more about the Trapezoidal Rule</a>
     * @param a the lower limit
     * @param b the upper limit
     * @param n the number of components
     * @return the integration result
     * @throws Exception an exception which might occur
     */
    public double integrateTrapezoid(double a, double b, int n) throws Exception{
        if (n == 0){
            throw new Exception("n cannot be 0");
        }
        double result = 0;
        try {
            double delta = (b-a) / n;
            double tn = delta / 2;
            double sum = 0;
            int c;
            for (double i = a; i <= b; i += delta){
                if (i != a && i != b){
                        c = 2;
                } else c = 1;
                sum += c * function(i);
            }
            result = tn * sum;
        } catch (Exception e){
            throw e;
        }
        return result;
    }
}

// Derived class

/**
 * Derived class for function 1 implementation
 * @author Masyukevych Nikita
 * @version 1.0
 */
class Fun1 extends FunctionIntegrator{
    /**
     * Function constructor
     * @param c1 constant 1
     * @param c2 constant 2
     */
    Fun1(double c1, double c2){
        super(c1, c2);
    }

    //define the function to integrate

    /**
     * Function to integrate
     * @param x the x of function
     * @return the value of the function
     */
    public double function(double x) {
        return Math.pow(x, 2) * Math.pow((getC1() - x), 3) + getC2();
    }
}

// Derived class

/**
 * Derived class for function 2 implementation
 * @author Masyukevych Nikita
 * @version 1.0
 */
class Fun2 extends FunctionIntegrator{
    /**
     * Function constructor
     * @param c1 constant 1
     * @param c2 constant 2
     */
    Fun2(double c1, double c2){
        super(c1, c2);
    }

    // define the function to integrate

    /**
     * Function to integrate
     * @param x the x of function
     * @return the value of the function
     * @throws Exception an exception which might occur
     */
    public double function(double x) throws Exception {
        double argumentOfSQRT= getC1() - Math.pow(x, 2);
        double denominator = Math.pow(x, 3) + getC2();
        if (argumentOfSQRT < 0 || denominator == 0) {
            throw new Exception("The arguments are not valid for this function");
        }
        return (Math.sqrt(argumentOfSQRT))/(denominator);
    }
}

// Derived class

/**
 * Derived class for function 3 implementation
 * @author Masyukevych Nikita
 * @version 1.0
 */
class Fun3 extends FunctionIntegrator{
    /**
     * Function constructor
     * @param c1 constant 1
     * @param c2 constant 2
     */
    Fun3(double c1, double c2){
        super(c1, c2);
    }

    // define the function to integrate

    /**
     * Function to integrate
     * @param x the x of function
     * @return the value of the function
     * @throws Exception an exception which might occur
     */
    public double function(double x) throws Exception{
        double denominator = getC2() + Math.pow(x, 2);
        if (denominator == 0) {
            throw new Exception("The arguments are not valid for this function");
        }
            return (getC1() + Math.pow(Math.E, x))/(denominator);
    }
}

public class Main {

    public static void main(String[] args) {

        // crete new functions and set coefficients
        Fun1 fun1 = new Fun1(1,4);
        Fun2 fun2 = new Fun2(10,20);
        Fun3 fun3 = new Fun3(1,6);

        // define the Function Integrator
        FunctionIntegrator functionToIntegrate;

        // assign the function class to integrate
        functionToIntegrate = fun1;
        try {
            // integrate using one of the methods of the Integrator class
            System.out.println(functionToIntegrate.integrateSimpson(1,5,500));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(functionToIntegrate.integrateRectangle(1,5,500));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(functionToIntegrate.integrateTrapezoid(1,5,500));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        functionToIntegrate = fun2;
        try {
            System.out.println(functionToIntegrate.integrateSimpson(1,2,50));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(functionToIntegrate.integrateRectangle(1,2,50));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(functionToIntegrate.integrateTrapezoid(1,2,50));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        functionToIntegrate = fun3;
        try {
            System.out.println(functionToIntegrate.integrateSimpson(1,2,100));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(functionToIntegrate.integrateRectangle(1,2,100));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(functionToIntegrate.integrateTrapezoid(1,2,100));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
