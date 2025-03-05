package raven.modal.demo.component;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CapturaImagens extends JPanel {
    private VideoCapture capture;
    private JLabel videoLabel;
    private Mat lastFrame;

    public CapturaImagens() {
        this.capture = new VideoCapture(0);
        this.capture.set(3, 640);  // Definindo a largura para 640
        this.capture.set(4, 480);  // Definindo a altura para 480
        this.capture.set(5, 30);   // FPS

        if (!this.capture.isOpened()) {
            System.out.println("Não foi possível abrir o dispositivo de captura.");
            return;
        }

        this.setLayout(new BorderLayout());
        this.videoLabel = new JLabel();
        this.add(this.videoLabel, BorderLayout.CENTER);

        new CaptureWorker().execute();
    }

    private class CaptureWorker extends SwingWorker<Void, BufferedImage> {

        @Override
        protected Void doInBackground() throws Exception {
            Mat frameMat = new Mat();
            while (!isCancelled()) {
                capture.read(frameMat);

                if (!frameMat.empty()) {
                    BufferedImage img = matToBufferedImage(frameMat);
                    lastFrame = frameMat.clone();
                    publish(img);
                }

                Thread.sleep(30);
            }
            return null;
        }

        @Override
        protected void process(java.util.List<BufferedImage> chunks) {
            for (BufferedImage img : chunks) {
                ImageIcon icon = new ImageIcon(img);
                videoLabel.setIcon(icon);
                videoLabel.repaint();
            }
        }
    }

    public static BufferedImage matToBufferedImage(Mat mat) {
        int width = mat.cols();
        int height = mat.rows();

        if (mat.channels() == 3) {
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
            byte[] data = new byte[width * height * 3];

            mat.data().get(data);

            bufferedImage.getRaster().setDataElements(0, 0, width, height, data);
            return bufferedImage;
        } else if (mat.channels() == 1) {
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
            byte[] data = new byte[width * height];
            mat.data().get(data);
            bufferedImage.getRaster().setDataElements(0, 0, width, height, data);

            return bufferedImage;
        }

        return null;
    }

    public void captureImage() {
        if (this.lastFrame != null && !this.lastFrame.empty()) {
            BufferedImage bufferedImage = matToBufferedImage(this.lastFrame);

            String fileName = "captura_" + System.currentTimeMillis() + ".png";
            File outputFile = new File(fileName);

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                ImageIO.write(bufferedImage, "PNG", fos);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Falha ao salvar a imagem. " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma imagem disponível para capturar.");
        }
    }
}
