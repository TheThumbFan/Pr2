import java.util.List;
import java.util.Map;

public abstract class TransactionReportGenerator
{
    public static void printBalanceReport(double totalBalance)
    {
        System.out.println("\nЗагальний баланс: "
                + totalBalance);
    }
    public static void printTransactionsCountByMonth(
            String monthYear,
            int count) {

        System.out.println(
                "Кількість транзакцій за "
                        + monthYear
                        + ": "
                        + count);
    }
    public static void printTopExpensesReport(
            List<Transaction> expenses)
    {
        System.out.println("\nТОП 10 витрат:");

        for (Transaction transaction : expenses)
        {

            System.out.println(
                    transaction.getDescription()
                            + " : "
                            + transaction.getAmount());
        }
    }
    public static void printCategoryReport(
            Map<String, Double> report)
    {
        System.out.println("\nВитрати по категоріях:");

        report.forEach((key, value) ->
        {
            int stars =
                    ((int) Math.abs(value)) / 1000;
            System.out.println(
                    key
                            + " "
                            + "*".repeat(Math.max(1, stars))
                            + " "
                            + value);
        });
    }
    public static void printMonthlyReport(
            Map<String, Double> report)
    {
        System.out.println("\nВитрати по місяцях:");

        report.forEach((key, value) ->
        {
            int stars =
                    ((int) Math.abs(value)) / 1000;

            System.out.println(
                    key
                            + " "
                            + "*".repeat(Math.max(1, stars))
                            + " "
                            + value);
        });
    }
}