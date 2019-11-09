import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import model.Driver;
import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Thu Nov 07 22:27:05 IST 2019
 */



/**
 * @author abishek Yelagani
 */
public class homePage extends JPanel {
    public static ArrayList<Driver> drivers_list = new ArrayList<>();
    homePage homePage;
    public homePage() {

        System.out.println("In homePage");
        homePage = this;
        DatabaseController databaseController = new DatabaseController();
        databaseController.initialiseDatabase();
        initComponents();
        frame1.setVisible(true);
        Driver driver1 = new Driver(1,"John","9878687654","4","A","YES");
        Driver driver2 = new Driver(2,"Paul","8787890764","4.5","A","YES");
        Driver driver3 = new Driver(3,"Noel","7878909890","4.56","B","YES");
        Driver driver4 = new Driver(4,"Steve","987658907","3.9","C","YES");
        Driver driver5 = new Driver(5,"Rebbecca","897653921","4.56","C","YES");
        Driver driver6 = new Driver(6,"Maxx","8466065461","4.3","D","YES");
        Driver driver7 = new Driver(7,"Indeevar","9490467674","5","E","YES");
        Driver driver8 = new Driver(8,"TippaRaju","9100326105","4.6","F","YES");
        Driver driver9 = new Driver(9,"Shrugnin","9100334444","4.8","F","YES");
        Driver driver10 = new Driver(10,"Ajith","9848282690","5","G","YES");
        drivers_list.add(driver1);
        drivers_list.add(driver2);
        drivers_list.add(driver3);
        drivers_list.add(driver4);
        drivers_list.add(driver5);
        drivers_list.add(driver6);
        drivers_list.add(driver7);
        drivers_list.add(driver8);
        drivers_list.add(driver9);
        drivers_list.add(driver10);
        databaseController.closeDatabaseConnection();
    }


    private void loginMouseClicked(MouseEvent e) {
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
        frame1.dispose();
    }

    private void signupMouseClicked(MouseEvent e) {
        Sign_inPage sign_inPage = new Sign_inPage();
        sign_inPage.setVisible(true);
        frame1.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - abishek Yelagani
        frame1 = new JFrame();
        button1 = new JButton();
        button2 = new JButton();

        //======== frame1 ========
        {
            frame1.setTitle("login");
            Container frame1ContentPane = frame1.getContentPane();

            //---- button1 ----
            button1.setText("LOGIN");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loginMouseClicked(e);
                }
            });

            //---- button2 ----
            button2.setText("SIGN UP");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    signupMouseClicked(e);
                }
            });

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frame1ContentPaneLayout.createSequentialGroup()
                        .addContainerGap(146, Short.MAX_VALUE)
                        .addGroup(frame1ContentPaneLayout.createParallelGroup()
                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(130, 130, 130))
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addGroup(frame1ContentPaneLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(120, Short.MAX_VALUE))
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - abishek Yelagani
    private JFrame frame1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
