import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameActivity extends JFrame {

    JPanel mainPanel;
    JButton addButton;
    JButton searchButton;
    JButton allRecordsButton;


    void createComponents(){
        mainPanel = new JPanel();
        addButton = new JButton("Add Student+");
        searchButton = new JButton("Search");
        allRecordsButton = new JButton("Display All");

        mainPanel.setLayout(null);

        addButton.setBounds(30,50,150,150);
        searchButton.setBounds(210,50,150,150);
        allRecordsButton.setBounds(100,220,200,150);

        mainPanel.add(addButton);
        mainPanel.add(searchButton);
        mainPanel.add(allRecordsButton);

        add(mainPanel);
    }

    FrameActivity(){
        setTitle("Student Information System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,450);
        setLocation(100,100);

        createComponents();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentActivity().setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchActivity().setVisible(true);
            }
        });

        allRecordsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new DisplayAll().setVisible(true);
            }
        });

    }
}
