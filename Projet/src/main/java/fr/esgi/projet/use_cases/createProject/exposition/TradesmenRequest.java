package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Tradesman;

import java.util.ArrayList;

public class TradesmenRequest {
    public ArrayList<Tradesman> tradesmen;

    @Override
    public String toString() {
        return "Tradesmen{'" + tradesmen + "'}";
    }
}
