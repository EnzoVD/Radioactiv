
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
        PropertyChangeListener delayListener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                Object source = e.getSource();
                    if (source == jFormattedTextFieldYear || (source == jFormattedTextFieldDay & Double.parseDouble(jFormattedTextFieldDay.getText().replace(" ","")) <365 )|| (source == jFormattedTextFieldHour & Double.parseDouble(jFormattedTextFieldHour.getText().replace(" ","")) <24 )||( source == jFormattedTextFieldMin & Double.parseDouble(jFormattedTextFieldMin.getText().replace(" ","")) <60 ) ||
                        (source == jFormattedTextFieldSec & Double.parseDouble(jFormattedTextFieldSec.getText().replace(" ","")) <60 )) {
                    getDelayAffiche();
                }
            }
        };
        jTable1.getModel().addTableModelListener(this);
        jFormattedTextFieldYear.addPropertyChangeListener("value", delayListener);
        jFormattedTextFieldDay.addPropertyChangeListener("value", delayListener);
        jFormattedTextFieldHour.addPropertyChangeListener("value", delayListener);
        jFormattedTextFieldMin.addPropertyChangeListener("value", delayListener);
        jFormattedTextFieldSec.addPropertyChangeListener("value", delayListener);


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
        ElementsTable = new javax.swing.JScrollPane();
        jTable1 = new JTable(new MyTableModel_1());
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jFormattedTextFieldYear = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDay = new javax.swing.JFormattedTextField();
        jFormattedTextFieldMin = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSec = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSliderYear = new javax.swing.JSlider();
        jSliderDays = new javax.swing.JSlider();
        jSliderMinutes = new javax.swing.JSlider();
        jSliderSeconds = new javax.swing.JSlider();
        jFormattedTextFieldHour = new javax.swing.JFormattedTextField();
        jSliderHours = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();

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

        jFormattedTextFieldYear.setText("0");
        jFormattedTextFieldYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldYearPropertyChange(evt);
            }
        });
        jFormattedTextFieldYear.setBounds(1160, 700, 100, 19);
        jDesktopPane1.add(jFormattedTextFieldYear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextFieldDay.setText("0");
        jFormattedTextFieldDay.setBounds(1160, 730, 100, 19);
        jDesktopPane1.add(jFormattedTextFieldDay, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextFieldMin.setText("0");
        jFormattedTextFieldMin.setBounds(1160, 790, 100, 19);
        jDesktopPane1.add(jFormattedTextFieldMin, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextFieldSec.setText("1");
        jFormattedTextFieldSec.setBounds(1160, 820, 100, 19);
        jDesktopPane1.add(jFormattedTextFieldSec, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("1 seconde =");
        jLabel2.setBounds(1180, 660, 80, 20);
        jDesktopPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("Ann�e(s)");
        jLabel3.setBounds(1270, 700, 50, 14);
        jDesktopPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("Jour(s)");
        jLabel4.setBounds(1270, 730, 50, 14);
        jDesktopPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Minute(s)");
        jLabel5.setBounds(1270, 790, 60, 14);
        jDesktopPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("Seconde(s)");
        jLabel6.setBounds(1270, 820, 80, 14);
        jDesktopPane1.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField2.setText("jTextField2");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.setBounds(140, 880, 1140, 19);
        jDesktopPane1.add(jTextField2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSliderYear.setMaximum(30);
        jSliderYear.setValue(0);
        jSliderYear.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderYearStateChanged(evt);
            }
        });
        jSliderYear.setBounds(950, 700, 200, 16);
        jDesktopPane1.add(jSliderYear, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSliderDays.setMaximum(365);
        jSliderDays.setValue(0);
        jSliderDays.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderDaysStateChanged(evt);
            }
        });
        jSliderDays.setBounds(950, 730, 200, 16);
        jDesktopPane1.add(jSliderDays, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSliderMinutes.setMaximum(60);
        jSliderMinutes.setValue(0);
        jSliderMinutes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderMinutesStateChanged(evt);
            }
        });
        jSliderMinutes.setBounds(950, 790, 200, 16);
        jDesktopPane1.add(jSliderMinutes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSliderSeconds.setMaximum(60);
        jSliderSeconds.setValue(1);
        jSliderSeconds.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderSecondsStateChanged(evt);
            }
        });
        jSliderSeconds.setBounds(950, 820, 200, 16);
        jDesktopPane1.add(jSliderSeconds, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jFormattedTextFieldHour.setText("0");
        jFormattedTextFieldHour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldHourActionPerformed(evt);
            }
        });
        jFormattedTextFieldHour.setBounds(1160, 760, 100, 19);
        jDesktopPane1.add(jFormattedTextFieldHour, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSliderHours.setMaximum(24);
        jSliderHours.setValue(0);
        jSliderHours.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderHoursStateChanged(evt);
            }
        });
        jSliderHours.setBounds(950, 760, 200, 16);
        jDesktopPane1.add(jSliderHours, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("Heure(s)");
        jLabel7.setBounds(1270, 760, 70, 14);
        jDesktopPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        
        jPAct.setAxisLabel(0, "     Temps (sec)");
        jPAct.setAxisLabel(1, "Activit� (1/sec)");
        jPAct.setVisible(true);
        
        

        jPPop.setLayout(jPPopLayout);
        jPPopLayout.setHorizontalGroup(jPPopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                                                                                         575,
                                                                                                                         Short.MAX_VALUE));
        jPPopLayout.setVerticalGroup(jPPopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
                                                                                                                       327,
                                                                                                                       Short.MAX_VALUE));
        jPPop.setAxisLabel(0, "      Temps (sec)");
        jPPop.setAxisLabel(1, "Population");
        jPPop.setVisible(true);
       


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

    private void jFormattedTextFieldYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldYearPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldYearPropertyChange

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jFormattedTextFieldHourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldHourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldHourActionPerformed

    private void jSliderSecondsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderSecondsStateChanged
    JSlider source = jSliderSeconds;
    if (!source.getValueIsAdjusting()) {
        int sec = jSliderSeconds.getValue();
        jFormattedTextFieldSec.setText(String.valueOf(sec));
        jFormattedTextFieldSec.setValue(sec);
    }
    }//GEN-LAST:event_jSliderSecondsStateChanged

    private void jSliderMinutesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderMinutesStateChanged
    JSlider source = jSliderMinutes;
    if (!source.getValueIsAdjusting()) {
        int min = jSliderMinutes.getValue();
        jFormattedTextFieldMin.setText(String.valueOf(min));
        jFormattedTextFieldMin.setValue(min);
    }
    }//GEN-LAST:event_jSliderMinutesStateChanged

    private void jSliderHoursStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderHoursStateChanged
    JSlider source = jSliderHours;
    if (!source.getValueIsAdjusting()) {
        int hour = jSliderHours.getValue();
        jFormattedTextFieldHour.setText(String.valueOf(hour));
        jFormattedTextFieldHour.setValue(hour);
    }
    }//GEN-LAST:event_jSliderHoursStateChanged

    private void jSliderDaysStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderDaysStateChanged
        JSlider source = jSliderDays;
        if (!source.getValueIsAdjusting()) {
            int day = jSliderDays.getValue();
            jFormattedTextFieldDay.setText(String.valueOf(day));
            jFormattedTextFieldDay.setValue(day);
        }
    }//GEN-LAST:event_jSliderDaysStateChanged

    private void jSliderYearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderYearStateChanged
    JSlider source = jSliderYear;
    if (!source.getValueIsAdjusting()) {
        int year = jSliderYear.getValue();
        jFormattedTextFieldYear.setText(String.valueOf(year));
        jFormattedTextFieldYear.setValue(year);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jSliderYearStateChanged

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JScrollPane ElementsTable;
    private javax.swing.JToggleButton Pause;
    private javax.swing.JToggleButton Play;
    private javax.swing.JToggleButton Stop;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFormattedTextField jFormattedTextFieldDay;
    private javax.swing.JFormattedTextField jFormattedTextFieldHour;
    private javax.swing.JFormattedTextField jFormattedTextFieldMin;
    private javax.swing.JFormattedTextField jFormattedTextFieldSec;
    private javax.swing.JFormattedTextField jFormattedTextFieldYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSlider jSliderDays;
    private javax.swing.JSlider jSliderHours;
    private javax.swing.JSlider jSliderMinutes;
    private javax.swing.JSlider jSliderSeconds;
    private javax.swing.JSlider jSliderYear;
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
        double an = (Math.floor(t / (365 * 24 * 60 * 60)));
        t = t - an * 365 * 24 * 60*60;
        double jours = (Math.floor(t / (24 * 60 * 60)));
        t = t - jours * 24 * 60 * 60;
        double heure=(Math.floor(t / (60*60)));
        t = t - heure * 60 * 60;
        double min = (Math.floor(t / (60)));
        t = t - min * 60;
        double sec = (Math.floor(t));
        jFormattedTextFieldYear.setText(String.valueOf(an));
        jFormattedTextFieldYear.setValue(an);
        jFormattedTextFieldDay.setText(String.valueOf(jours));
        jFormattedTextFieldDay.setValue(jours);
        jFormattedTextFieldHour.setText(String.valueOf(heure));
        jFormattedTextFieldHour.setValue(heure);
        jFormattedTextFieldMin.setText(String.valueOf(min));
        jFormattedTextFieldMin.setValue(min);
        jFormattedTextFieldSec.setText(String.valueOf(sec));
        jFormattedTextFieldSec.setValue(sec);
    }

    public void getDelayAffiche() {
        double t = 0;

        double an = Double.parseDouble(jFormattedTextFieldYear.getText().replace(" ",""));
        jFormattedTextFieldYear.setValue(an);
        t = t + an * 365 * 24 * 60 * 60;
        double jours = Double.parseDouble(jFormattedTextFieldDay.getText().replace(" ",""));
        jFormattedTextFieldDay.setValue(jours);
        t = t + jours * 24 * 60 * 60;
        double heur = Double.parseDouble(jFormattedTextFieldHour.getText().replace(" ",""));
        jFormattedTextFieldHour.setValue(heur);
        t = t + heur * 60 * 60;
        double min = Double.parseDouble(jFormattedTextFieldMin.getText().replace(" ",""));
        jFormattedTextFieldMin.setValue(min);
        t = t + min * 60;
        double sec = Double.parseDouble(jFormattedTextFieldSec.getText().replace(" ",""));
        jFormattedTextFieldSec.setValue(sec);
        t = t + sec;
        Princip.setdelay(t);
        setDelayAffiche();

    }
   
    

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
            if (source == jFormattedTextFieldYear || (source == jFormattedTextFieldDay & Double.parseDouble(jFormattedTextFieldDay.getText().replace(" ","")) <365 )|| (source == jFormattedTextFieldHour & Double.parseDouble(jFormattedTextFieldHour.getText().replace(" ","")) <24 )||( source == jFormattedTextFieldMin & Double.parseDouble(jFormattedTextFieldMin.getText().replace(" ","")) <60 ) ||
                (source == jFormattedTextFieldSec & Double.parseDouble(jFormattedTextFieldSec.getText().replace(" ","")) <60 )) {
            getDelayAffiche();
            
        }
        
    }
}
