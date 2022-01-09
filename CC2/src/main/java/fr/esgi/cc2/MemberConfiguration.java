package fr.esgi.cc2;

import fr.esgi.cc2.kernel.*;
import fr.esgi.cc2.use_cases.member.application.*;
import fr.esgi.cc2.use_cases.member.domain.MemberRepository;
import fr.esgi.cc2.use_cases.member.infrastructure.DefaultEventDispatcher;
import fr.esgi.cc2.use_cases.member.infrastructure.InMemoryMemberRepository;
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
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        //listenerMap.put(ModifyUserAddressEvent.class, List.of(new ModifyUserAddressEventListener()));
        listenerMap.put(CreateMemberEvent.class, List.of(new CreateMemberEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateMemberCommandHandler createUserCommandHandler() {
        return new CreateMemberCommandHandler(memberRepository(), eventEventDispatcher());
    }

    /*@Bean
    public ModifyUserAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher());
    }*/

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap =
                Collections.singletonMap(CreateMember.class, new CreateMemberCommandHandler(memberRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlerMap =
                Collections.singletonMap(RetrieveMembers.class, new RetrieveMembersHandler(memberRepository()));
        return new SimpleQueryBus(queryHandlerMap);
    }

    @Bean
    public RetrieveMembersHandler retrieveUsersHandler() {
        return new RetrieveMembersHandler(memberRepository());
    }

    /*@Bean
    public RetrieveUsersByCityHandler retrieveUsersByCityHandler() {
        return new RetrieveUsersByCityHandler(userRepository());
    }*/
}
