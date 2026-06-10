public class Personnage {
    private final String nom; // obligatoire
    private final String classe; // obligatoire (ex: Guerrier, Mage, Voleur)
    private int pv; // défaut : 100
    private int mana; // défaut : 50
    private String arme; // défaut : "Poings"
    private boolean estElite; // défaut : false

    private Personnage(Builder builder) {
        this.nom = builder.nom;
        this.classe = builder.classe;
        this.pv = builder.pv;
        this.mana = builder.mana;
        this.arme = builder.arme;
        this.estElite = builder.estElite;
    }

    public static class Builder {
        private String nom;
        private String classe;
        private int pv = 100;
        private int mana = 50;
        private String arme = "Poings";
        private boolean estElite = false;

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder classe(String classe) {
            this.classe = classe;
            return this;
        }

        public Builder pv(int pv) {
            this.pv = pv;
            return this;
        }

        public Builder mana(int mana) {
            this.mana = mana;
            return this;
        }

        public Builder arme(String arme) {
            this.arme = arme;
            return this;
        }

        public Builder estElite(boolean estElite) {
            this.estElite = estElite;
            return this;
        }

        public Personnage build() {
            if (nom == null || nom.isBlank()) {
                throw new IllegalArgumentException("Le nom est obligatoire");
            }
            if (classe == null || classe.isBlank()) {
                throw new IllegalArgumentException("La classe est obligatoire");
            }
            return new Personnage(this);
        }
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "nom='" + nom + '\'' +
                ", classe='" + classe + '\'' +
                ", pv=" + pv +
                ", mana=" + mana +
                ", arme='" + arme + '\'' +
                ", estElite=" + estElite +
                '}';
    }
}
