package metier;

import java.util.HashMap;
import java.util.Map;

public class MetierBanqueImpl implements IMetierBanque {
    private Map<Long,Compte> compteMap = new HashMap<>();

    @Override
    public void addCompte(Compte compte) {
        compteMap.put(compte.getCode(), compte);
    }

    @Override
    public void verser(double montant, long code) {
        Compte compte = compteMap.get(code);
        compte.setSolde(compte.getSolde() + montant);
    }

    @Override
    public void retirer(double montant, long code) {
        Compte compte = compteMap.get(code);
        compte.setSolde(compte.getSolde() - montant);
    }

    @Override
    public Compte consulterCompte(long code) {
        return compteMap.get(code);
    }
}
