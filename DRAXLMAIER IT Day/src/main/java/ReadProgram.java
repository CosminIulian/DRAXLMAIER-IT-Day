import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

// Clasa care citeste datele din XML-Programe si le retine in variabile corespunzatoare
public class ReadProgram {

    // Array -uri de String-uri care retin datele din XML-Programe
    private String[] id = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    private String[] type = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    private String[] path = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    private String[] idRef = {"0", "0", "0", "0", "0", "0", "0"};

    public ReadProgram() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            try {
                Document programeXML = builder.parse("XML/programe.xml");

                NodeList program = programeXML.getElementsByTagName("program");

                int nr = -1;

                for (int i = 0; i < program.getLength(); i++) {
                    Node pNode = (program.item(i));

                    if (pNode.getNodeType() == Node.ELEMENT_NODE) { // Daca este un element al nodului
                        Element programElement = (Element) pNode;

                        id[i] = programElement.getAttribute("id");
                        type[i] = programElement.getAttribute("type");
                        path[i] = programElement.getAttribute("path");

                        NodeList programRef = programElement.getChildNodes();
                        for (int ii = 0; ii < programRef.getLength(); ii++) {
                            Node pRefNode = programRef.item(ii);

                            if (pRefNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element programReference = (Element) pRefNode;

                                if (!programReference.getAttribute("programId").equals("")) {
                                    nr++;
                                    idRef[nr] = programReference.getAttribute("programId");
                                }
                            }
                        }
                    }
                }

            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (
                ParserConfigurationException e) {
            e.printStackTrace();
        }

    }


    public String[] returtnId() {

        return id;
    }


    public String[] returnType() {

        return type;
    }


    public String[] returnPath() {

        return path;
    }


    public String[] returnIdRef() {

        return idRef;
    }

    // Functie de afisare a array-ului in cazul unei erori
    public void showArray(String array[]) {

        System.out.println("showArray= ");
        for (String result : array) {

            System.out.println(result);
        }
    }

}
