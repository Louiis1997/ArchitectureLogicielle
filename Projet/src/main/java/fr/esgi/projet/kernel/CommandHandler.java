package fr.esgi.projet.kernel;

public interface CommandHandler<C extends Command, R> {
    R handle(C command);
}
