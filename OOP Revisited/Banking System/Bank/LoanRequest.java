package Bank;

public class LoanRequest<Account> {
    private Account requester;
    private double loanAmount;

    public LoanRequest(Account requester, double loanAmount) {
        this.requester = requester;
        this.loanAmount = loanAmount;
    }

    public Account getRequester() {
        return requester;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
}
