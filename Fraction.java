public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() {
    }

    public Fraction(int int1, int int2) {
        this.numerator = int1;
        this.denominator = int2;
        errorCheck();
    }

    public Fraction(String frac) {
        int slashIndex = frac.indexOf("/");
        if (slashIndex>0){
            String n = frac.substring(0, slashIndex);
            String d = frac.substring(slashIndex+1);
            this.numerator = Integer.parseInt(n);
            int D = Integer.parseInt(d);
            if (D ==0){
                System.out.println("Error");
                D=1;
            }
            this.denominator = D;
        } else {
            System.out.println("Invalid"); //Invalid fraction format
            this.numerator =1;
            this.denominator=1;
        }
    }



    public Fraction(Fraction f) {
        this.numerator = f.numerator;
        this.denominator = f.denominator;
    }

    public int getNum() {
        return this.numerator;
    }

    public int getDenom() {
        return this.denominator;
    }

    public String toString() {
        return this.getNum() + "/" + this.getDenom();
    }

    public double toDouble() {
        return 1.0*this.numerator/this.denominator;
    }

    public void reduce() {
        int GCF = GCF(this.numerator, this.denominator);

        this.numerator /= GCF;
        this.denominator /= GCF;

        if (this.numerator < 0 && this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }

        if (this.numerator > 0 && this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }

    }

    public void setNum(int num) {
        this.numerator = num;
    }

    public void setDenom(int denom) {
        this.denominator = denom;
        errorCheck();
    }

    public static Fraction multiply(Fraction first, Fraction second) {
        int newNum = first.getNum() * second.getNum();
        int newDenom = first.getDenom() * second.getDenom();

        Fraction result = new Fraction(newNum, newDenom);
        result.reduce();
        return result;

    }

    public static Fraction divide(Fraction first, Fraction second) {
        int newNum = first.getNum() * second.getDenom();
        int newDenom = first.getDenom() * second.getNum();

        Fraction result = new Fraction(newNum, newDenom);
        result.reduce();
        return result;
    }

    public static Fraction add(Fraction first, Fraction second) {
        int newDenom = first.getDenom() * second.getDenom();
        int newFirstNum = first.getNum()*second.getDenom();
        int newSecondNum = second.getNum()*first.getDenom();

        Fraction result = new Fraction((newFirstNum+newSecondNum), newDenom);
        result.reduce();
        return result;
    }

    public static Fraction subtract(Fraction first, Fraction second) {
        int newDenom = first.getDenom() * second.getDenom();
        int newFirstNum = first.getNum()*second.getDenom();
        int newSecondNum = second.getNum()*first.getDenom();

        Fraction result = new Fraction((newFirstNum-newSecondNum), newDenom);
        result.reduce();
        return result;
    }

    private int GCF(int first, int second) {
        first = Math.abs(first);
        second = Math.abs(second);

        while (first != second) {
            if (first > second) {
                first -= second;
            } else if (first < second) {
                second -= first;
            }
        }

        return first;
    }


    public void errorCheck() {
        if (this.denominator == 0) {
            System.out.println("Error, denominator has been changed to 1");
            this.denominator = 1;
        }
    }



















}
