package fr.esgi.projet.use_cases.addMember.exposition;

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
