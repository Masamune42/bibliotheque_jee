-- FILTRAGE SELON CRITERES
SELECT * FROM ARTICLES_VENDUS a
-- ON AFFICHE LES ARTICLES MÊME SI IL N'Y A AUCUNE ENCHERE DESSUS, PAS POSSIBLE AVEC INNER JOIN
INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie
-- FILTRAGE SUIVANT LE NOM CHERCHE
WHERE a.nom_article LIKE '%%'
-- FILTRAGE SUIVANT LA CATEGORIE
AND (c.no_categorie = ? or -1=?)
-- VENTE :
-- MES VENTES EN COURS
AND (a.no_utilisateur = 15 AND GETDATE() < a.date_fin_encheres AND GETDATE() > a.date_debut_encheres AND ? = 1
-- MES VENTES NON DEBUTEES
OR a.no_utilisateur = 15 AND GETDATE() < a.date_debut_encheres AND ? = 1
-- MES VENTES TERMINEES
OR a.no_utilisateur = 15 AND GETDATE() > a.date_debut_encheres AND ? = 1
);