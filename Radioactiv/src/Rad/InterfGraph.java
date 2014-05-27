
package Rad;
//change2
import javax.swing.JSlider;
import javax.swing.JTable;

import Rad.MyTableModel_1;


import java.awt.Color;

import java.beans.PropertyChangeEvent;

import java.beans.PropertyChangeListener;

import java.util.EventListener;

import org.math.plot.*;

import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


/**
 *
 * @author ENZO
 */

public class InterfGraph extends javax.swing.JFrame implements TableModelListener, PropertyChangeListener {

    protected Plot2DPanel jPPop = new Plot2DPanel();
    protected Plot2DPanel jPAct = new Plot2DPanel();

    /** Creates new form InterfGraph */
    public InterfGraph() {
        initComponents();
        customInitComponents();
        getDelayAffiche();
        PropertyChangeListener delayListener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                Object source = e.getSource();
                if (source == jFormattedTextField1 || source == jFormattedTextField2 ||
                    source == jFormattedTextField3 || source == jFormattedTextField4) {
                    getDelayAffiche();
                }
            }
        };
        jTable1.getModel().addTableModelListener(this);
        jFormattedTextField1.addPropertyChangeListener("value", delayListener);
        jFormattedTextField2.addPropertyChangeListener("value", delayListener);
        jFormattedTextField3.addPropertyChangeListener("value", delayListener);
        jFormattedTextField4.addPropertyChangeListener("value", delayListener);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    
    
    
    private void initComponents() {//GEN-BEGIN:initComponents

        menuInit = new javax.swing.JPopupMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        Play = new javax.swing.JToggleButton();
        Stop = new javax.swing.JToggleButton();
        Pause = new javax.swing.JToggleButton();
        jSlideVitesse = new JSlider(JSlider.HORIZONTAL,1, 100000000, 1000);
        ElementsTable = new javax.swing.JScrollPane();
        jTable1 = new JTable(new MyTableModel_1());
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(153, 204, 255));
        jDesktopPane1.setBorder(new javax.swing.border.MatteBorder(null));

        Play.setText("Commencer la Simulation");
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        Play.setBounds(30, 780, 170, 21);
        jDesktopPane1.add(Play, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Stop.setText("Fin");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });
        Stop.setBounds(460, 780, 160, 21);
        jDesktopPane1.add(Stop, javax.swing.JLayeredPane.DEFAULT_LAYER);

        Pause.setText("Pause/Reprendre");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });
        Pause.setBounds(240, 780, 170, 21);
        jDesktopPane1.add(Pause, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSlideVitesse.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlideVitesseStateChanged(evt);
            }
        });
        jSlideVitesse.setBounds(30, 860, 1330, 16);
        jDesktopPane1.add(jSlideVitesse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.getTableHeader().setReorderingAllowed(false);
        ElementsTable.setViewportView(jTable1);
        //Princip.jtabToPrint(jTable1); //test

        ElementsTable.setBounds(640, 30, 720, 520);
        jDesktopPane1.add(ElementsTable, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(660, 780, 55, 21);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField1.setText("0");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.setBounds(140, 820, 640, 20);
        jDesktopPane1.add(jTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Temps Ecoul�");
        jLabel1.setBounds(40, 820, 80, 20);
        jDesktopPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("Reset All");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(770, 780, 130, 21);
        jDesktopPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane1.setBounds(30, 30, 580, 350);
        jDesktopPane1.add(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane1.addTab("Population", jPPop);
        jTabbedPane2.setBounds(30, 400, 580, 350);
        jDesktopPane1.add(jTabbedPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTabbedPane2.addTab("Activit�", jPAct);

        jFormattedTextField1.setText("0");
        jFormattedTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextField1PropertyChange(evt);
            }
        });
        jFormattedTextField1.setBounds(1160, 730, 10, 19);
        jDesktopPane1.add(jFormattedTextField1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextField2.setText("0");
        jFormattedTextField2.setBounds(1160, 760, 10, 19);
        jDesktopPane1.add(jFormattedTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextField3.setText("0");
        jFormattedTextField3.setBounds(1160, 790, 10, 19);
        jDesktopPane1.add(jFormattedTextField3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextField4.setText("1");
        jFormattedTextField4.setBounds(1160, 820, 10, 19);
        jDesktopPane1.add(jFormattedTextField4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("1 seconde =");
        jLabel2.setBounds(1180, 700, 80, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Ann�e(s)");
        jLabel3.setBounds(1290, 730, 50, 14);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Jour(s)");
        jLabel4.setBounds(1290, 760, 40, 14);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Minute(s)");
        jLabel5.setBounds(1290, 790, 50, 14);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("Seconde(s)");
        jLabel6.setBounds(1290, 820, 60, 14);
        jDesktopPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.setBounds(140, 880, 1140, 19);
        jDesktopPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents


    protected void customInitComponents() {


        javax.swing.GroupLayout jPActLayout = new javax.swing.GroupLayout(jPAct);
        javax.swing.GroupLayout jPPopLayout = new javax.swing.GroupLayout(jPPop);
        jPAct.setLayout(jPActLayout);
        jPActLayout.setHorizontalGroup(jPActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                                                                                         575,
                                                                                                                         Short.MAX_VALUE));
        jPActLayout.setVerticalGroup(jPActLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                                                                                       327,
                                                                                                                       Short.MAX_VALUE));
        jPAct.setVisible(true);
        System.out.println("JPact Initialis�");

        jPPop.setLayout(jPPopLayout);
        jPPopLayout.setHorizontalGroup(jPPopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                                                                                         575,
                                                                                                                         Short.MAX_VALUE));
        jPPopLayout.setVerticalGroup(jPPopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                                                                                       327,
                                                                                                                       Short.MAX_VALUE));
        jPPop.setVisible(true);
        System.out.println("JPop Initialis�");


    }
    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        Princip.playButton();
    }//GEN-LAST:event_PlayActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        Princip.stopButton();
    }//GEN-LAST:event_StopActionPerformed

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        Princip.pauseButton();
    }//GEN-LAST:event_PauseActionPerformed

    private void jSlideVitesseStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlideVitesseStateChanged
        
        JSlider source = jSlideVitesse;
        if (!source.getValueIsAdjusting()) {
            double Vit = (double) source.getValue() / 1000;
            
             Princip.setdelay( ((Vit) * Princip.getT()));
            setDelayAffiche();
            System.out.println(Princip.getdelay());
        }
         
        
    }//GEN-LAST:event_jSlideVitesseStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Princip.testButton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Princip.resetButton();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jFormattedTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextField1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField1PropertyChange

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JScrollPane ElementsTable;
    private javax.swing.JToggleButton Pause;
    private javax.swing.JToggleButton Play;
    private javax.swing.JToggleButton Stop;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextField2;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSlider jSlideVitesse;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    protected static javax.swing.JTable jTable1;
    protected static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JPopupMenu menuInit;
    // End of variables declaration//GEN-END:variables
   

    public static JTable getjTable1() {
        return jTable1;
    }

    public static void setjTable1() { //rempli et rafraichit l'affichage du tableau � l'aide de la liste

        fillTable(jTable1);
        refreshTab();
    }

    public static void fillTable(JTable table) {
        Object[][] tableprov = Princip.listTo2dTab(); // permet d'appeler une seule fois listTo2dTab
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt(tableprov[i][j], i, j);
            }
        }
    }


    public static void refreshTab() {
        jTable1.revalidate();

    }

    public static void textsetjTextField1(String t) {
        jTextField1.setText(t);
    }


    public static void clearTable(JTable table) {
        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                table.setValueAt("", i, j);
            }
        }
    }

    public void setjPPop(String s, double[] x, double[] y) {
        jPPop.removeAllPlots();
        jPPop.addLinePlot(s, Color.red, x, y);
        jPPop.repaint();
        System.out.println("JPop set");
    }

    public void setjPAct(String s, double[] x, double[] y) {
        jPAct.removeAllPlots();
        jPAct.addLinePlot(s, Color.red, x, y);
        jPAct.repaint();
        System.out.println("JAct set");
    }


    @Override
    public void tableChanged(TableModelEvent e) {
        /*
         * Les 2 colonnes modifiables sont la 1: affiche et la 8, popini, modifiable avant le d�marrage.
         * dans 1, la valeur est boolean, dans 8 enti�re.
         * on met a jour les valeurs dans l'arraylist, puis on recr�e le tableau.
         * TODO:
         */
        if (Princip.getfinInit()) {
            int row = e.getFirstRow();
            int column = e.getColumn();
            MyTableModel_1 model = (MyTableModel_1) e.getSource();
            String columnName = model.getColumnName(column);
            Object data = model.getValueAt(row, column);

            switch (column) {
            case 0:
                {
                    int pos = Princip.searchAfficheTrue();
                    boolean value = (Boolean) data;
                    if (value == true) {
                        if (Princip.searchAfficheTrue() != -1 & Princip.countAfficheTruejT() == 2) {

                            if (pos != row) {
                                jTable1.setValueAt(false, pos, 0);
                                At prov = Princip.getElemListeElem(pos);
                                prov.setaffiche(false);
                                Princip.setElemListeElem(pos, prov);
                            }
                            At prov2 = Princip.getElemListeElem(row);
                            prov2.setaffiche(true);
                            Princip.setElemListeElem(row, prov2);
                        }
                        if (Princip.searchAfficheTrue() == -1) {
                            At prov2 = Princip.getElemListeElem(row);
                            prov2.setaffiche(true);
                            Princip.setElemListeElem(row, prov2);

                        }
                        pos = row;
                    } else if (value == false) {
                        At prov2 = Princip.getElemListeElem(row);
                        prov2.setaffiche(false);
                        Princip.setElemListeElem(row, prov2);
                    }

                }
                break;

            case 8:
                {
                    double value = (Double) data;
                    At prov = Princip.getElemListeElem(row);
                    prov.setpopIni(value);
                    if(Princip.getstartSim()==false){prov.setpopAct(value);}
                    Princip.setElemListeElem(row, prov);

                }
                break;

            }
        }
    }

    public void updateDelay() {
        setDelayAffiche();
        getDelayAffiche();
        
    }
    //affiche le delay dans les cases en bas � droite de l'interface: jformated textfields
    public void setDelayAffiche() {
        double t = Princip.getdelay();
        double an = (Math.floor(t / (365 * 24 * 60)));
        t = t - an * 365 * 24 * 60;
        double jours = (Math.floor(t / (24 * 60)));
        ;
        t = t - jours * 24 * 60;
        double min = (Math.floor(t / (60)));
        ;
        t = t - min * 60;
        double sec = (Math.floor(t));
        jFormattedTextField1.setText(String.valueOf(an));
        jFormattedTextField1.setValue(an);
        jFormattedTextField2.setText(String.valueOf(jours));
        jFormattedTextField2.setValue(jours);
        jFormattedTextField3.setText(String.valueOf(min));
        jFormattedTextField3.setValue(min);
        jFormattedTextField4.setText(String.valueOf(sec));
        jFormattedTextField4.setValue(sec);
    }

    public void getDelayAffiche() {
        double t = 0;

        double an = Double.parseDouble(jFormattedTextField1.getText().replace(" ",""));
        jFormattedTextField1.setValue(an);
        t = t + an * 365 * 24 * 60;
        double jours = Double.parseDouble(jFormattedTextField2.getText().replace(" ",""));
        jFormattedTextField2.setValue(jours);
        t = t + jours * 24 * 60;
        double min = Double.parseDouble(jFormattedTextField3.getText().replace(" ",""));
        jFormattedTextField3.setValue(min);
        t = t + min * 60;
        double sec = Double.parseDouble(jFormattedTextField4.getText().replace(" ",""));
        jFormattedTextField4.setValue(sec);
        t = t + sec;
        Princip.setdelay(t);
        setDelayAffiche();

    }
   
    

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == jFormattedTextField1 || source == jFormattedTextField2 || source == jFormattedTextField3 ||
            source == jFormattedTextField4) {
            
            
        }
        
    }
}
