package fr.esgi.cc2.use_cases.member.exposition;

public class EmailResponse {
    public String email;

    public EmailResponse(String email){
        if(!email.matches(".+@.+\\.[a-z]+"))
            throw new IllegalArgumentException("You must provide a valid email.");
        this.email = email;
    }

    @Override
    public String toString(){
        return "Email{'" + email + "'}";
    }
}
