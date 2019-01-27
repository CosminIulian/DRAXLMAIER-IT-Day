import com.google.common.base.Function;
import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// Clasa care afiseaza graficul si se ocupa cu restul functionalitatilor vizuale
public class GraphView {
    // This builds the graph
    private GraphBuilding gb = new GraphBuilding();

    // Layout<V, E>, BasicVisualizationServer<V,E>
    private Layout<String, String> layout = new KKLayout<String, String>(gb.g);
    private VisualizationViewer<String, String> vv = new VisualizationViewer<String, String>(layout);

    // 2x JFrame (graph and buttons)
    private JFrame frame = new JFrame("Graph View");
    private JFrame frame1 = new JFrame("Search & PDF");

    // Vector de drumuri
    private String[] drumMRA = new String[19];


    public GraphView() {

        layout.setSize(new Dimension(650, 650)); // marimea tipului de vizualizare al grafului
        vv.setPreferredSize(new Dimension(700, 700)); // marimea ferestrei pt graf

        // Functia de colorare a fiecarui nod dupa tipul acestuia
        Function<String, Paint> vertexPaint = new Function<String, Paint>() {
            public Paint apply(String i) {
                if (i.substring(0, 2).equals("B.")) return Color.decode("#4690DA");

                else if (i.substring(0, 2).equals("FL") || i.substring(0, 4).equals("0000"))
                    return Color.decode("#D13A3A");

                else if (i.substring(0, 2).equals("AB")) return Color.decode("#5DAE5D");

                else if (i.substring(0, 3).equals("060")) return Color.decode("#AB5DAB");

                return Color.WHITE;
            }
        };

        // Functia de modificare a formei nodului
        Function<String, Shape> vertexSize = new Function<String, Shape>() {
            public Shape apply(String i) {
                return new Rectangle(-20, -10, 60, 30);
            }
        };

        // Functia de modificare a fontului
        Function<String, Font> vertexFont = new Function<String, Font>() {
            public Font apply(String i) {
                Font font = new Font("Tahoma", Font.BOLD, 12);
                return font;
            }
        };

        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint); // culoarea nodului
        vv.getRenderContext().setVertexShapeTransformer(vertexSize); // forma nodului
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller()); // scrisul nodului
        vv.getRenderContext().setVertexFontTransformer(vertexFont); // fontul nodului
        vv.getRenderer().getVertexLabelRenderer()
                .setPosition(Renderer.VertexLabel.Position.CNTR); // pozitionarea scrisului

        // Functinalitatea mouse-ului in graf, pt a muta elementele dupa preferinte
        final DefaultModalGraphMouse<String, Number> graphMouse = new DefaultModalGraphMouse<String, Number>();
        vv.setGraphMouse(graphMouse);
        graphMouse.setMode(ModalGraphMouse.Mode.PICKING);

        vv.setBackground(Color.decode("#A0A0A0"));

        // JFrame Graph View
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv); // Punem graful in JFrame
        frame.pack();
        frame.setVisible(true);

        // Search Btn functions

        //submit button
        Icon searchIcon = new ImageIcon("icons/search.png");
        JButton b = new JButton(searchIcon);
        b.setBackground(Color.decode("#A0A0A0"));
        // to remote the spacing between the image and button's borders
        b.setMargin(new Insets(0, 0, 0, 0));
        b.setFocusPainted(false);
        b.setBounds(210, 50, 50, 30);

        //enter value label
        final JLabel label = new JLabel();
        label.setText("Search value:");
        label.setFont(new Font("Tahoma", Font.BOLD, 12));
        label.setForeground(Color.WHITE);
        label.setBounds(15, 15, 100, 100);

        //show message label
        final JLabel label1 = new JLabel();
        label1.setFont(new Font("Tahoma", Font.BOLD, 12));
        label1.setForeground(Color.WHITE);
        label1.setText("");
        label1.setBounds(95, 140, 200, 100);

        //textfield to enter value
        final JTextField textfield = new JTextField();
        textfield.setFont(new Font("Tahoma", Font.BOLD, 12));
        textfield.setBounds(104, 50, 105, 30);

        //generate PDF button
        Icon pdfIcon = new ImageIcon("icons/pdf.png");
        JButton b1 = new JButton(pdfIcon);
        b1.setBackground(Color.decode("#A0A0A0"));
        // to remote the spacing between the image and button's borders
        b.setMargin(new Insets(0, 0, 0, 0));
        b1.setFocusPainted(false);
        b1.setBounds(104, 135, 60, 40);

        //add to frame
        frame1.add(label);
        frame1.add(textfield);
        frame1.add(b);
        frame1.add(b1);
        frame1.add(label1);
        frame1.setSize(300, 255);
        frame1.getContentPane().setBackground(Color.decode("#595959"));
        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                String searchId = textfield.getText();
                frame.dispose();
                frame1.dispose();
                new GraphView().setColorMarker(searchId);
            }
        });

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Select just one directory! (Ex: D:\\, E:\\ .. etc.",
                        "ALERT MESSAGE", JOptionPane.WARNING_MESSAGE);
                CreatePDF pdf = new CreatePDF();
                if (!pdf.getPath().equals(""))

                    if (!pdf.getPath().contains("C")) label1.setText("PDF saved!");

                    else label1.setText("Choose another directory");

                else label1.setText("PDF not saved!");

            }
        });

        // drumurile maxime ale grafului
        drumMRA[0] = "0604AB0604AB9002";

        drumMRA[1] = "0605AB0605AB9002";

        drumMRA[2] = "0605AB0605AB9003AB9004";

        drumMRA[3] = "0601AB0601";

        drumMRA[4] = "FL1B.AB3010AB2002AB9002";

        drumMRA[5] = "FL1B.AB3010B.AB3030AB2001AB9002";

        drumMRA[6] = "FL1B.AB3010B.AB3030AB2000";

        drumMRA[7] = "FL1B.AB3010B.AB3030AB2001AB9001";

        drumMRA[8] = "FL3B.AB3030AB2000";

        drumMRA[9] = "FL3B.AB3030AB2001AB9002";

        drumMRA[10] = "FL3B.AB3030AB2001AB9001";

        drumMRA[11] = "FL5B.AB3010B.AB3030AB2000";

        drumMRA[12] = "FL5B.AB3010B.AB3030AB2001AB9001";

        drumMRA[13] = "FL5B.AB3010B.AB3030AB2001AB9002";

        drumMRA[14] = "FL5B.AB3010AB2002AB9002";

        drumMRA[15] = "00001B.AB5010";

        drumMRA[16] = "00002B.AB5020";

        drumMRA[17] = "B.FL6010AB2001AB9002";

        drumMRA[18] = "B.FL6010AB2001AB9001";

    }

    // Functia de colorare a drumurilor si a nodului respectiv
    public void setColorMarker(final String searchId) {

        // edge marker
        Function<String, Paint> edgePaint = new Function<String, Paint>() {
            public Paint apply(String i) {

                if (!searchId.equals(""))
                    for (int index = 0; index < drumMRA.length; index++) {

                        if (drumMRA[index].contains(i) && drumMRA[index].contains(searchId))
                            return Color.decode("#FF0000");
                    }

                return Color.BLACK;
            }
        };

        //vertex marker
        Function<String, Paint> vertexPaint = new Function<String, Paint>() {
            public Paint apply(String i) {

                if (searchId.equals(i)) return Color.decode("#FFA500");

                else return Color.BLACK;
            }
        };

        vv.getRenderContext().setEdgeDrawPaintTransformer(edgePaint);
        vv.getRenderContext().setVertexDrawPaintTransformer(vertexPaint);

    }

}

