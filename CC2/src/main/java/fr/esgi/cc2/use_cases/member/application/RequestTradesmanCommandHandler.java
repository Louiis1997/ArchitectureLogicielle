package fr.esgi.cc2.use_cases.member.application;

import fr.esgi.cc2.kernel.CommandHandler;
import fr.esgi.cc2.use_cases.member.domain.Tradesman;

public class RequestTradesmanCommandHandler implements CommandHandler<RequestTradesman, Tradesman> {

    @Override
    public Tradesman handle(RequestTradesman command) {
        return null;
    }
}
