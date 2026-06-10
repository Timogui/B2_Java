## REPONSES.MD§1.A
1. Pourquoi le mot-clé volatile est-il indispensable sur l'instance dans le Double-Checked Locking ?

Il permet la visibilité et l'ordre d'écriture entre threads. L'objet est reconstruit quand une réf est assigné.

2. Donne une alternative plus simple et tout aussi thread-safe en Java. Pourquoi est-elle préférable ?

Un holder est préférable car c'est plus concis et pas besoin de synchro explicite dans getInstance().

## REPONSES.MD§1.F
3. Quelle est la différence entre le pattern State et un simple if/else sur un attribut enum ? Donne un avantage concret du State dans ce contexte.

Le pattern State encapsule le comportement dans des classes d'état, au lieu de centraliser la logique dans un if/else sur l'enum.
Un avantage concret : ajouter ou modifier un état se fait en créant ou ajustant une classe d'état sans toucher à une grosse structure conditionnelle, ce qui améliore la maintenabilité et réduit les risques d'erreurs.

