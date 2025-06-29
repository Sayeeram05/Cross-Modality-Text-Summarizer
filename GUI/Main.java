import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main implements ActionListener{

    JFrame frame;
    JPanel MenuBar;
    GradientPanel ContentPanel;
    JLabel close ;
    JLabel Minmize;
    GradientButton NextButton;
    GradientButton ClearButton;
    GradientButton SearchButton;
    JLabel AddressLabel;
    JTextArea Summary;


    public Main() {
        frame = new JFrame();
        ImageIcon AppIcon = new ImageIcon(".\\lib\\AppLogo.jpg");
        NextButton = new GradientButton(Color.decode("#004FF9"), Color.decode("#000000"),10);
        ClearButton = new GradientButton(Color.decode("#BF3131"), Color.decode("#000000"),10);

        SearchButton = new GradientButton(Color.decode("#004FF9"), Color.decode("#000000"),0);

        //---------------------------------------------------F R A M E--------------------------------------------------//
        // Defining frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 
        frame.setSize(new Dimension(500,1000));  // frame size
        frame.setLocationRelativeTo(null);  // display frame in center of screen
        frame.setIconImage(AppIcon.getImage());
        frame.setLayout(new BorderLayout());
        frame.setUndecorated(true); // removes the title bar

        // Defining MenuBar
        MenuBar = new JPanel();
        MenuBar.setPreferredSize(new Dimension(500,40));
        MenuBar.setBackground(Color.WHITE);
        MenuBar.setLayout(null);

        // Defining close
        close = new JLabel(" X ");
        close.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 25));
        close.setHorizontalAlignment(JLabel.CENTER);
        close.setVerticalAlignment(JLabel.CENTER);
        close.setBounds(460, 0, 40, 40);
        close.setOpaque(true);
        close.setBackground(Color.WHITE);
        close.setForeground(Color.RED);
        close.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                closeclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                closeentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                closeexited(e);
            }
        });


        // Defining Minmize
        Minmize = new JLabel("-");
        Minmize.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
        Minmize.setHorizontalAlignment(JLabel.CENTER);
        Minmize.setVerticalAlignment(JLabel.CENTER);
        Minmize.setBounds(420, -10, 40, 50);
        Minmize.setOpaque(true);
        Minmize.setBackground(Color.WHITE);
        Minmize.setForeground(Color.BLACK);
        Minmize.addMouseListener(new java.awt.event.MouseAdapter() 
        {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                Minmizeclicked(e);
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e)
            {
                Minmizeentered(e);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e)
            {
                Minmizeexited(e);
            }
        });

        MenuBarLogo LogoLabel = new MenuBarLogo();
        LogoLabel.setIcon(AppIcon);
        LogoLabel.setBounds(5,5,30,30);

        

        MenuBar.add(close);
        MenuBar.add(Minmize);
        MenuBar.add(LogoLabel);

        ContentPanel = new GradientPanel(Color.decode("#000000"),Color.decode("#434343"),0);
        ContentPanel.setPreferredSize(new Dimension(500,0));
        ContentPanel.setLayout(null);

        // Content Panel Lables

        JLabel SumaryLabel = new JLabel("SUMMARIZER");

        SumaryLabel.setFont(new Font("Roboto", Font.BOLD, 40));
        SumaryLabel.setForeground(Color.decode("#006BFF")); 
        SumaryLabel.setBounds(100, 10, 300, 45);
        // SumaryLabel.setBackground(Color.BLACK);
        // SumaryLabel.setOpaque(true);
        SumaryLabel.setHorizontalAlignment(JLabel.CENTER);
        SumaryLabel.setVerticalAlignment(JLabel.CENTER);

        JLabel UploadLabel = new JLabel("UPLOAD IMAGE");

        UploadLabel.setFont(new Font("Roboto", Font.BOLD, 20));
        UploadLabel.setForeground(Color.decode("#006BFF"));
        UploadLabel.setBounds(10, 100, 160, 30);
        // UploadLabel.setBackground(Color.BLACK);
        // UploadLabel.setOpaque(true);
        UploadLabel.setHorizontalAlignment(JLabel.CENTER);
        UploadLabel.setVerticalAlignment(JLabel.CENTER);


        AddressLabel = new JLabel("Choose The Image");

        AddressLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
        AddressLabel.setForeground(new Color(6, 143, 255));
        AddressLabel.setBounds(10, 140, 425, 40);
        AddressLabel.setBackground(Color.BLACK);
        AddressLabel.setOpaque(true);
        AddressLabel.setHorizontalAlignment(JLabel.LEFT);
        AddressLabel.setVerticalAlignment(JLabel.CENTER);

        SearchButton.setBounds(440, 140, 50, 41);
        SearchButton.setBorder(BorderFactory.createEmptyBorder());
        SearchButton.setIcon(new ImageIcon(".\\lib\\Search.png"));
        SearchButton.setFont(new Font("Roboto", Font.BOLD, 30));
        SearchButton.setForeground(new Color(240, 240, 240));
        SearchButton.setFocusable(false);
        SearchButton.addActionListener(this);


        // Save Button
        NextButton.setBounds(320, 200, 170, 45);
        NextButton.setBorder(BorderFactory.createEmptyBorder());
        NextButton.setText("NEXT");
        NextButton.setFont(new Font("Roboto", Font.BOLD, 30));
        NextButton.setForeground(new Color(240, 240, 240));
        NextButton.setFocusable(false);
        NextButton.addActionListener(this);

        // Clear Button
        ClearButton.setBounds(130, 200, 170, 45);
        ClearButton.setBorder(BorderFactory.createEmptyBorder());
        ClearButton.setText("CLEAR");
        ClearButton.setFont(new Font("Roboto", Font.BOLD, 30));
        ClearButton.setForeground(new Color(240, 240, 240));
        ClearButton.setFocusable(false);
        ClearButton.addActionListener(this);

        JLabel SummaryLabel = new JLabel("SUMMARY");

        SummaryLabel.setFont(new Font("Roboto", Font.BOLD, 25));
        SummaryLabel.setForeground(Color.decode("#006BFF"));
        SummaryLabel.setBounds(10, 270, 150, 30);
        // SummaryLabel.setBackground(Color.BLACK);
        // SummaryLabel.setOpaque(true);
        // SummaryLabel.setHorizontalAlignment(JLabel.CENTER);
        SummaryLabel.setVerticalAlignment(JLabel.CENTER);

        JPanel SummaryBasePanel = new JPanel();
        SummaryBasePanel.setBounds(10,310,480,640);
        SummaryBasePanel.setOpaque(false);

        Summary = new JTextArea();
        Summary.setFont(new Font("Roboto", Font.PLAIN, 18));
        Summary.setForeground(new Color(6, 143, 255));
        Summary.setBackground(Color.BLACK);
        Summary.setOpaque(true);
        Summary.setLineWrap(true);
        Summary.setEditable(false);
        Summary.setFocusable(false);;

        String Text = "Business Case Development for Online Cooking Companion  1. Introduction In today’s fast-paced world, many individuals struggle with meal planning, finding suitable recipes, and sourcing necessary ingredients efficiently. Online resources often provide lengthy recipe blogs filled with unnecessary details, making it difficult to access the required information quickly. Additionally, users may lack essential ingredients and find it inconvenient to order them manually. This business case outlines the need for an AI-powered chatbot that offers personalized, text-based recipe suggestions and seamless integration with Swiggy for ingredient ordering.  2. Aim The primary aim of this project is to develop an AI-based chatbot that assists users in meal preparation by: Providing recipe suggestions based on available ingredients. Offering step-by-step, text-based cooking instructions. Enabling seamless ordering of missing ingredients through Swiggy integration.  3. Problem Statement Users face multiple challenges in their cooking journey, including: Difficulty in deciding what to cook with available ingredients. The hassle of searching for step-by-step recipes in long, cluttered online blogs. The inconvenience of manually listing and sourcing missing ingredients from grocery stores or apps. Lack of a structured, distraction-free, and efficient cooking assistant.  4. Project Identification  4.1 Project Name Wichita: AI-Powered Cooking Assistant  4.2 Target Users Home cooks looking for quick and easy meal ideas. Busy professionals who need efficient cooking solutions. Cooking enthusiasts eager to explore new recipes. Individuals with dietary preferences seeking personalized suggestions.  4.3 Key Features Recipe search and suggestions based on available ingredients. Text-based cooking instructions for a distraction-free experience. Ingredient list generation with Swiggy integration for quick ordering. Dietary filters to accommodate user preferences. User-friendly chatbot interface for seamless interaction.  5. Business Case Development  5.1 Market Need A significant number of users seek quick, structured, and distraction-free recipe suggestions. Existing solutions involve either extensive blogs, video tutorials, or cluttered mobile apps. A dedicated chatbot offering text-based instructions and ingredient management fills this gap effectively.  5.2 Solution An AI-driven chatbot that provides step-by-step cooking guidance in text format and seamlessly connects with Swiggy for missing ingredient orders.  5.3 Competitive Advantage Text-based and distraction-free: Unlike video tutorials or lengthy blogs, the chatbot delivers concise, actionable steps. Ingredient-based recipe suggestions: Users receive meal recommendations based on what they have. Swiggy integration: Simplifies the process of sourcing missing ingredients.  6. Approach & Implementation Plan  6.1 Development Phases Requirement Gathering: Understand user needs and define core functionalities. AI Model Development: Train an AI model to match ingredients with suitable recipes. Chatbot Development: Implement a user-friendly text-based interface. Swiggy API Integration: Enable seamless ingredient ordering. Testing & Optimization: Ensure accuracy, usability, and performance. Deployment & Marketing: Launch the chatbot and promote its benefits.  6.2 Implementation Steps User Input Handling: Users enter available ingredients. AI processes inputs and matches them with relevant recipes. Recipe Recommendation: Provide multiple dish options. Allow users to refine searches using dietary preferences. Cooking Instructions: Display structured, step-by-step text-based guidance. Ingredient Ordering via Swiggy: Identify missing ingredients. Provide an option to order them through Swiggy.  7. User Stories  7.1 User Story 1: Recipe Suggestion Based on Ingredients As a user, I want to input my available ingredients into the chatbot, So that I can receive suitable recipe suggestions and step-by-step cooking instructions.  Acceptance Criteria: Users enter ingredient names, and the chatbot returns relevant recipes. Recipes include a structured ingredient list and instructions. The chatbot filters results based on dietary preferences if selected.  7.2 User Story 2: Swiggy Integration for Ingredient Ordering As a user, I want to order missing ingredients directly from the chatbot, So that I can quickly source what I need without leaving the app.  Acceptance Criteria: The chatbot identifies missing ingredients from the selected recipe. Users receive an option to order directly from Swiggy. Clicking “Order Ingredients” redirects users to Swiggy with pre-filled items.  8. Product Vision Template  8.1 Aim To develop an AI-powered chatbot that provides personalized cooking guidance, simp";
        Summary.setText(Text);

        JScrollPane SummaryMainPanel = new JScrollPane(Summary);
        SummaryMainPanel.setPreferredSize(new Dimension(480,630));
        SummaryMainPanel.setBorder(BorderFactory.createEmptyBorder());
        


        SummaryBasePanel.add(SummaryMainPanel);


        ContentPanel.add(AddressLabel);
        ContentPanel.add(UploadLabel);
        ContentPanel.add(SumaryLabel);
        ContentPanel.add(NextButton);
        ContentPanel.add(ClearButton);
        ContentPanel.add(SearchButton);
        ContentPanel.add(SummaryLabel);
        ContentPanel.add(SummaryBasePanel);


        frame.add(MenuBar,BorderLayout.NORTH);
        frame.add(ContentPanel,BorderLayout.WEST);

        frame.setVisible(true);
    }


    


    //--------------------------------------------M O U S E L I S T E N E R-------------------------------------------//

    // Close
    public void closeclicked(java.awt.event.MouseEvent e)
    {
        frame.dispose();
    }
    public void closeentered(java.awt.event.MouseEvent e)
    {
        close.setForeground(Color.BLACK);
        close.setBackground(Color.RED);
    }
    public void closeexited(java.awt.event.MouseEvent e)
    {
        close.setForeground(Color.RED);
        close.setBackground(Color.WHITE);
    }

    // Minmize
    public void Minmizeclicked(java.awt.event.MouseEvent e)
    {
        frame.setExtendedState(1);
    }
    public void Minmizeentered(java.awt.event.MouseEvent e)
    {
        Minmize.setForeground(Color.WHITE);
        Minmize.setBackground(Color.BLACK);
    }
    public void Minmizeexited(java.awt.event.MouseEvent e)
    {
        Minmize.setForeground(Color.BLACK);
        Minmize.setBackground(Color.WHITE);
    }
    
    
    //--------------------------------------------A C T I O N L I S T E N E R-------------------------------------------//
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == NextButton){
            String ImgPath = AddressLabel.getText();
            if(ImgPath.isBlank() | ImgPath.equals("Choose The Image")){
                System.out.println("No image selected.");
                new MessageBox("File Selection", "Invalid Or Empty Path");
            }
            else{
                System.out.println("OCR Model");
               
                try {
                    File scriptDir = new File("D:\\GitHub\\Cross Modality Text Summarizer");

                    ProcessBuilder pb = new ProcessBuilder(
                        "C:\\Users\\SAYEERAM\\anaconda3\\envs\\Main\\python.exe","Main.py"
                    );
                    pb.directory(scriptDir);
                    pb.redirectErrorStream(true);
                
                    Process process = pb.start();
                
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
                    writer.write(ImgPath);
                    writer.flush();
                    writer.close();
                
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    // String line;
                    // while ((line = reader.readLine()) != null) {
                    //     System.out.println("Python returned: " + line);
                    // }
                    
                    String Smry = reader.readLine();
                    
                    Summary.setText(Smry);

                    int exitCode = process.waitFor();
                    System.out.println("Python script exited with code " + exitCode);
                
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if(e.getSource() == SearchButton){
            AddressLabel.setText("");
            Summary.setText("");
            
            File homeDir = new File("C:\\Users\\SAYEERAM\\OneDrive\\Pictures");
            JFileChooser fileChooser = new JFileChooser(homeDir);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg");

            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected image: " + selectedFile.getAbsolutePath());
                AddressLabel.setText(selectedFile.getAbsolutePath());

            } else {
                System.out.println("No image selected.");
                new MessageBox("File Selection", "Invalid Or Empty Path");
            }
        }
        if(e.getSource() == ClearButton){
            AddressLabel.setText("");
            Summary.setText("");
        }
    }
    
    public static void main(String[] args) {
        new Main();
    }
}
