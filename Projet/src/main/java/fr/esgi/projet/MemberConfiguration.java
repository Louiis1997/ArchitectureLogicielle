package fr.esgi.projet;

import fr.esgi.projet.kernel.*;
import fr.esgi.projet.use_cases.addMember.application.*;
import fr.esgi.projet.use_cases.addMember.domain.MemberRepository;
import fr.esgi.projet.use_cases.addMember.infrastructure.DefaultEventDispatcher;
import fr.esgi.projet.use_cases.addMember.infrastructure.InMemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MemberConfiguration {

    @Bean
    public MemberRepository memberRepository() {
        return new InMemoryMemberRepository();
    }

    @Bean
    public EventDispatcher<Event> memberEventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(PaymentEvent.class, List.of(new PaymentEventListener()));
        listenerMap.put(CreateMemberEvent.class, List.of(new CreateMemberEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateMemberCommandHandler createMemberCommandHandler() {
        return new CreateMemberCommandHandler(memberRepository(), memberEventEventDispatcher());
    }

    @Bean
    public PaymentCommandHandler modifyUserAddressCommandHandler() {
        return new PaymentCommandHandler(memberRepository(), memberEventEventDispatcher());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap =
                Collections.singletonMap(CreateMember.class, new CreateMemberCommandHandler(memberRepository(), memberEventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveMembers.class, new RetrieveMembersHandler(memberRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveMembersHandler retrieveMembersHandler() {
        return new RetrieveMembersHandler(memberRepository());
    }
}
