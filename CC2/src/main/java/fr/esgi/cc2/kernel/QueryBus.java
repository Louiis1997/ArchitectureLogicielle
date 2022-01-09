package fr.esgi.cc2.kernel;

public interface QueryBus {
    <Q extends Query, R> R send(Q query);
}
