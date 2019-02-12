/* Auteurs: Mohamed El Ayat
		  : Loubar Youghourta */


import java.io.IOException;

//Classe IndexInv hérite toutes les propriétés de Index
public class IndexInv  {





    public static ListeDoc indexInv = new ListeDoc();

    // Cette méthode crée l’index inversé à partir de la première structure d’index.
    public static void indexInvSrc() throws IOException {

        IndexInv.indexInv = new ListeDoc();
        if(Index.index.head==null) {
            System.out.println("---> la structure d'index n'existe pas <---");
            return;
        }
        Noeud n = Index.index.head;

        //parcours de la liste verticale de Index
        while (n != null) {

            Noeud n2 = n.getObject().getList().head;

            //parcours de la liste horizontale de Index
            while (n2 != null) {

                //cas ou Index est vide
                if (IndexInv.indexInv.head == null) {

                    IndexInv.indexInv.ajout(  new Object(n2.getObject().getMot(), new ListeMot()  )  );

                    IndexInv.indexInv.head.getObject().getList().ajout(  new Object(n.getObject().getMot(), n2.getObject().getFrequence())  );

                }

                else {

                    Noeud n3 = IndexInv.indexInv.head;

                    //cas ou le mot appartient a la premiere place
                    if (n2.getObject().getMot().compareTo(n3.getObject().getMot()) < 0) {

                        IndexInv.indexInv.head = new Noeud(new Object(n2.getObject().getMot(), new ListeMot(
                                new Noeud(new Object(n.getObject().getMot(), n2.getObject().getFrequence()), null))),
                                n3);


                    }

                    else {

                        outerloop: while (n3 != null) {
                            //cas ou le mot existe deja dans IndexInv
                            if (n2.getObject().getMot().equals(n3.getObject().getMot())) {

                                n3.getObject().getList().ajout (  new Object(  n.getObject().getMot(),  n2.getObject().getFrequence()  )  );

                                break;

                            }

                            else {

                                if (n3.getProchainNoeud() != null) {

                                    if (n2.getObject().getMot().compareTo(n3.getProchainNoeud().getObject().getMot()) < 0) {

                                        n3.setProchainNoeud(new Noeud(
                                                new Object(n2.getObject().getMot(),
                                                        new ListeMot(new Noeud(new Object(n.getObject().getMot(),
                                                                n2.getObject().getFrequence()), null))),
                                                n3.getProchainNoeud()));

                                        break;

                                    }

                                }

                                else {

                                    n3.setProchainNoeud(new Noeud(new Object(n2.getObject().getMot(),
                                            new ListeMot(new Noeud(
                                                    new Object(n.getObject().getMot(), n2.getObject().getFrequence()),
                                                    null))),
                                            null));

                                    break;

                                }
                            }

                            n3 = n3.getProchainNoeud();

                        }

                    }

                }

                n2 = n2.getProchainNoeud();

            }

            n = n.getProchainNoeud();

        }

        List.trierFreq(  IndexInv.indexInv  );

    }


}