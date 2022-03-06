package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Tradesman;

import java.util.ArrayList;

public class TradesmenRequest {
    public ArrayList<Tradesman> tradesmen;

    @Override
    public String toString() {
        return "Tradesmen{'" + tradesmen + "'}";
    }
}
