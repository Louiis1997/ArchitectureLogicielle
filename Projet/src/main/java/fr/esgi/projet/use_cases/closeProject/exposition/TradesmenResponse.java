package fr.esgi.projet.use_cases.closeProject.exposition;

import fr.esgi.projet.use_cases.closeProject.domain.Tradesman;

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
