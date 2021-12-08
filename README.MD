
# BlackJack ( VERSION EUROPEENNE )

- /!\ On doit utiliser le scanner pour demander les infos au joueur : https://www.data-transitionnumerique.com/scanner-java/
- Le but du jeu est de faire 21 points, mais il n'est pas nécessaire de les atteindre. Le principal est de faire mieux que le croupier.
- Si vous ou le croupier dépassé 21, vous avez instantanément perdu (vous ne POUVEZ pas dépasser 21 points).
- N'hésitez pas à lire les règles en cas de pépin pour mieux comprendre.

Le jeu se compose de plusieurs éléments : 

- Un SEUL joueur
- Un croupier
- Un jeu (deck) de 52 cartes
- Des.... cartes, différentes les unes des autres.
- Les cartes de 2 à 9 valent de 2 à 9 points (la carte 7 vaut 7 points)
- L'AS vaut 11 points (pas de choix)
- Les figures (valet, dame & roi) valent 10 points.

Le jeu se décompose en plusieurs phases (on peut les retrouver en partie ici https://www.guide-blackjack.com/regles-du-black-jack.html ) :
- On distribue deux cartes au joueur et au croupier (on ne voit que la première de ces 2 cartes).
- Le joueur décide s'il tire (reçoit) une carte (il peut en avoir jusqu'à 4) ou s'il reste (ne tire plus de carte sur ce round)
- Une fois que la première décision du joueur est prise (tirer ou rester), la deuxième carte du croupier s'affiche.
- Le joueur continue de tirer des cartes (limite de 4 cartes au total) ou de rester.
- Quand le joueur a fini de tirer, le croupier tire des cartes jusqu'à ce que sa main contienne au moins 16 points
