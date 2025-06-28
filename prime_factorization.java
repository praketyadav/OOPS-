import java.util.ArrayList;
import java.util.List;

// Abstract base class
abstract class MathOperation {
    protected int number;

    public MathOperation(int number) {
        this.number = number;
    }

    public abstract void solve();
}

// Concrete class for Prime Factorization (Inheritance + Polymorphism)
class PrimeFactorization extends MathOperation {

    public PrimeFactorization(int number) {
        super(number);
    }

    @Override
    public void solve() {
        System.out.println("Prime factors of " + number + " are:");
        int n = number;
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);  // n is prime
        }

        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();
    }
}

// Main driver class
public class MathToolbox {
    public static void main(String[] args) {
        PrimeFactorization pf = new PrimeFactorization(84);
        pf.solve();

        PrimeFactorization pf2 = new PrimeFactorization(97); // Prime number
        pf2.solve();
    }
}
