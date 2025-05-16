import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class TerrabotanicaSwing extends JFrame {
    private JTextField playerNameField, gardenNameField;
    private JPanel plantListPanel;
    private List<Plant> plants = new ArrayList<>();
    private List<TanamanHias> encyclopedia = new ArrayList<>();

    public TerrabotanicaSwing() {
        setTitle("Terrabotanica 🌿");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        showLoginScreen();
    }

    private void showLoginScreen() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 253, 231));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        JLabel title = new JLabel("Terrabotanica 🌿");
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
        title.setForeground(new Color(46, 125, 50));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1; gbc.gridy = 1; gbc.gridx = 0;
        panel.add(new JLabel("Nama Pemain:"), gbc);
        gbc.gridx = 1;
        playerNameField = new JTextField(15);
        panel.add(playerNameField, gbc);

        gbc.gridy = 2; gbc.gridx = 0;
        panel.add(new JLabel("Nama Taman:"), gbc);
        gbc.gridx = 1;
        gardenNameField = new JTextField(15);
        panel.add(gardenNameField, gbc);

        gbc.gridy = 3; gbc.gridx = 0; gbc.gridwidth = 2;
        JButton startBtn = new JButton("🌱 Mulai Bertanam");
        panel.add(startBtn, gbc);

        startBtn.addActionListener(e -> {
            if (!playerNameField.getText().isEmpty() && !gardenNameField.getText().isEmpty()) {
                showGardenView();
            } else {
                JOptionPane.showMessageDialog(this, "Lengkapi nama pemain & taman!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        setContentPane(panel);
        revalidate();
        repaint();
    }

    private void showGardenView() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(241, 248, 233));

        JLabel title = new JLabel("🌼 Taman: " + gardenNameField.getText(), JLabel.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        title.setForeground(new Color(56, 142, 60));

        JButton btnAdd = new JButton("➕ Tambah Tanaman");
        btnAdd.addActionListener(e -> {
            Plant newPlant = inputPlantDialog();
            if (newPlant != null) {
                plants.add(newPlant);
                refreshPlantList();
            }
        });

        JButton btnEnsiklopedia = new JButton("📘 Ensiklopedia");
        btnEnsiklopedia.addActionListener(e -> openEncyclopediaDialog());

        JPanel topPanel = new JPanel();
        topPanel.add(btnAdd);
        topPanel.add(btnEnsiklopedia);

        plantListPanel = new JPanel();
        plantListPanel.setLayout(new BoxLayout(plantListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(plantListPanel);
        scrollPane.setPreferredSize(new Dimension(680, 320));

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(topPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        refreshPlantList();
        revalidate();
        repaint();
    }

    private void refreshPlantList() {
        plantListPanel.removeAll();
        for (Plant plant : plants) {
            JTextArea status = new JTextArea(plant.checkHealth());
            status.setEditable(false);
            status.setFont(new Font("Monospaced", Font.PLAIN, 12));

            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createTitledBorder(plant.plantName));
            card.add(status, BorderLayout.CENTER);

            JButton water = new JButton("💧");
            JButton sun = new JButton("🌞");
            JButton feed = new JButton("🌿");
            JPanel buttons = new JPanel();
            buttons.add(water); buttons.add(sun); buttons.add(feed);

            water.addActionListener(e -> { plant.water(true); refreshPlantList(); });
            sun.addActionListener(e -> { plant.weather(1); refreshPlantList(); });
            feed.addActionListener(e -> { plant.grow(1); refreshPlantList(); });

            card.add(buttons, BorderLayout.SOUTH);
            plantListPanel.add(card);
        }
        plantListPanel.revalidate();
        plantListPanel.repaint();
    }

    private Plant inputPlantDialog() {
        JTextField nameField = new JTextField();
        JTextField sciField = new JTextField();
        JTextField ageField = new JTextField();

        JComboBox<String> typeBox = new JComboBox<>(new String[]{"Dekoratif", "Obat", "Sayur"});

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Nama Tanaman:")); panel.add(nameField);
        panel.add(new JLabel("Nama Ilmiah:")); panel.add(sciField);
        panel.add(new JLabel("Usia:")); panel.add(ageField);
        panel.add(new JLabel("Jenis:")); panel.add(typeBox);

        int result = JOptionPane.showConfirmDialog(this, panel, "Tambah Tanaman", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText().trim();
                String sci = sciField.getText().trim();
                int age = Integer.parseInt(ageField.getText().trim());
                return new Plant(name, sci, age);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }

    private void openEncyclopediaDialog() {
        JDialog dialog = new JDialog(this, "📗 Ensiklopedia Tanaman Hias", true);
        dialog.setSize(450, 400);
        dialog.setLocationRelativeTo(this);

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JTextArea listArea = new JTextArea();
        listArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listArea);

        JButton addBtn = new JButton("➕ Tambah Tanaman Hias");
        addBtn.addActionListener(e -> {
            JTextField nama = new JTextField();
            JTextField ilmiah = new JTextField();
            JTextField kategori = new JTextField();
            JTextField cahaya = new JTextField();
            JCheckBox indoor = new JCheckBox("Cocok untuk indoor");

            JPanel form = new JPanel(new GridLayout(0, 1));
            form.add(new JLabel("Nama Tanaman:")); form.add(nama);
            form.add(new JLabel("Nama Ilmiah:")); form.add(ilmiah);
            form.add(new JLabel("Kategori:")); form.add(kategori);
            form.add(new JLabel("Cahaya:")); form.add(cahaya);
            form.add(indoor);

            int result = JOptionPane.showConfirmDialog(this, form, "Tambah Tanaman Hias", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                encyclopedia.add(new TanamanHias(
                    nama.getText(), ilmiah.getText(), kategori.getText(),
                    indoor.isSelected(), cahaya.getText()
                ));
                updateEncyclopediaList(listArea);
            }
        });

        updateEncyclopediaList(listArea);
        root.add(new JLabel("🌸 Daftar Tanaman Hias:"), BorderLayout.NORTH);
        root.add(scrollPane, BorderLayout.CENTER);
        root.add(addBtn, BorderLayout.SOUTH);

        dialog.setContentPane(root);
        dialog.setVisible(true);
    }

    private void updateEncyclopediaList(JTextArea area) {
        StringBuilder sb = new StringBuilder();
        for (TanamanHias t : encyclopedia) {
            sb.append("🌿 ").append(t.name).append(" | ")
              .append(t.scientific).append(" | ")
              .append(t.category).append(" | ")
              .append(t.light).append(" | ")
              .append(t.indoor ? "Indoor" : "Outdoor")
              .append("\n");
        }
        area.setText(sb.toString().isEmpty() ? "Belum ada tanaman 🌱" : sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TerrabotanicaSwing().setVisible(true));
    }

    // Plant class (disederhanakan)
    static class Plant {
        String plantName, scientificName, status;
        int hydration = 0, nutrition = 0, sunlight = 0;
        double age;

        public Plant(String name, String sci, int age) {
            this.plantName = name;
            this.scientificName = sci;
            this.age = age;
            updateStatus();
        }

        public void grow(int type) { nutrition += 10; updateStatus(); }
        public void water(boolean b) { hydration += 5; updateStatus(); }
        public void weather(int type) { sunlight += (type == 1) ? 5 : 2; updateStatus(); }

        private void updateStatus() {
            if (nutrition >= 15 && hydration >= 5 && sunlight >= 5) status = "Sehat";
            else if (nutrition >= 10 && hydration >= 5 && sunlight >= 2) status = "Cukup sehat";
            else status = "Layu";
        }

        public String checkHealth() {
            return "Nama: " + plantName + "\n" +
                   "Ilmiah: " + scientificName + "\n" +
                   "Usia: " + age + "\n" +
                   "Status: " + status + "\n" +
                   "Nutrisi: " + nutrition + ", Hidrasi: " + hydration + ", Cahaya: " + sunlight;
        }
    }

    // TanamanHias class
    static class TanamanHias {
        String name, scientific, category, light;
        boolean indoor;

        public TanamanHias(String n, String s, String c, boolean i, String l) {
            this.name = n;
            this.scientific = s;
            this.category = c;
            this.indoor = i;
            this.light = l;
        }
    }
}