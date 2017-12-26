import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Random;

public class Math
{
    public static void main(String[] args)
    {
        // 统计
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        Random random = new Random();

        for (int i = 0; i < 10000; i++)
        {
            descriptiveStatistics.addValue(random.nextInt(1000));
        }

        System.out.println("几何平均数:" + descriptiveStatistics.getGeometricMean());
        System.out.println("峰度:" + descriptiveStatistics.getKurtosis());
        System.out.println("最大值:" + descriptiveStatistics.getMax());
        System.out.println("最小值:" + descriptiveStatistics.getMin());
        System.out.println("算数平均数:" + descriptiveStatistics.getMean());
        System.out.println("元素个数:" + descriptiveStatistics.getN());
        System.out.println("p分位数:" + descriptiveStatistics.getPercentile(0.5));
        System.out.println("偏度:" + descriptiveStatistics.getSkewness());
        System.out.println("标准差:" + descriptiveStatistics.getStandardDeviation());
        System.out.println("和:" + descriptiveStatistics.getSum());
        System.out.println("平方和:" + descriptiveStatistics.getSumsq());
        System.out.println("方差:" + descriptiveStatistics.getVariance());

        // Frequency
        System.out.println("Frequency:");

        Frequency frequency = new Frequency();
        for (int i = 0; i < 10000; i++)
        {
            frequency.addValue(random.nextInt(100));
        }

        for (int i = 0; i < 100; i++)
        {
            for (long j = 0; j < frequency.getCount(i); j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
