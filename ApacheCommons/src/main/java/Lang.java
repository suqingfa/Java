import org.apache.commons.lang3.math.Fraction;

public class Lang
{
    public static void main(String[] args)
    {
        // Fraction 分数
        Fraction fraction = Fraction.getReducedFraction(3, -9);
        fraction = fraction.pow(3);
        System.out.println(fraction);
        System.out.println(fraction.invert());
    }
}
