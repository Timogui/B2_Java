public class BoutiqueService {
    private final List<Produit> produits;

    public List<Produit> getProduitsDisponibles() {
        return produits.stream()
                .filter(p -> p.getStock() > 0)
                .sorted(Comparator.comparingDouble(Produit::getPrix))
                .collect(Collectors.toList());
    }

    public double getPrixMoyen(String categorie) {
        return produits.stream()
                .filter(p -> p.getCategorie().equalsIgnoreCase(categorie))
                .mapToDouble(Produit::getPrix)
                .average()
                .orElse(0.0);
    }

    public Map<String, List<String>> getNomsParCategorie() {
        return produits.stream()
                .collect(Collectors.groupingBy(
                        Produit::getCategorie,
                        Collectors.mapping(Produit::getNom,
                                Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    Collections.sort(list);
                                    return list;
                                }))
                ));
    }

    public Map<String, Long> getAlertesRupture(int seuil) {
        return produits.stream()
                .filter(p -> p.getStock() < seuil)
                .collect(Collectors.groupingBy(
                        Produit::getCategorie,
                        Collectors.counting()
                ));
    }
    
    public Optional<Produit> getProduitLePlusCher() {
        return produits.stream()
                .max(Comparator.comparingDouble(Produit::getPrix));
    }

    public double getValeurTotaleStock() {
        return produits.stream()
                .mapToDouble(p -> p.getPrix() * p.getStock())
                .sum();
    }
}