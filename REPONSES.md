## REPONSES.MD§1.A
1. Pourquoi le mot-clé volatile est-il indispensable sur l'instance dans le Double-Checked Locking ?

Il permet la visibilité et l'ordre d'écriture entre threads. L'objet est reconstruit quand une réf est assigné.

2. Donne une alternative plus simple et tout aussi thread-safe en Java. Pourquoi est-elle préférable ?

Un holder est préférable car c'est plus concis et pas besoin de synchro explicite dans getInstance().
