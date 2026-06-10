public interface Potion {
    int getPV(); // points de vie restaurés
    String getEffets(); // description des effets
}

class PotionDeBase implements Potion {
    @Override
    public int getPV() {
        return 50;
    }

    @Override
    public String getEffets() {
        return "Soin de base";
    }
}

abstract class PotionDecorator implements Potion {
    protected final Potion potion;

    PotionDecorator(Potion potion) {
        this.potion = potion;
    }

    @Override
    public int getPV() {
        return potion.getPV();
    }

    @Override
    public String getEffets() {
        return potion.getEffets();
    }
}

class AvecAntidote extends PotionDecorator {
    AvecAntidote(Potion potion) {
        super(potion);
    }

    @Override
    public int getPV() {
        return super.getPV();
    }

    @Override
    public String getEffets() {
        String base = super.getEffets();
        return base.isEmpty() ? "Antidote" : base + ", Antidote";
    }
}

class AvecMana extends PotionDecorator {
    AvecMana(Potion potion) {
        super(potion);
    }

    @Override
    public int getPV() {
        return super.getPV() + 30;
    }

    @Override
    public String getEffets() {
        String base = super.getEffets();
        return base.isEmpty() ? "Restauration de mana" : base + ", Restauration de mana";
    }
}