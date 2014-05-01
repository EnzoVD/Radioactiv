package Rad;
//change
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
    static Timer timer;
    protected static double temps; //temps �coul�
    protected static ArrayList<At> ListeElem =
        new ArrayList(); //passage d'une linked list � Array list car Linkedlist.get o(n) et ArrayList.get o(1) d'o� une surchage de parcours
    protected static Object[][] tabElem; //tableau qui fait le lien entre jTable affich�e et l'Array List

    //position dans les diverses tables des 3 particules les plus utilis�es, afin de ne pas avoir � les rechercher � chaque fois.
    protected int posElec;
    protected int posHel;
    protected int posProt;
    //bool�ennes qui indiquent l'�tat du programme
    protected static boolean StartSim = false; //false= attend conditions initiales
    protected static boolean finSim = false; //true= appuy� sur fin ou pop nulle pour tous les atomes radio
    InterfGraph fen;
    public static Object[][] test2 = MyTableModel_1.fillIni();


    public Princip() {

        //rempli la liste des atomes
        Origin(); // met en place timer
        InterfGraph.setjTable1();
        // TODO cr�er fonction qui remplit les conditions initiales: a priori, tableau �ditable avant le play
    }

    public void desintAt(At atome) {
        /*
        *Prend un atome et en r�alise la d�sint�gration :
        d�temine en quel �l�ment il se d�sint�gre selon le type de d�sint�gration
        parcourt la liste pour trouver l'atome cr�e, met � jour les populations
        Si une particule est �mise, sa position est connue et sa population mise à jour.
        */
        At atomeprov; //atome consid�r�
        At atomedes; //atome fruit de la d�sint�gration
        int posAtome; //position
        int des = 0; //population desint�gr�e
        switch (atome.gettype()) {
        case 0:
            break;
        case 1:
            { //alpha
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomeprov = ListeElem.get(i);
                    if (atomeprov.getA() == (atome.getA() - 4) & atomeprov.getZ() == (atome.getZ() - 2)) {
                        atomedes = atomeprov;
                        atome.setpop1(atome.pop2);
                        atome.setpop2((int) Math.ceil((atome.popIni *
                                                       Math.exp(-(temps /
                                                                  atome.getdVie()))))); // loi decroissance radio N(t)=No*Exp(-At)

                        des = Math.abs(atome.getpop2() - atome.getpop1());
                        atomedes.setpop1(atomedes.pop2);
                        atomedes.setpop2(atomedes.getpop1() + des);
                        ListeElem.set(i, atomedes);
                        At He = ListeElem.get(posHel); // trouve �l�m Helium, pop1 pop pr�c�dente, pop2 nouvelle pop
                        He.setpop1(He.getpop2());
                        He.setpop2(He.getpop2() + des);
                        ListeElem.set(posHel, He);
                    }
                }

            }
            break;
        case 2:
            { //Beta moins
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomeprov = ListeElem.get(i);
                    if (atomeprov.getA() == (atome.getA()) & atomeprov.getZ() == (atome.getZ() + 1)) {
                        atomedes = atomeprov;
                        atome.setpop1(atome.pop2);
                        atome.setpop2((int) Math.ceil((atome.popIni *
                                                       Math.exp(-(temps /
                                                                  atome.getdVie()))))); // loi decroissance radio N(t)=No*Exp(-At)

                        des = Math.abs(atome.getpop2() - atome.getpop1());
                        atomedes.setpop1(atomedes.pop2);
                        atomedes.setpop2(atomedes.getpop1() + des);
                        ListeElem.set(i, atomedes);
                        At El = ListeElem.get(posElec); // trouve �l�m Elec, pop1 pop pr�c�dente, pop2 nouvelle pop
                        El.setpop1(El.getpop2());
                        El.setpop2(El.getpop2() + des);
                        ListeElem.set(posElec, El);
                    }
                }

            }
            break;
        case 3:
            { //Beta plus
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomeprov = ListeElem.get(i);
                    if (atomeprov.getA() == (atome.getA()) & atomeprov.getZ() == (atome.getZ() - 1)) {
                        atomedes = atomeprov;
                        atome.setpop1(atome.pop2);
                        atome.setpop2((int) Math.ceil((atome.popIni *
                                                       Math.exp(-(temps /
                                                                  atome.getdVie()))))); // loi decroissance radio N(t)=No*Exp(-At)

                        des = Math.abs(atome.getpop2() - atome.getpop1());
                        atomedes.setpop1(atomedes.pop2);
                        atomedes.setpop2(atomedes.getpop1() + des);
                        ListeElem.set(i, atomedes);
                        At Pro = ListeElem.get(posProt); // trouve �l�m Proton, pop1 pop pr�c�dente, pop2 nouvelle pop
                        Pro.setpop1(Pro.getpop2());
                        Pro.setpop2(Pro.getpop2() + des);
                        ListeElem.set(posProt, Pro);
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

    public void desint() {
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            desintAt(atome);
            atome.activite();
            atome.addPoint(); //marche pas pour le moment
            ListeElem.set(i, atome);
        }
    }

    private void Origin() {
        /*
         *Lis CSV, Cr�e liste, Cr�e tableau, le  remplit, cr�e le jTable, cr�e l'interface et la rend visible
         */
        // readCSV.convertCsvToJavaAt(ListeElem);
        readCSV.convertCsvToJavaAt2(ListeElem);
        searchPosParticule();
        majTabElem(); //rempli un tableau � partir de l'ArrayList
        //jtabElem = new JTable(tabElem, MyTableModel_1.getColumnNames()); //inutile ?

        fen = new InterfGraph();
        InterfGraph.setjTable1();
        InterfGraph.refreshTab();

        fen.setVisible(true);
        fen.setResizable(false);
        fen.revalidate();
        fen.repaint();
        SwingUtilities.updateComponentTreeUI(fen);

        timer = new Timer(T, new TimerAction()); //impl�menter timeraction Timer(T, new TimerAction())
        temps = 0;
        InterfGraph.textsetjTextField1("Timer");


    }

    public void testTimer() {
        At test = getElemListeElem(0);
        test.setA(test.getA() + 1);
        setElemListeElem(0, test);
        majTabElem();
        InterfGraph.setjTable1();
        InterfGraph.refreshTab();

    }

    public void boucle_principale() {
        /*appel&e � chaque instant t
        * r�alise la d�gradation de chaque �l�ment
        * met a jour l'activit�
        * MAJ tableau et jTable
        * rafraichit l'interface
        */
        desint();
        majTabElem();
        //jtabElem = new JTable(tabElem, MyTableModel_1.getColumnNames());
        InterfGraph.setjTable1();
        InterfGraph.refreshTab();
        fen.repaint();

    }

    public static void main(String[] args) {
        Princip Rad = new Princip();
    }

    private class TimerAction implements ActionListener {

        // ActionListener appProee tous les interval millisecondes

        public void actionPerformed(ActionEvent e) {
            boucle_principale();
            //testTimer();
            temps = temps + getdelay();
            afficheTemps();
        }

    }

    public static Object[][] fillData() {
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
            data[i][9] = atome.getpop2();
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

    /*
     * Impl�mentation Boutons
     */
    public static void testButton() {
        At test = getElemListeElem(0);
        test.setnom("coucou");
        setElemListeElem(0, test);
        test.toPrint();
        At newat = test;
        ListeElem.add(newat);
        majTabElem();
        tabToPrint(tabElem);
        InterfGraph.setjTable1();
        jtabToPrint(InterfGraph.getjTable1());
        InterfGraph.refreshTab();
    }

    public static void stopButton() {
        if (timer.isRunning()) {
            timer.stop();
        }
        setfinSim(true);
        setStartSim(false);
    }

    public static void pauseButton() {
        if (timer.isRunning() & getStartSim()) {
            timer.stop();
        }

        else if (timer.isRunning() == false & getStartSim()) {
            timer.start();
        } else {
        }

    }

    public static void playButton() {
        if (getStartSim() == false & getfinSim() == false) {
            timer.start();
            setStartSim(true);
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

    public static Object[][] gettabElem() {
        return tabElem;
    }

    public static void settabElem(Object[][] t) {
        tabElem = t;
    }

    public static boolean getStartSim() {
        return StartSim;
    }

    public static void setStartSim(boolean S) {
        StartSim = S;
    }

    public static boolean getfinSim() {
        return finSim;
    }

    public static void setfinSim(boolean f) {
        finSim = f;
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

    public static void majTabElem() {
        tabElem = fillData();
    }

    public void afficheTemps() {
        //n�cessit� de double car valmax int (2 octet) est 2147483647 et que l'on travaille en plusieurs miliards d'ann�es
        double c;
        double prov = temps;
        double an = (Math.floor(prov / (365 * 24 * 60)));
        prov = prov - an * 365 * 24 * 60;
        double jours = (Math.floor(prov / (24 * 60)));
        ;
        prov = prov - jours * 24 * 60;
        double min = (Math.floor(prov / (60)));
        ;
        prov = prov - min * 60;
        double sec = (Math.floor(prov));


        InterfGraph.textsetjTextField1(an + " ann�es " + jours + " jours " + min + " minutes " + sec + " secondes");
    }

    public static String secToTime(double s) {
        //n�cessit� de double car valmax int (2 octet) est 2147483647 et que l'on travaille en plusieurs miliards d'ann�es
        String S = "";
        double prov = s;
        double an = (Math.floor(prov / (365 * 24 * 60)));
        prov = prov - an * 365 * 24 * 60;
        double jours = (Math.floor(prov / (24 * 60)));
        ;
        prov = prov - jours * 24 * 60;
        double min = (Math.floor(prov / (60)));
        ;
        prov = prov - min * 60;
        double sec = (Math.floor(prov));
        if (an != 0) {
            S = S + an + " an ";
        }
        if (jours != 0) {
            S = S + jours + " jours ";
        }
        if (min != 0) {
            S = S + min + " min ";
        }
        if (sec != 0) {
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


//fonctions de test de bon remplissage des tableaux
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
                System.out.print(tab.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("c'�tait un jtab");
    }
}


