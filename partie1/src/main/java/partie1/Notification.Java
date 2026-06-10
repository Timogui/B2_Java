public interface CanalEnvoi { // (1 pt)
 void envoyer(String destinataire, String message);
}
// Implémente CanalEmail : affiche "[EMAIL] -> dest : message" (1 pt)
// Implémente CanalSMS : affiche "[SMS] -> dest : message" (1 pt)
public abstract class Notification { // (1 pt)
 protected CanalEnvoi canal;
 public Notification(CanalEnvoi canal) { this.canal = canal; }
 public abstract void notifier(String destinataire, String contenu);
}
// Implémente NotificationUrgente : (1 pt)
// préfixe le contenu avec "[URGENT] "
// Implémente NotificationNormale : (1 pt)
// envoie le contenu sans modification
