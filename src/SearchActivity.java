
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchActivity extends JFrame {

    JPanel mainPanel;
    JTextField firstNameField;
    JTextField lastNameField;
    JTextField rollNoField;
    JTextField marksField;
    JTextField gradeField;
    JLabel titleLabel;
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel rollNoLabel;
    JLabel marksLabel;
    JLabel gradeLabel;
    JButton modifyButton;
    JButton updateButton;
    JButton deleteButton;
    JButton searchButton;
    JButton cancelButton;

    String firstName;
    String lastName;
    String rollNo;
    String marks;
    String grade;

    public static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String> >();
    public static ArrayList<String> arrayData = new ArrayList<>();
    int index=0;
    String stuData="";

    void createComponents(){
        mainPanel = new JPanel();

        titleLabel = new JLabel("Search Records");
        firstNameLabel = new JLabel("First Name");
        lastNameLabel = new JLabel("Last Name");
        rollNoLabel = new JLabel("Roll No.");
        marksLabel = new JLabel("Marks");
        gradeLabel = new JLabel("Grade");
        firstNameField = new JTextField(50);
        lastNameField = new JTextField(50);
        rollNoField = new JTextField(50);
        marksField = new JTextField(50);
        gradeField = new JTextField(50);

        modifyButton = new JButton("Modify");
        cancelButton = new JButton("Cancel");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        searchButton = new JButton("Search");

        firstNameField.setEnabled(false);
        lastNameField.setEnabled(false);
        marksField.setEnabled(false);
        gradeField.setEnabled(false);

        mainPanel. setLayout(null);

        titleLabel.setBounds(180,30,100,30);
        rollNoLabel.setBounds(30,80,100,30);
        rollNoField.setBounds(160,80,100,30);
        searchButton.setBounds(290,80,100,30);
        deleteButton.setBounds(290,130,100,30);
        updateButton.setBounds(160,130,100,30);
        firstNameLabel.setBounds(30,200,100,30);
        firstNameField.setBounds(160,200,230,30);
        lastNameLabel.setBounds(30,260,100,30);
        lastNameField.setBounds(160,260,230,30);
        marksLabel.setBounds(30,320,100,30);
        marksField.setBounds(160,320,230,30);
        gradeLabel.setBounds(30,380,100,30);
        gradeField.setBounds(160,380,230,30);
        modifyButton.setBounds(160,450,100,30);
        cancelButton.setBounds(290,450,100,30);

        mainPanel.add(titleLabel);
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);
        mainPanel.add(rollNoLabel);
        mainPanel.add(rollNoField);
        mainPanel.add(marksField);
        mainPanel.add(marksLabel);
        mainPanel.add(gradeLabel);
        mainPanel.add(gradeField);
        mainPanel.add(modifyButton);
        mainPanel.add(searchButton);
        mainPanel.add(updateButton);
        mainPanel.add(deleteButton);
        mainPanel.add(cancelButton);
        add(mainPanel);
    }

    void fetchData(char[] array){
        ArrayList<String> list1;
        ArrayList<String> list2;
        int m=0;
        stuData = String.valueOf(array);
        list1 = new ArrayList<>(Arrays.asList(stuData.split("/")));
        for(String i : list1){
            list2 = new ArrayList<>(Arrays.asList(i.split(",")));
            if (list2.size()>1) {
                firstName = list2.get(0);
                lastName = list2.get(1);
                rollNo = list2.get(2);
                marks = list2.get(3);
                grade = list2.get(4);
                data.add(m, new ArrayList<>(Arrays.asList(firstName, lastName, rollNo, marks, grade)));
                m++;
            }
        }
    }

    void updateFile(){
        stuData = "";
        for(ArrayList<String> arrayList : data){
            for(String str : arrayList){
                stuData+=str+",";
            }
            stuData = stuData.substring(0,stuData.length()-1);
            stuData+="/";
        }
        try{
            Writer writeData = new FileWriter("Student_Records.txt");
            writeData.write(stuData);
            writeData.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    SearchActivity() {
        setTitle("Student Record");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 540);
        setLocation(100,100);

        createComponents();

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] array = new char[100];
                try {
                    Reader readData = new FileReader("Student_Records.txt");
                    readData.read(array);
                    fetchData(array);
                    rollNo = rollNoField.getText();
                    int found =0;
                    for(index=0; index < data.size();index++){
                        arrayData = data.get(index);
                        if (arrayData.get(2).equals(rollNo)){
                            firstNameField.setText(arrayData.get(0));
                            lastNameField.setText(arrayData.get(1));
                            marksField.setText(arrayData.get(3));
                            gradeField.setText(arrayData.get(4));
                            found = 1;
                            break;
                        }
                    }
                    if (found == 0){
                        JOptionPane.showMessageDialog(new JFrame(),"No record found!");
                    }
                    readData.close();

                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameField.setEnabled(true);
                lastNameField.setEnabled(true);
                gradeField.setEnabled(true);
                marksField.setEnabled(true);

            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                marks = marksField.getText();
                grade = gradeField.getText();

                arrayData.set(0,firstName);
                arrayData.set(1,lastName);
                arrayData.set(3,marks);
                arrayData.set(4,grade);

                data.set(index,arrayData);
                JOptionPane.showMessageDialog(new JFrame(),"Record updated successfully!");
                updateFile();

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrayData.clear();
                rollNoField.setText("");
                firstNameField.setText("");
                lastNameField.setText("");
                marksField.setText("");
                gradeField.setText("");
                data.remove(index);
                updateFile();
                JOptionPane.showMessageDialog(new JFrame(),"Record deleted successfully!");
            }
        });

    }
}
