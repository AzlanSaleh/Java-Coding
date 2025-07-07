import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class StudentInformationSystem extends JFrame {
    private JTextField txtId, txtName, txtAge;
    private JRadioButton rbMale, rbFemale, rbOther;
    private JComboBox<String> cbCourse;
    private JTextArea textArea;
    private ButtonGroup genderGroup;

    public StudentInformationSystem() {
        setTitle("Student Information Management System");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Student ID:"), gbc);

        gbc.gridx = 1;
        txtId = new JTextField(15);
        add(txtId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Student Name:"), gbc);

        gbc.gridx = 1;
        txtName = new JTextField(15);
        add(txtName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Age:"), gbc);

        gbc.gridx = 1;
        txtAge = new JTextField(5);
        add(txtAge, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Gender:"), gbc);

        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        rbOther = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        genderGroup.add(rbOther);
        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);
        genderPanel.add(rbOther);
        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Course:"), gbc);

        gbc.gridx = 1;
        cbCourse = new JComboBox<>(new String[]{"Computer Science", "Electrical Engineering", "Business"});
        add(cbCourse, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnSubmit = new JButton("Submit");
        JButton btnDisplay = new JButton("Display");
        JButton btnClear = new JButton("Clear");
        buttonPanel.add(btnSubmit);
        buttonPanel.add(btnDisplay);
        buttonPanel.add(btnClear);
        add(buttonPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        textArea = new JTextArea(5, 30); // Reduced rows and columns for a smaller display field
        add(new JScrollPane(textArea), gbc);

        btnSubmit.addActionListener(e -> saveStudent());
        btnDisplay.addActionListener (e -> displayStudents());
        btnClear.addActionListener(e -> clearForm());

        setVisible(true);
    }

    private void saveStudent() {
        String id = txtId.getText().trim();
        String name = txtName.getText().trim();
        String ageStr = txtAge.getText().trim();
        String gender = rbMale.isSelected() ? "Male" : rbFemale.isSelected() ? "Female" : rbOther.isSelected() ? "Other" : "";
        String course = (String) cbCourse.getSelectedItem();

        if (id.isEmpty() || name.isEmpty() || ageStr.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields correctly.");
            return;
        }

        try {
            int age = Integer.parseInt(ageStr);
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
            writer.write(id + "," + name + "," + age + "," + gender + "," + course);
            writer.newLine();
            writer.close();
            JOptionPane.showMessageDialog(this, "Student saved successfully.");
            clearForm();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Age must be a number.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving student: " + e.getMessage());
        }
    }

    private void displayStudents() {
        textArea.setText("");
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "students.txt not found.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage());
        }
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");
        genderGroup.clearSelection();
        cbCourse.setSelectedIndex(0);
        textArea.setText("");
    }

    public static void main(String[] args) {
        new StudentInformationSystem();
    }
}