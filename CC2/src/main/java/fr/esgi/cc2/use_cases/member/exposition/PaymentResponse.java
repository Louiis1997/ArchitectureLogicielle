package fr.esgi.cc2.use_cases.member.exposition;

public class PaymentResponse {
    public final String lastPayment;

    public PaymentResponse(String lastPayment){
        this.lastPayment = lastPayment;
    }

    @Override
    public String toString(){
        return "LastPayment{'" + lastPayment + "'}";
    }
}
