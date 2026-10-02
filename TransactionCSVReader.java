import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class TransactionCSVReader
{
    public static List<Transaction> readTransactions(String filePath)
    {
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(filePath)))
        {
            String line;

            br.readLine();

            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",");

                Transaction transaction =
                        new Transaction(
                                values[0],
                                Double.parseDouble(values[1]),
                                values[2]
                        );

                transactions.add(transaction);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return transactions;
    }
}