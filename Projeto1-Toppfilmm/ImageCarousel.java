import java.awt.*;
import java.awt.event.*;
import javax.applet.Applet;

public class ImageCarousel extends Applet implements ActionListener {

    private Image[] images;
    private int currentIndex = 0;
    private Button prevButton, nextButton;

    public void init() {
        // Carregar imagens
        images = new Image[3];
        images[0] = getImage(getDocumentBase(), "image1.jpg");
        images[1] = getImage(getDocumentBase(), "image2.jpg");
        images[2] = getImage(getDocumentBase(), "image3.jpg");

        // Criar botões
        prevButton = new Button("Anterior");
        prevButton.addActionListener(this);
        add(prevButton);

        nextButton = new Button("Próximo");
        nextButton.addActionListener(this);
        add(nextButton);

        // Exibir a primeira imagem
        showImage(0);
    }

    public void paint(Graphics g) {
        if (images[currentIndex] != null) {
            g.drawImage(images[currentIndex], 0, 0, getWidth(), getHeight(), null);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prevButton) {
            showPreviousImage();
        } else if (e.getSource() == nextButton) {
            showNextImage();
        }
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + images.length) % images.length;
        repaint();
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % images.length;
        repaint();
    }

    private void showImage(int index) {
        currentIndex = index;
        repaint();
    }
}

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        getContentPane().add(imageLabel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void updateImage() {
        ImageIcon icon = new ImageIcon(imagePaths[currentIndex]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(newImg));
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + imagePaths.length) % imagePaths.length;
        updateImage();
    }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % imagePaths.length;
        updateImage();
    }

    public static void main(String[] args) {
        String[] images = {
            "path/to/your/image1.jpg",
            "path/to/your/image2.jpg",
            "path/to/your/image3.jpg"
        };
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageCarousel(images).setVisible(true);
            }
        });
    }
}
  </script>