import java.io.IOException;

public class Recherche {

    // Cette méthode détermine une liste de réponse
    // correspondant à une requête
    public static List rechercheSrc(String requete) throws IOException {

        String[] search = requete.split("\\s+");

        Noeud n = IndexInv.indexInv.head;

        List baseList = null;

        //recherche de notre premiere liste de reponse
        while (n != null) {

            if (n.getObject().getMot().equals(search[0])) {

                baseList = n.getObject().getList();
                break;

            }

            n = n.getProchainNoeud();

        }

        //retourne null si le mot n'est pas trouvé
        if (baseList == null) {

            return null;

        }

        else {

            for (int i = 1; i < search.length; i++) {

                List compareList = null;

                Noeud n2 = IndexInv.indexInv.head;

                while (n2 != null) {

                    if (n2.getObject().getMot().equals(search[i])) {

                        compareList = n2.getObject().getList();
                        break;

                    }

                    n2 = n2.getProchainNoeud();

                }

                //retourne null si quelconque mot n'est pas présent
                if (compareList == null) {

                    return null;

                }

                Noeud n3 = baseList.head;
                Noeud prev = null;

                while (n3 != null) {

                    Noeud n4 = compareList.head;

                    while (n4 != null) {

                        //si le mot est présent dans les deux listes qu'on compare
                        if (n3.getObject().getMot().equals(n4.getObject().getMot())) {

                            n3.getObject().setFrequence(n3.getObject().getFrequence() + n4.getObject().getFrequence());

                            prev = n3;

                            break;

                        }

                        //si le mot doit être supprimé de notre liste réponse initialee
                        else if (n4.getProchainNoeud() == null) {

                            if (prev == null) {

                                baseList.head = n3.getProchainNoeud();

                                break;

                            }

                            else {

                                prev.setProchainNoeud(n3.getProchainNoeud());
                                break;

                            }

                        }

                        n4 = n4.getProchainNoeud();

                    }

                    n3 = n3.getProchainNoeud();

                }

            }

        }

        ListeDoc.searchResult = baseList;
        ListeDoc.searchResult.afficherRecherche();

        return baseList;

    }



}
