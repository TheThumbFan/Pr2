import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        String filePath = "pr2.csv";

        List<Transaction> transactions =
                TransactionCSVReader.readTransactions(filePath);

        double totalBalance =
                TransactionAnalyzer
                        .calculateTotalBalance(transactions);

        TransactionReportGenerator
                .printBalanceReport(totalBalance);

        String monthYear = "01-2024";

        int count =
                TransactionAnalyzer
                        .countTransactionsByMonth(
                                transactions,
                                monthYear);

        TransactionReportGenerator
                .printTransactionsCountByMonth(
                        monthYear,
                        count);

        TransactionReportGenerator
                .printTopExpensesReport(
                        TransactionAnalyzer
                                .findTopExpenses(transactions));

        TransactionReportGenerator
                .printCategoryReport(
                        TransactionAnalyzer
                                .getExpensesByCategory(
                                        transactions));

        TransactionReportGenerator
                .printMonthlyReport(
                        TransactionAnalyzer
                                .getExpensesByMonth(
                                        transactions));

        System.out.println("\nНайбільша витрата:");

        System.out.println(
                TransactionAnalyzer
                        .findBiggestExpense(transactions));

        System.out.println("\nНайменша витрата:");

        System.out.println(
                TransactionAnalyzer
                        .findSmallestExpense(transactions));
    }
}