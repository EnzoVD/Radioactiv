package Rad;

/*TODO
 * Gestion des modifications pour le tableau : affichage et popIni
 * /////
 * Graphiques: buffer ?
 * Graphiques: data de tra�age :arraylist ou linkedlist des coordonn�es, attribut de At: ArrayList<double[2]> graph
 * getters et setters, fonction addPoint(pop2) qui prend pop2 et temps, les met dans un tableau et l'ajoute
 * La fonction de tra�age utilisera searchAfficheTrue() qui renvoie la position de l'�l�ment � afficher, et utilisera
 * /////
 * Am�lioration du Design
 * affichage et stockagetemps: pb avec millisecondes
 *(fait) Affichage du temps: 2 jtextfields: 1 valeur 2 unit�
 *(fait) changement de format selon temps
 *(� re tester de plus pr�s) URGENT : probl�me d'arrondis dans desint, d'o� une population croissante d'un atome radioactif qui ne peut que se d�sint�grer
 * GAMMA !
 */

/*DONE
 * Se passer du tableau interm�diaire : correspondance directe Jtab et liste
 *
 *
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/*CREDITS
 * getters et setters de At par Kexin Zong
 * Objet At et base de donn�e des atomes par Daphn� Guibert
 * Jmathplot, courbes etc... par Alexandre Lamartine
 * Reste par Enzo Vironda
 * ReadCSV inspir� de Nagesh Chauhan @http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
 * Relecture, optimisation, correction par tous
 */


public class Princip {

    //pas du chronom�tre

    protected static int T = 1000; //pas du timer
    protected static double delay = 1; // une seconde  de temps r�el = delay secondes de temps
    protected static Timer timer;
    protected static double temps; //temps �coul�
    protected static double tempsprec = 0;
    protected static ArrayList<At> ListeElem =
        new ArrayList(); //passage d'une linked list � Array list car Linkedlist.get o(n) et ArrayList.get o(1) d'o� une surchage de parcours


    //position dans les diverses tables des 3 particules les plus utilis�es, afin de ne pas avoir � les rechercher � chaque fois.
    protected int posElec;
    protected int posHel;
    protected int posProt;
    //bool�ennes qui indiquent l'�tat du programme
    protected static boolean startSim = false; //false= attend conditions initiales
    protected static boolean finSim = false; //true= appuy� sur fin ou pop nulle pour tous les atomes radio
    protected static boolean finInit = false;
    static InterfGraph fen;
    public static Princip Rad;


    public Princip() {

        //rempli la liste des atomes
        Origin(); // met en place timer


    }

    public static void main(String[] args) {
        Rad = new Princip();
    }

    public void boucle_principale() {
        /*appel&e � chaque instant t
        * r�alise la d�gradation de chaque �l�ment
        * met a jour l'activit�
        * MAJ tableau et jTable
        * rafraichit l'interface
        */
        desint1();
        displayGraph();
        fen.setjTable1();
        fen.refreshTab();
        //fen.repaint();

    }

    private void Origin() {
        /*
         *Lis CSV, Cr�e liste, Cr�e tableau, le  remplit, cr�e le jTable, cr�e l'interface et la rend visible
         */
        // readCSV.convertCsvToJavaAt(ListeElem);
        readCSV.convertCsvToJavaAt2(ListeElem);
        searchPosParticule();

        fen = new InterfGraph();
        fen.setjTable1();
        fen.refreshTab();

        fen.setVisible(true);
        fen.setResizable(false);
        //fen.revalidate();
        //fen.repaint();
        //SwingUtilities.updateComponentTreeUI(fen);

        timer = new Timer(T, new TimerAction()); //impl�menter timeraction Timer(T, new TimerAction())
        temps = 0;
        fen.textsetjTextField1("Timer");
        fen.setjTable1();
        System.out.println("Origin fini");
        //fen.updateDelay();
        setfinInit(true);

    }

    public void desint1() {
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            desintAt(atome);
            ListeElem.set(i, atome);
        }
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);

            atome.setpopAct(atome.getpopAct() + atome.getajoutPop());

            atome.activite();
            atome.addPointAct();

            atome.addPointPop();

            atome.setajoutPop(0);
            ListeElem.set(i, atome);
        }
    }

    public void desint2() {
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            desintAt(atome);
            ListeElem.set(i, atome);
        }
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);


            atome.activite();
            atome.addPointAct();

            atome.addPointPop();

            atome.setajoutPop(0);
            ListeElem.set(i, atome);
        }
    }


    public void desintAt(At atome) {


        /*Prend un atome et en r�alise la d�sint�gration :
        d�temine en quel �l�ment il se d�sint�gre selon le type de d�sint�gration
        parcourt la liste pour trouver l'atome cr�e, met � jour les populations
        Si une particule est �mise, sa position est connue et sa population mise à jour.
        */

        At atomedes; //atome fruit de la d�sint�gration


        switch (atome.gettype()) {
        case 0:
            break;
        case 1:
            { //alpha
                atome.setajoutPop(atome.getajoutPop() +
                                  Math.ceil((atome.getpopAct()) *
                                            (Math.expm1(-((getdelay()) * (Math.log(2) / atome.getdVie()))))));
                System.out.println("popact " + atome.getpopAct() + "  ajoutpop" + atome.getajoutPop() +
                                   "  constante rad " + Math.log(2) / atome.getdVie() + "    delay" + delay);
                if (atome.getA() == 238) {
                    fen.jTextField2.setText("test 1 " + Double.toString(atome.getpopAct()));
                }
                // loi decroissance radio N(t)=No*Exp(-At) A=ln 2/dVie
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomedes = ListeElem.get(i);
                    if (atomedes.getA() == (atome.getA() - 4) & atomedes.getZ() == (atome.getZ() - 2)) { //trouve le nouvel �l�ment





                        atomedes.setajoutPop(atomedes.getajoutPop() - atome.getajoutPop());

                        ListeElem.set(i, atomedes);
                        At He =
                            ListeElem.get(posHel); // trouve �l�m Helium, pop1 pop pr�c�dente, pop2 nouvelle pop
                        He.setajoutPop(He.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(posHel, He);
                    }
                }

            }

            break;
        case 2:
            { //Beta moins

                atome.setajoutPop(atome.getajoutPop() +
                                  (int) Math.ceil((atome.getpopAct()) *
                                                  (Math.expm1(-((getdelay()) *
                                                                (Math.log(2) /
                                                                 atome.getdVie())))))); // loi decroissance radio N(t)=No*Exp(-At) A=1/dVie
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomedes = ListeElem.get(i);
                    if (((atomedes.getA()) == (atome.getA())) & (atomedes.getZ() == (atome.getZ() + 1))) {


                        atomedes.setajoutPop(atomedes.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(i, atomedes);
                        At Elec = ListeElem.get(posElec); // trouve �l�m Electron
                        Elec.setajoutPop(Elec.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(posElec, Elec);
                    }
                }

            }
            break;
        case 3:
            { //Beta plus

                atome.setajoutPop(atome.getajoutPop() +
                                  (int) Math.ceil((atome.getpopAct()) *
                                                  (Math.expm1(-((getdelay()) *
                                                                (Math.log(2) /
                                                                 atome.getdVie())))))); // loi decroissance radio N(t)=No*Exp(-At) A=1/dVie
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomedes = ListeElem.get(i);
                    if (atomedes.getA() == (atome.getA()) & atomedes.getZ() == (atome.getZ() - 1)) {
                        atomedes.setajoutPop(atomedes.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(i, atomedes);
                        At Proton = ListeElem.get(posProt); // trouve �l�m Proton
                        Proton.setajoutPop(Proton.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(posProt, Proton);
                    }
                }

            }
            break;
        case 4:
            {
            }
            break;

        }


    }

    public void desintAtCorrtest(At atome) {


        /*Prend un atome et en r�alise la d�sint�gration :
        d�temine en quel �l�ment il se d�sint�gre selon le type de d�sint�gration
        parcourt la liste pour trouver l'atome cr�e, met � jour les populations
        Si une particule est �mise, sa position est connue et sa population mise à jour.
        */

        At atomedes; //atome fruit de la d�sint�gration


        switch (atome.gettype()) {
        case 0:
            break;
        case 1:
            { //alpha
                atome.setajoutPop(atome.getajoutPop() - 50);
                System.out.println("popact " + atome.getpopAct() + "  ajoutpop" + atome.getajoutPop() +
                                   "  constante rad " + Math.log(2) / atome.getdVie() + "    delay" + delay);
                if (atome.getA() == 238) {
                    fen.jTextField2.setText(fen.jTextField2.getText() + "  test 1 " +
                                            Double.toString(atome.getpopAct()));
                }
                // loi decroissance radio N(t)=No*Exp(-At) A=ln 2/dVie
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomedes = ListeElem.get(i);
                    if (atomedes.getA() == (atome.getA() - 4) & atomedes.getZ() == (atome.getZ() - 2)) { //trouve le nouvel �l�ment

                        //atome.setpop1(atome.pop2);  //pop1=pop2



                        atomedes.setajoutPop(atomedes.getajoutPop() - atome.getajoutPop());

                        ListeElem.set(i, atomedes);
                        At He =
                            ListeElem.get(posHel); // trouve �l�m Helium, pop1 pop pr�c�dente, pop2 nouvelle pop
                        He.setajoutPop(He.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(posHel, He);
                    }
                }

            }

            break;
        case 2:
            { //Beta moins

                atome.setajoutPop(atome.getajoutPop() - 32); // loi decroissance radio N(t)=No*Exp(-At) A=1/dVie
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomedes = ListeElem.get(i);
                    if (((atomedes.getA()) == (atome.getA())) & (atomedes.getZ() == (atome.getZ() + 1))) {


                        atomedes.setajoutPop(atomedes.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(i, atomedes);
                        At Elec = ListeElem.get(posElec); // trouve �l�m Electron
                        Elec.setajoutPop(Elec.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(posElec, Elec);
                    }
                }

            }
            break;
        case 3:
            { //Beta plus

                atome.setajoutPop(atome.getajoutPop() - 65); // loi decroissance radio N(t)=No*Exp(-At) A=1/dVie
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomedes = ListeElem.get(i);
                    if (atomedes.getA() == (atome.getA()) & atomedes.getZ() == (atome.getZ() - 1)) {
                        atomedes.setajoutPop(atomedes.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(i, atomedes);
                        At Proton = ListeElem.get(posProt); // trouve �l�m Proton
                        Proton.setajoutPop(Proton.getajoutPop() - atome.getajoutPop());
                        ListeElem.set(posProt, Proton);
                    }
                }

            }
            break;
        case 4:
            {
            }
            break;

        }


    }

    public static Object[][] listTo2dTab() {
        /*
         * rempli un tableau 2D � partir de ListeElem
         */
        ArrayList<At> Liste = Princip.getList();
        int numCol = 11;
        int numLign = Liste.size();
        Object[][] data = new Object[numLign][numCol];
        for (int i = 0; i < numLign; i++) {
            At atome = Liste.get(i);
            data[i][0] = atome.getaffiche();
            data[i][1] = atome.getnom();
            data[i][2] = atome.getabr();
            data[i][3] = atome.getA();
            data[i][4] = atome.getZ();
            data[i][5] = atome.getN();
            data[i][6] = secToTime(atome.getdVie());
            data[i][7] = typeintToTypeString(atome.gettype());
            data[i][8] = atome.getpopIni();
            // if(startSim==false){
            //    data[i][9] = atome.getpopIni();
            // }
            // else{
            data[i][9] = atome.getpopAct();
            // }

            data[i][10] = atome.getactivite();

        }
        return data;
    }

    private void searchPosParticule() {
        /*
         * cherche et initialise la position des particules importantes dans la d�sint�gration, la taille de l'ArrayList ne changeant pas.
         */
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            if (atome.getA() == 4 & atome.getZ() == 2) {
                posHel = i;
            } else if (atome.getA() == 0 & atome.getZ() == 1) {
                posProt = i;
            } else if (atome.getA() == 0 & atome.getZ() == -1) {
                posElec = i;
            }
        }
    }


    private class TimerAction implements ActionListener {

        // ActionListener appProee tous les interval millisecondes

        public void actionPerformed(ActionEvent e) {
            fen.setDelayAffiche();
            Princip.setTempsPrec(temps);
            temps = temps + getdelay();
            boucle_principale();
            //testTimer();

            afficheTemps();
        }

    }

    public static String secToTime(double s) {
        //n�cessit� de double car valmax int (2 octet) est 2147483647 et que l'on travaille en plusieurs miliards d'ann�es
        String S = "";
        double prov = s;
        double an = (Math.floor(prov / (365 * 24 * 60 * 60)));
        prov = prov - an * 365 * 24 * 60 * 60;
        double jours = (Math.floor(prov / (24 * 60 * 60)));

        prov = prov - jours * 24 * 60 * 60;

        double heur = (Math.floor(prov / (60 * 60)));

        prov = prov - heur * 60 * 60;
        double min = (Math.floor(prov / (60)));

        prov = prov - min * 60;
        double sec = (Math.floor(prov));
        if (an != 0.0) {
            S = S + an + " an ";
        }
        if (jours != 0.0) {
            S = S + jours + " jours ";
        }
        if (heur != 0.0) {
            S = S + heur + " h ";
        }
        if (min != 0.0) {
            S = S + min + " min ";
        }
        if (sec != 0.0) {
            S = S + sec + " sec ";
        }
        return S;
    }

    public static String typeintToTypeString(int t) {
        String Type = "";
        switch (t) {
        case 0:
            Type = "Stable";
            break;
        case 1:
            Type = "Alpha";
            break;
        case 2:
            Type = "Beta-";
            break;
        case 3:
            Type = "Beta+";
            break;
        case 4:
            Type = "gamma";
            break;
        }
        return Type;
    }

    public static void displayGraph() {
        int pos = searchAfficheTrue();
        if (pos != -1) {
            At atome = ListeElem.get(pos);
            fen.setjPAct(atome.getnom(), atome.tabXAct(), atome.tabYAct());
            fen.setjPPop(atome.getnom(), atome.tabXPop(), atome.tabYPop());
            double deltaT = (temps - tempsprec);


            fen.revalidate();
        }
    }

    /*
     * Impl�mentation Boutons
     */
    public static void testButton() {
        for (int i = 0; i < ListeElem.size(); i++) {
            At atome = ListeElem.get(i);
            atome.setpopIni(10000000);
            atome.setpopAct(10000000);
            ListeElem.set(i, atome);
        }
    }

    public static void resetButton() {
        fen.dispose();
        stopButton();

        Rad = new Princip();
        fen.setjTable1();
    }

    public static void stopButton() {
        if (timer.isRunning()) {
            timer.stop();
        }
        setfinSim(true);
        setstartSim(false);
    }

    public static void pauseButton() {
        if (timer.isRunning() & getstartSim()) {
            timer.stop();
        }

        else if (timer.isRunning() == false & getstartSim()) {
            timer.start();
        } else {
        }

    }

    public static void playButton() {
        if (getstartSim() == false & getfinSim() == false) {
            timer.start();
            setstartSim(true);
        } else {
        }

    }
    /*
     * Getters et setters
     */
    public static ArrayList getList() {
        return ListeElem;
    }

    public static void setList(ArrayList L) {
        ListeElem = L;
    }

    public static void setElemListeElem(int i, At at) {
        ListeElem.set(i, at);
    }

    public static At getElemListeElem(int i) {
        At at = ListeElem.get(i);
        return at;
    }

    public static boolean getstartSim() {
        return startSim;
    }

    public static void setstartSim(boolean S) {
        startSim = S;
    }

    public static boolean getfinSim() {
        return finSim;
    }

    public static void setfinSim(boolean f) {
        finSim = f;
    }

    public static boolean getfinInit() {
        return finInit;
    }

    public static void setfinInit(boolean S) {
        finInit = S;
    }

    public static int getT() {
        return T;
    }

    public static void setT(int t) {
        T = t;
    }

    public static double gettemps() {
        return temps;
    }

    public void settemps(double t) {
        temps = t;
    }

    public static double getdelay() {
        return delay;
    }

    public static void setdelay(double d) {
        delay = d;
    }

    public static double getTempsPrec() {
        return tempsprec;
    }

    public static void setTempsPrec(double t) {
        tempsprec = t;
    }


    public static int searchAfficheTrue() {
        int pos = -1;
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            if (atome.getaffiche() == true) {
                pos = i;
            }
        }
        return pos;
    }


    public void afficheTemps() {
        fen.textsetjTextField1(secToTime(temps));
    }


    //fonctions de test de bon remplissage des tableaux
    public static void listToPrint() {
        for (int i = 0; i < ListeElem.size(); i++) {
            ListeElem.get(i).toPrint();
        }

    }

    public static void tabToPrint(Object[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void jtabToPrint(JTable tab) {

        for (int i = 0; i < tab.getRowCount(); i++) {
            for (int j = 0; j < tab.getColumnCount(); j++) {
                System.out.print(tab.getValueAt(i, 0));
            }
            System.out.println();
        }
        System.out.println("c'�tait un jtab");
    }

    public static int countAfficheTrue() {
        int count = 0;
        for (int i = 0; i < ListeElem.size(); i++) {
            if (ListeElem.get(i).getaffiche() == true) {
                count++;
            }
        }
        return count;
    }

    public static int countAfficheTruejT() {
        int count = 0;
        for (int i = 0; i < fen.getjTable1().getRowCount(); i++) {
            if (fen.getjTable1().getValueAt(i, 0) == true) {
                count++;
            }
        }
        return count;
    }


    public void testTimer() {
        At test = getElemListeElem(0);
        test.setA(test.getA() + 1);
        setElemListeElem(0, test);
        fen.setjTable1();
        fen.refreshTab();

    }

}


