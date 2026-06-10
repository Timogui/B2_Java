package partie2;
import java.util.*;
import java.util.stream.Collectors;

public class BoutiqueService {
    private final List<Produit> produits;

    public BoutiqueService(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Produit> getProduitsDisponibles() {
        return produits.stream()
                .filter(p -> p.stock() > 0)
                .sorted(Comparator.comparingDouble(Produit::prix))
                .collect(Collectors.toList());
    }

    public double getPrixMoyen(String categorie) {
        return produits.stream()
                .filter(p -> p.categorie().equalsIgnoreCase(categorie))
                .mapToDouble(Produit::prix)
                .average()
                .orElse(0.0);
    }

    public Map<String, List<String>> getNomsParCategorie() {
        return produits.stream()
                .sorted(Comparator.comparing(Produit::nom)) // Trie par nom directement dans le flux
                .collect(Collectors.groupingBy(
                        Produit::categorie,
                        Collectors.mapping(Produit::nom, Collectors.toList())
                ));
    }

    public Map<String, Long> getAlertesRupture(int seuil) {
        return produits.stream()
                .filter(p -> p.stock() < seuil)
                .collect(Collectors.groupingBy(
                        Produit::categorie,
                        Collectors.counting()
                ));
    }
    
    public Optional<Produit> getProduitLePlusCher() {
        return produits.stream()
                .max(Comparator.comparingDouble(Produit::prix));
    }

    public double getValeurTotaleStock() {
        return produits.stream()
                .mapToDouble(p -> p.prix() * p.stock())
                .sum();
    }
}