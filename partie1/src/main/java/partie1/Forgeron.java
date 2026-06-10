interface Arme {
    String nom();
    int degats();
}

public abstract class Forgeron {
    public abstract Arme forger();

    public final String presenterArme() {
        Arme arme = forger();
        return "Arme forgé : " + arme.nom() + " (" + arme.degats() + " dégâts)";
    }
}

class Epee implements Arme {
    @Override
    public String nom() {
        return "Epee";
    }

    @Override
    public int degats() {
        return 80;
    }
}

class Arc implements Arme {
    @Override
    public String nom() {
        return "Arc";
    }

    @Override
    public int degats() {
        return 60;
    }
}

class ForgeronEpee extends Forgeron {
    @Override
    public Arme forger() {
        return new Epee();
    }
}

class ForgeronArc extends Forgeron {
    @Override
    public Arme forger() {
        return new Arc();
    }
}