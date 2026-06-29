public class FinancialForecast {

    static double forecast(
            double amount,
            double growthRate,
            int years) {

        if (years == 0) {
            return amount;
        }

        return forecast(
                amount * (1 + growthRate),
                growthRate,
                years - 1);
    }

    public static void main(String[] args) {

        double initialAmount = 100000;

        double annualGrowth = 0.10;

        int years = 5;

        double result =
                forecast(
                        initialAmount,
                        annualGrowth,
                        years);

        System.out.println(
                "Future Value after "
                        + years
                        + " years = ₹"
                        + result);
    }
}