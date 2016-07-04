/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harish
 */
import atm.state.table.designer.Screen;
import atm.state.table.designer.State;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

public class Designer extends javax.swing.JFrame {

    public static int cursorX = 0, cursorY = 0, screenId, stateId;
    public static boolean createState = false, createScreen = false;
    public static ArrayList<Screen> screenList;
    public static ArrayList<State> stateList;
    public static ArrayList<JButton> screenViewList;
    public static ArrayList<JButton> stateViewList;
    
    DefaultMutableTreeNode statesNode, screensNode, childNode;
    JButton tempButton;
    JTextField tempTextField;
    
    public void unsetAllFlags()
    {
        createState = false;
        createScreen = false;
        createScreenButton.setBackground(Color.LIGHT_GRAY);
        createStateButton.setBackground(Color.LIGHT_GRAY);
    }
    public void setCreateStateFlag()
    {
        unsetAllFlags();
        createState = true;
        createScreenButton.setBackground(Color.LIGHT_GRAY);
        createStateButton.setBackground(Color.ORANGE);
    }
    public void setCreateScreenFlag()
    {
        unsetAllFlags();
        createScreen = true;
        createScreenButton.setBackground(Color.GREEN);
        createStateButton.setBackground(Color.LIGHT_GRAY);
    }
    public static void setCursor(int x,int y)
    {
        cursorX = x;
        cursorY = y;
    }
    public static void setCursorX(int x)
    {
        cursorX = x;
    }
    public static void setCursorY(int y)
    {
        cursorY = y;
    }
    
    /**
     * Creates new form Designer
     */
    public Designer() {
        initComponents();
        screenList = new ArrayList<Screen>();
        stateList = new ArrayList<State>();
        screenViewList = new ArrayList<JButton>();
        stateViewList = new ArrayList<JButton>();
        tempTextField = new JTextField();
        
        tempTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                System.out.println("Focus lost");
                tempTextField.setVisible(false);
                updateFrame();
            }
        });
        tempTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    System.out.println("Enter Pressed");
                    changeViewText(tempTextField.getName(), tempTextField.getText());
                    tempTextField.setVisible(false);
                }
            }
        });
    }
    
    private void updateFrame()
    {
        this.revalidate();
        this.repaint();
    }
    
    private void changeViewText(String name, String text)
    {
        System.out.println("changing view text to "+text+" for "+name);
        if(name.startsWith("state"))
        {
            int i;
            for(i=0;i<stateList.size();i++)
            {
                if(stateList.get(i).id.equals(name))
                {
                    stateList.get(i).setText(text);
                    stateViewList.get(i).setText(text);
                    
                    //stateViewList.get(i).setMargin(new Insets(0,0,0,0));
                    this.revalidate();
                    this.repaint();
                }
            }
        }
        else if(name.startsWith("screen"))
        {
            int i;
            for(i=0;i<screenList.size();i++)
            {
                if(screenList.get(i).id.equals(name))
                {
                    screenList.get(i).setText(text);
                    screenViewList.get(i).setText(text);
                    this.revalidate();
                    this.repaint();
                }
            }
        }
    }
    
    public void deleteView(JButton a)
    {
        this.remove(a);
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        createScreenButton = new javax.swing.JButton();
        createStateButton = new javax.swing.JButton();
        jTree1 = new javax.swing.JTree();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        addMenu = new javax.swing.JMenu();
        stateMenuItem = new javax.swing.JMenuItem();
        screenMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("State Table Designer");
        setBackground(new java.awt.Color(160, 160, 160));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                designerMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(160, 160, 160));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tools"));

        createScreenButton.setText("Screen");
        createScreenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createScreenClicked(evt);
            }
        });
        createScreenButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                viewDragged(evt);
            }
        });
        createScreenButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                designerScreenKeyPressed(evt);
            }
        });

        createStateButton.setText("State");
        createStateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createStateClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(createScreenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createStateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(createStateButton)
                .addGap(18, 18, 18)
                .addComponent(createScreenButton)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        createScreenButton.getAccessibleContext().setAccessibleName("createScreenButton");
        createStateButton.getAccessibleContext().setAccessibleName("createStateButton");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("State Table");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Screens");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("idle_screen");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("select_account_screen");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("pin_entry_screen");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("States");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("timeout_state");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("idle_state");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));

        menuBar.setToolTipText("");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open State Table");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        addMenu.setText("Add");

        stateMenuItem.setText("State");
        stateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(stateMenuItem);

        screenMenuItem.setText("Screen");
        screenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                screenMenuItemActionPerformed(evt);
            }
        });
        addMenu.add(screenMenuItem);

        menuBar.add(addMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                .addComponent(jTree1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTree1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void createScreenClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createScreenClicked
        // TODO add your handling code here:
        if(createScreen) {
            unsetAllFlags();
        }
        else
        {
            unsetAllFlags();
            setCreateScreenFlag();
        }
    }//GEN-LAST:event_createScreenClicked

    private void designerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_designerMouseClicked
        // TODO add your handling code here:
        Point point;
        point = evt.getPoint();
        if(createScreen)
        {
            
            Screen tempScreen = new Screen(screenId++);
            //JButton tempButton;
            tempButton = new JButton();
            tempButton.setText(tempScreen.getText());
            tempButton.setToolTipText(tempScreen.name);
            tempButton.setName(tempScreen.name);
            tempButton.setSize(120, 30);
            tempButton.setBackground(Color.GREEN);
            tempButton.setBorder(null);
            tempButton.setLocation(point.x - tempButton.getWidth()/2, point.y - 45 - tempButton.getHeight()/2);
            tempButton.setVisible(true);
            tempButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    viewClickedEvent(evt);
                }
            });
            tempButton.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    //System.out.println("Key pressed = " + evt.getKeyCode());
                    if(evt.getKeyCode() == KeyEvent.VK_DELETE)
                    {
                        //System.out.println("Delete pressed on ");
                        removeFromList(((JButton) evt.getSource()).getName());
                    }
                }
            });
            tempButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    viewDraggedEvent(evt);
                }
            });
            screenList.add(tempScreen);
            screenViewList.add(tempButton);
            unsetAllFlags();
            this.add(tempButton);
            this.revalidate();
            this.repaint();
            System.out.println("Created Screen " + tempScreen.name + ". Added Button at " + point.toString());
            
        }
        else if(createState)
        {
            State tempState = new State(stateId++);
            //JButton tempButton;
            tempButton = new JButton();
            tempButton.setText(tempState.getText());
            tempButton.setToolTipText(tempState.name);
            tempButton.setName(tempState.name);
            tempButton.setSize(120, 30);
            tempButton.setBackground(Color.ORANGE);
            tempButton.setBorder(null);
            tempButton.setLocation(point.x - tempButton.getWidth()/2, point.y - 45 - tempButton.getHeight()/2);
            tempButton.setVisible(true);
            tempButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    viewClickedEvent(evt);
                }
            });
            tempButton.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    //System.out.println("Key pressed = " + evt.getKeyCode());
                    if(evt.getKeyCode() == KeyEvent.VK_DELETE)
                    {
                        //System.out.println("Delete pressed on ");
                        removeFromList(((JButton) evt.getSource()).getName());
                    }
                }
            });
            tempButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
                public void mouseDragged(java.awt.event.MouseEvent evt) {
                    viewDraggedEvent(evt);
                }
            });
            stateList.add(tempState);
            stateViewList.add(tempButton);
            unsetAllFlags();
            this.add(tempButton);
            this.revalidate();
            this.repaint();
            System.out.println("Created State " + tempState.name + ". Added Button at " + point.toString());
        }
    }//GEN-LAST:event_designerMouseClicked

    private void moveView(java.awt.event.MouseEvent evt)
    {
        JButton j = ((JButton) evt.getSource());
        int x,y;
        x = j.getX();
        y = j.getY();
        j.setLocation(evt.getX() + x - j.getWidth() / 2, evt.getY() + y - j.getHeight() / 2);
        this.revalidate();
        this.repaint();
    }
    private void removeFromList(String name)
    {
        int i;
        if(name.startsWith("screen"))
        {
            for(i=0;i<screenList.size();i++)
            {
                if(screenList.get(i).id.equals(name))
                {
                    System.out.println(screenList.get(i).id + " removed");
                    deleteView(screenViewList.get(i));
                    screenList.remove(i);
                    screenViewList.remove(i);
                }
            }
        }
        else if(name.startsWith("state"))
        {
            for(i=0;i<stateList.size();i++)
            {
                if(stateList.get(i).id.equals(name))
                {
                    System.out.println(stateList.get(i).id + " removed");
                    deleteView(stateViewList.get(i));
                    stateList.remove(i);
                    stateViewList.remove(i);
                }
            }
        }
    }
    private void viewClickedEvent(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        JButton j = (JButton) evt.getSource();
        //System.out.println(j.getName() + " clicked");
        if(evt.getClickCount() == 2)
        {
            System.out.println(j.getName() + " double clicked");
            if(j.getName().startsWith("state"))
                tempTextField.setBackground(Color.ORANGE);
            else if(j.getName().startsWith("screen"))
                tempTextField.setBackground(Color.GREEN);
            tempTextField.setName(j.getName());
            tempTextField.setBorder(null);
            tempTextField.setSize(j.getWidth(), j.getHeight());
            //tempTextField.setLocation(j.getLocation());
            tempTextField.setLocation(150,10);
            tempTextField.setText(j.getText());
            tempTextField.setVisible(true);
            tempTextField.grabFocus();
            tempTextField.selectAll();
            
            
            //setBackground(Color.GREEN);
            //this.add(tempTextField);
            addViewToFrame(tempTextField);
            
            //this.revalidate();
            //this.repaint();
        }
        else
        {
            System.out.println(j.getName() + " clicked");
        }
    }                                    
    
    private void addViewToFrame(java.awt.Component a)
    {
        this.add(a);
        this.revalidate();
        this.repaint();
    }
    
    private void createStateClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createStateClicked
        // TODO add your handling code here:
        if(createState) {
            unsetAllFlags();
        }
        else
        {
            unsetAllFlags();
            setCreateStateFlag();
        }
    }//GEN-LAST:event_createStateClicked

    private void designerScreenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_designerScreenKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_designerScreenKeyPressed

    private void viewDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_viewDragged

    private void stateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateMenuItemActionPerformed
        // TODO add your handling code here:
        //createStateButton.doClick();
    }//GEN-LAST:event_stateMenuItemActionPerformed

    private void screenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_screenMenuItemActionPerformed
        // TODO add your handling code here:
        //createScreenButton.doClick();
    }//GEN-LAST:event_screenMenuItemActionPerformed

    private void viewDraggedEvent(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        //JButton j = (JButton) evt.getSource();
        //System.out.println(j.getToolTipText() + "   " + j.getName() + " dragged");
        moveView(evt);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Designer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Designer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Designer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Designer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Designer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenu addMenu;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JButton createScreenButton;
    private javax.swing.JButton createStateButton;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTree jTree1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem screenMenuItem;
    private javax.swing.JMenuItem stateMenuItem;
    // End of variables declaration//GEN-END:variables
}
