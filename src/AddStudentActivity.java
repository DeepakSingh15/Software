import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class AddStudentActivity extends JFrame {

    JPanel mainPanel;
    JTextField firstNameField;
    JTextField lastNameField;
    JTextField rollNoField;
    JTextField marksField;
    JTextField gradeField;
    JLabel firstNameLabel;
    JLabel lastNameLabel;
    JLabel rollNoLabel;
    JLabel marksLabel;
    JLabel gradeLabel;
    JButton addButton;
    JButton cancelButton;

    String firstName;
    String lastName;
    String rollNo;
    String marks;
    String grade;

    void createComponents(){
        mainPanel = new JPanel();

        firstNameLabel = new JLabel("Enter First Name");
        lastNameLabel = new JLabel("Enter last Name");
        rollNoLabel = new JLabel("Roll No.");
        marksLabel = new JLabel("Enter Marks");
        gradeLabel = new JLabel("Grade");

        firstNameField = new JTextField(50);
        lastNameField = new JTextField(50);
        rollNoField = new JTextField(50);
        marksField = new JTextField(50);
        gradeField = new JTextField(50);

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");

        mainPanel. setLayout(null);

        firstNameLabel.setBounds(30,30,200,30);
        firstNameField.setBounds(290,30,200,30);
        lastNameLabel.setBounds(30,110,200,30);
        lastNameField.setBounds(290,110,200,30);
        rollNoLabel.setBounds(30,190,200,30);
        rollNoField.setBounds(290,190,200,30);
        marksLabel.setBounds(30,260,200,30);
        marksField.setBounds(290,260,200,30);
        gradeLabel.setBounds(30,330,200,30);
        gradeField.setBounds(290,330,200,30);
        addButton.setBounds(260,420,100,40);
        cancelButton.setBounds(390,420,100,40);

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
        mainPanel.add(addButton);
        mainPanel.add(cancelButton);
        add(mainPanel);
    }

    void clearField(){
        firstNameField.setText("");
        lastNameField.setText("");
        rollNoField.setText("");
        marksField.setText("");
        gradeField.setText("");
    }

    AddStudentActivity() {
        setTitle("Add New Student");
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                marks = marksField.getText();
                rollNo = rollNoField.getText();
                grade = gradeField.getText();
                Student student = new Student(firstName,lastName,rollNo,marks,grade);


                try {
                    File file = new File("Student_Records.txt");
                    if (!file.exists()){
                        file.createNewFile();
                    }
                    Writer writeData = new FileWriter(file.getAbsoluteFile(),true);
                    writeData.write(String.valueOf(student));

                    JOptionPane.showMessageDialog(new JFrame(),"Student data added successfully.");
                    clearField();
                    writeData.close();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
    }
}

