package com.nono.groupproject;

import javax.swing.*;
import java.awt.*;

public class DisasterGuideGUI extends JFrame {
 
/*    public static void main(String[] args) {
        new DisasterGuideGUI();
}*/
    
    public DisasterGuideGUI() {
        this.setTitle("Disaster Guide");
        this.setDefaultCloseOperation (JFrame.HIDE_ON_CLOSE);
       
        this.setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Disaster Guide",SwingConstants.CENTER);
                
        JTextArea textArea = new JTextArea(15, 40);
        textArea.setEditable(false);
               
        JButton LAButton = new JButton("Local Authorities Contact Info");
        LAButton.addActionListener(e -> showLAContacts(textArea));
         
        JButton ECButton = new JButton("Emergency Contact Info");
        ECButton.addActionListener(e -> showECContacts(textArea));
        
        JButton disasterPreparednessButton = new JButton("Disaster Preparedness Guide");
        disasterPreparednessButton.addActionListener(e -> showDisasterPreparednessGuide(textArea));
        
        JButton disasterRecoveryButton = new JButton("Disaster Recovery Guide");
        disasterRecoveryButton.addActionListener(e -> showDisasterRecoveryGuide(textArea));
              
        JButton rButton = new JButton("Return");
        rButton.addActionListener(e -> dispose());
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JScrollPane(textArea));
        
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(LAButton);
        
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(ECButton);
        
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(disasterPreparednessButton);
        
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(disasterRecoveryButton);
        
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(rButton);

        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);    
}
    
    private void showLAContacts(JTextArea textArea) {
    String LAContacts = """
    Local Authorities Contact Information:
                            
    - Kuala Lumpur
      Kuala Lumpur Hospital: 03 4023 2966
    - Putrajaya
      Hospital Putrajaya: 03 8312 4200
    - Selangor                        
      Hospital Ampang: 03 4289 6000
    - Johor Bahru
      Hospital Sultanah Aminah: 07 2257000 
    - Sarawak
      Hospital Umum Sarawak: 082 242751
    - Melaka
      Hospital Melaka: 06 2822344                       
""";
    textArea.setText(LAContacts);
}
    
    private void showECContacts(JTextArea textArea) {
    String ECContacts = """
    Emergency Contact Information:   
                                                        
    Police & Ambulance Department Hotline: 999
    Fire and Rescue Department Hotline: 994
    Subang Jaya Police Station: 03 5633 2222
    Kuala Lumpur Police Station: 03 9221 2222
    Putra Jaya Police Station: 03 8886 2222
    Shah Alam Police Station: 03 5520 2222
    Selangor Police Station: 03 7966 2164                                           
""";
    textArea.setText(ECContacts);
}

    private void showDisasterPreparednessGuide(JTextArea textArea) {
    String DisasterPreparednessGuide = """
    Disaster Preparedness Guide:  
                                               
    1. Prepare an emergency kit.
    2. Create a family emergency plan.                              
    3. Know the evacuation routes.
    4. Secure your home before any disaster happens.
    5. Stay informed about potential disasters.
    6. Practice emergency drills with your family.
    7. Learn basic first aid and CPR.
    8. Prepare important documents and keep them safe.
    9. Stay connected with neighbors and community.
    10. Identify any potential hazards.
    11. Review and update your insurance coverage to ensure it covers yours.    
    12. Be aware & compile a list of emergency contacts.
    13. Try to adapt to speific disaster. 
    14. Practice regularly with your friends and families to ensure anyone know what to do.         
    15. Use technology to stay informed such as any disaster, weather forecast, alerts, and disaster notifications.
    16. Secure water and food supplies to ensure you have enough provisions to last several days in case of an emergency.                                                                                                                                                                                                    
""";
    textArea.setText(DisasterPreparednessGuide);
}
    
    private void showDisasterRecoveryGuide(JTextArea textArea) {
    String DisasterRecoveryGuide = """
    Disaster Recovery Guide:   
                                                               
    1. Ensure safety and secure the area.       
    2. Document the damage.
    3. Begin cleanup and restoration.
    4. Take steps to prevent future disasters.
    5. Seek professional assistance if needed for emergency disaster.
    6. Assess and repair utilities.
    7. Rebuild and restore damaged structures.
    8. Emphasizes mental and emotional well-being.
    9. Try not to be panic during emergency situations.
    10. Utilize the recovery period to educate the community about disaster preparedness and resilience.                                                                                  
""";   
    textArea.setText(DisasterRecoveryGuide);
}

    void createAndShowGUI() {
}
}
