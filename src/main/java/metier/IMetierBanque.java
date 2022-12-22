package metier;

public interface IMetierBanque {
    void addCompte(Compte compte);
    void verser(double montant, long code);
    void retirer(double montant, long code);
    Compte consulterCompte(long code);
}
