public abstract class EtatPersonnage { // (1 pt)
 protected Personnage personnage;
 public abstract String attaquer(String cible);
 public abstract String recevoirPoison();
 public abstract String mourir();
}
// EtatVivant : (2 pts)
// attaquer → "X attaque Y." | recevoirPoison → passe à Empoisonné
// mourir → passe à Mort
// EtatEmpoisonné : (2 pts)
// attaquer → "X attaque Y. X perd 10 PV (poison)"
// recevoirPoison → "Déjà empoisonné." | mourir → passe à Mort
// EtatMort : (2 pts)
// toutes les actions → "Action impossible, X est mort."