import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class TransactionAnalyzer
{
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static double calculateTotalBalance(
            List<Transaction> transactions)
    {
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
    public static int countTransactionsByMonth(
            List<Transaction> transactions,
            String monthYear)
    {
        int count = 0;

        for (Transaction transaction : transactions)
        {
            LocalDate date =
                    LocalDate.parse(
                            transaction.getDate(),
                            formatter);

            String currentMonth =
                    date.format(
                            DateTimeFormatter.ofPattern("MM-yyyy"));

            if (currentMonth.equals(monthYear))
            {
                count++;
            }
        }

        return count;
    }
    public static List<Transaction> findTopExpenses(
            List<Transaction> transactions)
    {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static Transaction findBiggestExpense(
            List<Transaction> transactions)
    {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .min(Comparator.comparing(Transaction::getAmount))
                .orElse(null);
    }

    public static Transaction findSmallestExpense(
            List<Transaction> transactions)
    {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .max(Comparator.comparing(Transaction::getAmount))
                .orElse(null);
    }

    public static Map<String, Double> getExpensesByCategory(
            List<Transaction> transactions)
    {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(
                        Transaction::getDescription,
                        Collectors.summingDouble(Transaction::getAmount)
                ));
    }
    public static Map<String, Double> getExpensesByMonth(
            List<Transaction> transactions)
    {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .collect(Collectors.groupingBy(
                        transaction ->
                        {
                            LocalDate date =
                                    LocalDate.parse(
                                            transaction.getDate(),
                                            formatter);

                            return date.format(
                                    DateTimeFormatter.ofPattern("MM-yyyy"));
                        },
                        Collectors.summingDouble(
                                Transaction::getAmount)
                ));
    }
}