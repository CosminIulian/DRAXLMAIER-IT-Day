import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

// Clasa care citeste datele din XML-Leadcarduri si le retine in variabile corespunzatoare
public class ReadLeadcards {

    // Array -uri de String-uri care retin datele din XML-Leadcarduri
    private String[] id = {"0", "0", "0", "0", "0"};
    private String[] description = {"0", "0", "0", "0", "0"};
    private String[] idRef = {"0", "0", "0", "0", "0"};


    public ReadLeadcards() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            try {
                Document programeXML = builder.parse("XML/leadcards.xml");

                NodeList program = programeXML.getElementsByTagName("leadcard");

                for (int i = 0; i < program.getLength(); i++) {
                    Node pNode = (program.item(i));

                    if (pNode.getNodeType() == Node.ELEMENT_NODE) { // Daca este un element al nodului
                        Element programElement = (Element) pNode;

                        id[i] = programElement.getAttribute("id");
                        description[i] = programElement.getAttribute("description");
                        idRef[i] = programElement.getAttribute("procedureId");
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


    public String[] returnDescription() {

        return description;
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
