//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ASimulatorSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public final class Practice {
    boolean negative;

    public Practice() {
        this(false);
    }

    public Practice(boolean negative) {
        this.negative = negative;
    }

    public String convert(BufferedImage image) {
        StringBuilder sb = new StringBuilder((image.getWidth() + 1) * image.getHeight());

        for(int y = 0; y < image.getHeight(); ++y) {
            if (sb.length() != 0) {
                sb.append("\n");
            }

            for(int x = 0; x < image.getWidth(); ++x) {
                Color pixelColor = new Color(image.getRGB(x, y));
                double gValue = (double)pixelColor.getRed() * 0.2989 + (double)pixelColor.getBlue() * 0.587 + (double)pixelColor.getGreen() * 0.114;
                char s = this.negative ? this.returnStrNeg(gValue) : this.returnStrPos(gValue);
                sb.append(s);
            }
        }

        return sb.toString();
    }

    private char returnStrPos(double g) {
        char str;
        if (g >= 230.0) {
            str = ' ';
        } else if (g >= 200.0) {
            str = '.';
        } else if (g >= 180.0) {
            str = '*';
        } else if (g >= 160.0) {
            str = ':';
        } else if (g >= 130.0) {
            str = 'o';
        } else if (g >= 100.0) {
            str = '&';
        } else if (g >= 70.0) {
            str = '8';
        } else if (g >= 50.0) {
            str = '#';
        } else {
            str = '@';
        }

        return str;
    }

    private char returnStrNeg(double g) {
        char str;
        if (g >= 230.0) {
            str = '@';
        } else if (g >= 200.0) {
            str = '#';
        } else if (g >= 180.0) {
            str = '8';
        } else if (g >= 160.0) {
            str = '&';
        } else if (g >= 130.0) {
            str = 'o';
        } else if (g >= 100.0) {
            str = ':';
        } else if (g >= 70.0) {
            str = '*';
        } else if (g >= 50.0) {
            str = '.';
        } else {
            str = ' ';
        }

        return str;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Images", new String[]{"jpg", "gif", "png"}));

                while(fileChooser.showOpenDialog((Component)null) == 0) {
                    try {
                        File f = fileChooser.getSelectedFile();
                        BufferedImage image = ImageIO.read(f);
                        if (image == null) {
                            throw new IllegalArgumentException(f + " is not a valid image.");
                        }

                        String ascii = (new Practice()).convert(image);
                        JTextArea textArea = new JTextArea(ascii, image.getHeight(), image.getWidth());
                        textArea.setFont(new Font("Monospaced", 1, 5));
                        textArea.setEditable(false);
                        JDialog dialog = (new JOptionPane(new JScrollPane(textArea), -1)).createDialog(Practice.class.getName());
                        dialog.setResizable(true);
                        dialog.setVisible(true);
                    } catch (Exception var7) {
                        JOptionPane.showMessageDialog((Component)null, var7.toString(), "Error", 0);
                    }
                }

                System.exit(0);
            }
        });
    }
}
