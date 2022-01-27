package lr7;

public class lr7 {

    public static void main(String[] args) {
    /*
	A a = new A(); // object of type A
    B b = new B(); // object of type B
    C c = new C(); // object of type C
    A r; // obtain a reference of type A
    r = a; // r refers to an A object
    r.callme(); // calls A's version of callme
    r = b; // r refers to a B object
    r.callme(); // calls B's version of callme
    r = c; // r refers to a C object
    r.callme(); // calls C's version of callme
    */

    /*
    Figure f = new Figure(10, 10);
    Rectangle r1 = new Rectangle(9, 5);
    Triangle t = new Triangle(10, 8);
    Figure figref;
    figref = r1;
    System.out.println("Area is " + figref.area());
    figref = t;
    System.out.println("Area is " + figref.area());
    figref = f;
    System.out.println("Area is " + figref.area());
    */

    /*
    B b = new B();
    b.callme();
    b.callmetoo();
    */

    /*
    //Figure f = new Figure(2, 2); // недопустимое объявление Figure
    Rectangle r = new Rectangle(9, 5);
    Triangle t = new Triangle(10, 8);
    Figure figref; // допустимое объявление, но объект не создается
    figref = r;
    System.out.println("Area is " + figref.area());
    figref = t;
    System.out.println("Area is " + figref.area());
    */

	/*
    First a = new First(1, 5);
    System.out.println(a.rectangle(0, 5, 1000));
    System.out.println(a.trapezoid(0, 5, 1000));
    System.out.println(a.Sympson(0, 5, 1000));

    Second b = new Second(1, 5);
    System.out.println(b.rectangle(-5, -0, 100));
    System.out.println(b.trapezoid(-5, -0, 100));
    System.out.println(b.Sympson(-5, -0, 100));

    Third c = new Third(1, 5);
    System.out.println(c.rectangle(0, 5, 1000));
    System.out.println(c.trapezoid(0, 5, 1000));
    System.out.println(c.Sympson(0, 5, 1000));
    */
        FunctionIntegral z;
        First a = new First(1, 5);
        z=a;
        System.out.println(z.rectangle(0, 5, 1000));
        System.out.println(z.trapezoid(0, 5, 1000));
        System.out.println(z.Sympson(0, 5, 1000));

        Second b = new Second(1, 5);
        z=b;
        System.out.println(z.rectangle(-5, -1, 100));
        System.out.println(z.trapezoid(-5, -1, 100));
        System.out.println(z.Sympson(-5, -1, 100));

        Third c = new Third(1, 5);
        z=c;
        System.out.println(z.rectangle(0, 5, 1000));
        System.out.println(z.trapezoid(0, 5, 1000));
        System.out.println(z.Sympson(0, 5, 1000));

    }

}

package lr7;


/**
 * Класс First служит для вычисления определенного интеграла
 * функции Math.pow(a, 3)/(c1+Math.pow(a, 2)) + c2
 * @author Никита
 */
public class First extends FunctionIntegral{

    /**
     *
     * @param a первая числовая константа
     * @param b вторая числовая константа
     */
    public First(double a, double b){
        super(a, b);
    }

    public double rectangle(double a, double b, int n) {
        double area=0;
        double h = Math.abs((b-a)/n); //считаем размер одного шага
        double[] f = new double[n]; //значения ф-и

        for(int i=0; i<n; i++) {
            f[i] = Math.pow(a, 3)/(c1+Math.pow(a, 2)) + c2; //считатаем значения
            a+=h; //увеличиваем "а" по шагу
        }

        for(double s : f) { //сумма площадей прямоугольников
            area+=h*s; //площадь = высота * значение ф-и
            //h - x, f - y
        }
        return area;
    }

    public double trapezoid(double a, double b, int n) {
        double area=0;
        double h = Math.abs((b-a)/n); //считаем размер одного шага
        double[] f = new double[n+1]; //значения ф-и

        for(int i=0; i<n+1; i++) {
            f[i] = Math.pow(a, 3)/(c1+Math.pow(a, 2)) + c2 ;  //значение счётчика
            a+=h; //увеличить "а" на шаг
        }
        area+=(f[0]+f[n])/2;
        for(int i=1; i<n; i++) area+=f[i];
        area*=h;
        return area;
    }

    public double Sympson(double a, double b, int n) {
        double area=0;
        if(n%2!=0) n++;
        double h = Math.abs((b-a)/n); //считаем размер одного шага
        double[] f = new double[n]; //значения ф-и

        for(int i=0; i<n; i++) {
            f[i] = Math.pow(a, 3)/(c1+Math.pow(a, 2)) + c2; //значения счётчика
            a+=h; //increase a by step
        }
        area+=(f[0]+f[n-1])/2;
        for(int i=1; i<n-1; i++) {
            if(i%2==0) area+=4*f[i];
            else area+=2*f[i];
        }
        area*=h/3;
        return area;
    }
}



package lr7;

/**
 * Класс Second  для вычисления определенного интеграла
 *  ф-и c1/(Math.sqrt(a)*(c2+ Math.pow(a,2)));
 * @author Никита
 *
 */
public class Second extends FunctionIntegral{

    /**
     *
     * @param a первая числовая константа
     * @param b вторая числовая константа
     */
    public Second(double a, double b){
        super(a, b);
    }

    public double rectangle(double a, double b, int n) {
        double area=0;
        double h = Math.abs((b-a)/n); //посчитать размер шага
        double[] f = new double[n]; //значение ф-и

        for(int i=0; i<n; i++) {
            f[i] = c1/(Math.sqrt(a)*(c2+ Math.pow(a,2))); //посчитать значения
            a+=h; //увеличиваем "а" по шагу
        }

        for(double s : f) { //сумма площадей прямоугольников
            area+=h*s; //площадь = высота * значение ф-и
            //h - x, f - y
        }

        return area;
    }

    public double trapezoid(double a, double b, int n) {
        double area=0;
        double h = Math.abs((b-a)/n); //посчитать размер шага
        double[] f = new double[n+1]; //значение ф-и

        for(int i=0; i<n+1; i++) {
            f[i] = c1/(Math.sqrt(a)*(c2+ Math.pow(a,2)));  //посчитать значения
            a+=h; //увеличиваем "а" по шагу
        }
        area+=(f[0]+f[n])/2;
        for(int i=1; i<n; i++) area+=f[i];
        area*=h;
        return area;
    }

    public double Sympson(double a, double b, int n) {
        double area=0;
        if(n%2!=0) n++;
        double h = Math.abs((b-a)/n); //посчитать размер шага
        double[] f = new double[n]; //значение ф-и

        for(int i=0; i<n; i++) {
            f[i] = c1/(Math.sqrt(a)*(c2+ Math.pow(a,2)));  //посчитать значения
            a+=h; //увеличиваем "а" по шагу
        }
        area+=(f[0]+f[n-1])/2;
        for(int i=1; i<n-1; i++) {
            if(i%2==0) area+=4*f[i];
            else area+=2*f[i];
        }
        area*=h/3;
        return area;
    }
}


package lr7;

/**
 * Класс Third служит для вычисления определенного интеграла
 * функции Math.sqrt(Math.pow(Math.exp(1),2))+c1
 * @author Никита
 *
 */
public class Third extends FunctionIntegral{

    /**
     *
     * @param a первая числовая константа
     * @param b вторая числовая константа
     */
    public Third(double a, double b){
        super(a, b);
    }

    public double rectangle(double a, double b, int n) {
        double area=0;
        double h = Math.abs((b-a)/n); //посчитать размер шага
        double[] f = new double[n]; //значение ф-и

        for(int i=0; i<n; i++) {
            f[i] = Math.sqrt(Math.pow(Math.exp(1),2))+c1; //посчитать значения
            a+=h; //увеличиваем "а" по шагу
        }

        for(double s : f) { //сумма площадей прямоугольников
            area+=h*s; // площадь = высота * значение ф-и
            //h - x, f - y
        }

        return area;
    }

    public double trapezoid(double a, double b, int n) {
        double area=0;
        double h = Math.abs((b-a)/n); //посчитать размер шага
        double[] f = new double[n+1]; //значение ф-и

        for(int i=0; i<n+1; i++) {
            f[i] = Math.sqrt(Math.pow(Math.exp(1),2))+c1; //посчитать значения
            a+=h; //увеличиваем "а" по шагу
        }
        area+=(f[0]+f[n])/2;
        for(int i=1; i<n; i++) area+=f[i];
        area*=h;
        return area;
    }

    public double Sympson(double a, double b, int n) {
        double area=0;
        if(n%2!=0) n++;
        double h = Math.abs((b-a)/n); //посчитать размер шага
        double[] f = new double[n]; //значение ф-и

        for(int i=0; i<n; i++) {
            f[i] = Math.sqrt(Math.pow(Math.exp(1),2))+c1; //посчитать значения
            a+=h; //увеличиваем "а" по шагу
        }
        area+=(f[0]+f[n-1])/2;
        for(int i=1; i<n-1; i++) {
            if(i%2==0) area+=4*f[i];
            else area+=2*f[i];
        }
        area*=h/3;
        return area;
    }
}



package lr7;

//Пример демонстрации использования абстрактного класса
abstract class A {
    abstract void callme();
    //конкретный метод может оставаться доступным в абстрактном классе
    void callmetoo() {
        System.out.println("This is a concrete method.");
    }
}
class B extends A {
    void callme() {
        System.out.println("B's implementation of callme.");
    }
}
class AbstractDemo {
    public static void main(String args[]) {
        B b = new B();
        b.callme();
        b.callmetoo();
    }
}



package lr7;

//Абстрактный класс с абстрактным методом вычисления площади
abstract class Figure {
    double dim1;
    double dim2;
    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }
    // Это абстрактный метод
    abstract double area();
}
class Rectangle extends Figure {
    Rectangle(double a, double b) {
        super(a, b);
    }
    // Реализация абстрактного метода для четырехугольника
    double area() {
        System.out.println("Inside Area for Rectangle.");
        return dim1 * dim2;
    }
}
class Triangle extends Figure {
    Triangle(double a, double b) {
        super(a, b);
    }
    // Реализация абстрактного метода для прямоугольного треугольника
    double area() {
        System.out.println("Inside Area for Triangle.");
        return dim1 * dim2 / 2;
    }
}
class DemoAreas {
    public static void main(String args[]) {
// Figure f = new Figure(2, 2); // недопустимое объявление Figure
        Rectangle r = new Rectangle(9, 5);
        Triangle t = new Triangle(10, 8);

        Figure figref; // допустимое объявление, но объект не создается
        figref = r;
        System.out.println("Area is " + figref.area());

        figref = t;
        System.out.println("Area is " + figref.area());
    }
}




package lr7;

/**
 * Абстрактный класс FunctionIntegral служит интерфейсом для
 * наследующих его классов, которые нужны для вычисления интегралов 3-мя способами
 * @author Никита
 *
 */
public abstract class FunctionIntegral {

    /**
     * Первая числовая константа
     */
    public double c1;

    /**
     * Вторая числовая константа
     */
    public double c2;

    /**
     * Создает объект класса
     * @param a первая числовая константа
     * @param b вторая числовая константа
     */
    public FunctionIntegral(double a, double b){
        c1=a;
        c2=b;
    }

    /**
     * Вычисляет значение определенного интеграла методом прямоугольников
     *
     * @param a  нижняя граница интеграла
     * @param b  верхняя граница интеграла
     * @param n количество разбиений (точность вычисления, больше число - тем точнее расчёт)
     * @return значение определённого интеграла
     */
    public abstract double rectangle(double a, double b, int n);

    /**
     * Вычисляет значение определенного интеграла методом трапеций
     * @param a нижняя граница интеграла
     * @param b верхняя граница интеграла
     * @param n количество разбиений
     * @return значение определённого интеграла
     */
    public abstract double trapezoid(double a, double b, int n);

    /**
     * Вычисляет значение определенного интеграла методом Симпсона
     * @param a нижняя граница интеграла
     * @param b верхняя граница интеграла
     * @param n количество разбиений
     * @return значение определённого интеграла
     */
    public abstract double Sympson(double a, double b, int n);
}

