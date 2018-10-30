package pl.edu.agh.iisg.to.javafx.cw3.command;

import pl.edu.agh.iisg.to.javafx.cw3.model.Account;
import pl.edu.agh.iisg.to.javafx.cw3.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DeleteTransactionCommand implements Command {

    private List<Transaction> transactionsToDelete;
    private Account account;

    public DeleteTransactionCommand(List<Transaction> transactionsToDelete, Account account) {
        this.transactionsToDelete = new ArrayList<>(transactionsToDelete);
        this.account = account;
    }
    @Override
    public void execute() {
        account.getTransactions().removeAll(transactionsToDelete);
    }

    @Override
    public void undo() {
        account.getTransactions().addAll(transactionsToDelete);
    }

    @Override
    public void redo() {
        account.getTransactions().removeAll(transactionsToDelete);
    }

    @Override
    public String getName() {
        String name = "";
        for(Transaction transaction : transactionsToDelete) {
            name += "Deleted transaction: " + transaction.toString() + "\n";
        }
        return name;
    }
}
