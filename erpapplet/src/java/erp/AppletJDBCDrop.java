package erp;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class AppletJDBCDrop extends JApplet implements ActionListener {

  private Connection connection;

  private JList tableList;

  private JButton dropButton;

  public void init() {
    
    Container c = getContentPane();
    tableList = new JList();
    //loadTables();
    c.add(new JScrollPane(tableList), BorderLayout.NORTH);

    dropButton = new JButton("Drop Table");
    dropButton.addActionListener(this);
    c.add(dropButton, BorderLayout.SOUTH);
  Connection connection;
    try {
            System.out.println("hi");
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
      connection = DriverManager.getConnection("jdbc:derby://localhost:1527/signupinfo");

    } catch (Exception connectException) {
      connectException.printStackTrace();
    }

  }

  public void actionPerformed(ActionEvent e) {
    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("DROP TABLE "
          + tableList.getSelectedValue());
    } catch (SQLException actionException) {
    }
  }

  private void loadTables() {
    Vector v = new Vector();
    try {
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("SHOW TABLES");

      while (rs.next()) {
        v.addElement(rs.getString(1));
      }
      rs.close();
    } catch (SQLException e) {
    }
    v.addElement("acc_acc");
    v.addElement("acc_add");
    v.addElement("junk");
    tableList.setListData(v);
  }
}

/*

<html>
<applet code="Drop.class" width=200 height=200>
</applet>
</html>

*/
