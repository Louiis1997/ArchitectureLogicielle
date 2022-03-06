package fr.esgi.projet.use_cases.addMember.exposition;

import fr.esgi.projet.kernel.CommandBus;
import fr.esgi.projet.kernel.QueryBus;
import fr.esgi.projet.use_cases.addMember.application.CreateMember;
import fr.esgi.projet.use_cases.addMember.application.RetrieveMembers;
import fr.esgi.projet.use_cases.addMember.domain.Email;
import fr.esgi.projet.use_cases.addMember.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
public class MemberController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MemberController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/members", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MembersResponse> getAll() {
        final List<Member> members = queryBus.send(new RetrieveMembers());
        MembersResponse usersResponseResult = new MembersResponse(members.stream().map(member -> new MemberResponse(String.valueOf(member.getId().getValue()), member.getLastname(), member.getFirstname(),new EmailResponse(member.getEmail().getEmail()),member.getPassword(), member.getRole(), member.getCreditCard(), member.getLastPayment())).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseResult);
    }

    @PostMapping(path = "/members", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid MemberRequest request) {
        CreateMember createMember = new CreateMember(request.lastname, request.firstname, new Email(request.email.email), request.password);
        commandBus.send(createMember);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
