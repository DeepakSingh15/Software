import javax.swing.*;

public class DisplayAll extends JFrame {

    JTable recordTable;
    JScrollPane jScrollPane;

    DisplayAll(){
        setTitle("Display Record");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 540);
        setLocation(100,100);

        String columm[] = {"First Name","Last Name","Roll No","Marks","Grade"};
        System.out.println(SearchActivity.data);


    }

}
