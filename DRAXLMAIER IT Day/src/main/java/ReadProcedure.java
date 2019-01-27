import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

// Clasa care citeste datele din XML-Proceduri si le retine in variabile corespunzatoare
public class ReadProcedure {

    // Array -uri de String-uri care retin datele din XML-Proceduri
    private String[] id = {"0", "0", "0"};
    private String[] idRef = {"0", "0", "0", "0", "0"};

    public ReadProcedure() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            try {
                Document proceduriXML = builder.parse("XML/proceduri.xml");

                NodeList procedure = proceduriXML.getElementsByTagName("procedure");

                int nr = -1;

                for (int i = 0; i < procedure.getLength(); i++) {
                    Node pNode = (procedure.item(i));

                    if (pNode.getNodeType() == Node.ELEMENT_NODE) { // Daca este un element al nodului
                        Element procedureElement = (Element) pNode;

                        id[i] = procedureElement.getAttribute("id");

                        NodeList programRef = procedureElement.getChildNodes();
                        for (int ii = 0; ii < programRef.getLength(); ii++) {
                            Node pRefNode = programRef.item(ii);
                            if (pRefNode.getNodeType() == Node.ELEMENT_NODE) {

                                Element programReference = (Element) pRefNode;

                                if (!programReference.getAttribute("programId").equals("")) {
                                    nr++;
                                    idRef[nr] = programReference.getAttribute("programId");
                                }
                                if (!programReference.getAttribute("procedureId").equals("")) {
                                    nr++;
                                    idRef[nr] = programReference.getAttribute("procedureId");
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
