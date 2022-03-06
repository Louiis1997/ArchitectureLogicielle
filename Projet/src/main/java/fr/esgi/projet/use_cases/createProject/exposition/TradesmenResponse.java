package fr.esgi.projet.use_cases.createProject.exposition;

import fr.esgi.projet.use_cases.createProject.domain.Tradesman;

import java.util.ArrayList;

public class TradesmenResponse {
    public ArrayList<Tradesman> tradesmen;

    public TradesmenResponse(ArrayList<Tradesman> tradesmen) {
        this.tradesmen = tradesmen;
    }

    @Override
    public String toString() {
        return "TradesmenDTO{" +
                "Tradesmen{" + tradesmen +
                '}';
    }
}
