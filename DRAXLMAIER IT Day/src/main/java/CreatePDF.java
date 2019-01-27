import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// Clasa care scrie datele din vectori in format PDF
public class CreatePDF {

    private String path = "";

    public CreatePDF() {

        JButton save = new JButton();
        JFileChooser jFileChooser = new JFileChooser(); // Clasa care o folosim pt a alege calea fisierului
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // afiseaza doar fisierele directoare

        if (jFileChooser.showSaveDialog(save) == JFileChooser.APPROVE_OPTION) {

            path = jFileChooser.getSelectedFile().getPath();
        }

        if (!path.equals("")) {
            Document document = new Document();

            // initializam variabilele pt proceduri
            ReadProcedure rp = new ReadProcedure();
            String[] procedureId = rp.returtnId();
            String[] procedureRef = rp.returnIdRef();

            // initializam variabilele pt programe
            ReadProgram rpg = new ReadProgram();
            String[] programId = rpg.returtnId();
            String[] programType = rpg.returnType();
            String[] programPath = rpg.returnPath();
            String[] programRef = rpg.returnIdRef();

            // initializam variabilele pt interfete grafice
            ReadGraphicInterface rg = new ReadGraphicInterface();
            String[] grapInterId = rg.returtnId();
            String[] grapInterDesc = rg.returnDescription();
            String[] grapInterRef = rg.returnIdRef();

            // initializam variabilele pt leadcards
            ReadLeadcards rl = new ReadLeadcards();
            String[] leadcardsId = rl.returtnId();
            String[] leadcardsDesc = rl.returnDescription();
            String[] leadcardsRef = rl.returnIdRef();


            try {

                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path + "DRAXLMAIER_IT_Day.pdf"));
                document.open();
                Font font = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD);


                //Interfete grafice
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Interfete grafice", font));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(grapInterId[0]));
                document.add(new Paragraph("Descriere: " + grapInterDesc[0]));
                document.add(new Paragraph("Program: " + grapInterRef[0]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(grapInterId[1]));
                document.add(new Paragraph("Descriere: " + grapInterDesc[1]));
                document.add(new Paragraph("Program: " + grapInterRef[1]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(grapInterId[2]));
                document.add(new Paragraph("Descriere: " + grapInterDesc[2]));
                document.add(new Paragraph("Program: " + grapInterRef[2]));
                document.add(new Paragraph("\n"));


                //Leadcard-uri
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Leadcard-uri", font));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(leadcardsId[0]));
                document.add(new Paragraph("Descriere: " + leadcardsDesc[0]));
                document.add(new Paragraph("Procedura: " + leadcardsRef[0]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(leadcardsId[1]));
                document.add(new Paragraph("Descriere: " + leadcardsDesc[1]));
                document.add(new Paragraph("Procedura: " + leadcardsRef[1]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(leadcardsId[2]));
                document.add(new Paragraph("Descriere: " + leadcardsDesc[2]));
                document.add(new Paragraph("Procedura: " + leadcardsRef[2]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(leadcardsId[3]));
                document.add(new Paragraph("Descriere: " + leadcardsDesc[3]));
                document.add(new Paragraph("Procedura: " + leadcardsRef[3]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(leadcardsId[4]));
                document.add(new Paragraph("Descriere: " + leadcardsDesc[4]));
                document.add(new Paragraph("Procedura: " + leadcardsRef[4]));
                document.add(new Paragraph("\n"));


                // Procedurile
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Proceduri", font));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(procedureId[0]));
                document.add(new Paragraph("Programe:      " + procedureRef[0]));
                document.add(new Paragraph("                       "
                        + procedureRef[1]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(procedureId[1]));
                document.add(new Paragraph("Programe:      " + procedureRef[2]));
                document.add(new Paragraph("Proceduri:     " + procedureRef[3]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(procedureId[2]));
                document.add(new Paragraph("Programe:      " + procedureRef[4]));
                document.add(new Paragraph("\n"));


                //Programele
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Programe", font));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[0]));
                document.add(new Paragraph("Cale: " + programPath[0]));
                document.add(new Paragraph("Tip: " + programType[0]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[1]));
                document.add(new Paragraph("Cale: " + programPath[1]));
                document.add(new Paragraph("Tip: " + programType[1]));
                document.add(new Paragraph("Programe chemate: \n"));
                document.add(new Paragraph(programRef[0]));
                document.add(new Paragraph(programRef[1]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[2]));
                document.add(new Paragraph("Cale: " + programPath[2]));
                document.add(new Paragraph("Tip: " + programType[2]));
                document.add(new Paragraph("Programe chemate: \n"));
                document.add(new Paragraph(programRef[2]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[3]));
                document.add(new Paragraph("Cale: " + programPath[3]));
                document.add(new Paragraph("Tip: " + programType[3]));
                document.add(new Paragraph("Este chemat in:\n" + programId[1]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[4]));
                document.add(new Paragraph("Cale: " + programPath[4]));
                document.add(new Paragraph("Tip: " + programType[4]));
                document.add(new Paragraph("Este chemat in:\n" + programId[1] + "\n" + programId[2] + "\n"
                        + programId[10] + "\n" + programId[11]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[5]));
                document.add(new Paragraph("Cale: " + programPath[5]));
                document.add(new Paragraph("Tip: " + programType[5]));
                document.add(new Paragraph("Programe chemate: \n" + programRef[3]));
                document.add(new Paragraph("Este chemat in:\n" + programId[11]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[6]));
                document.add(new Paragraph("Cale: " + programPath[6]));
                document.add(new Paragraph("Tip: " + programType[6]));
                document.add(new Paragraph("Este chemat in:\n" + programId[5]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[7]));
                document.add(new Paragraph("Cale: " + programPath[7]));
                document.add(new Paragraph("Tip: " + programType[7]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[8]));
                document.add(new Paragraph("Cale: " + programPath[8]));
                document.add(new Paragraph("Tip: " + programType[8]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[9]));
                document.add(new Paragraph("Cale: " + programPath[9]));
                document.add(new Paragraph("Tip: " + programType[9]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[10]));
                document.add(new Paragraph("Cale: " + programPath[10]));
                document.add(new Paragraph("Tip: " + programType[10]));
                document.add(new Paragraph("Programe chemate: \n"));
                document.add(new Paragraph(programRef[4]));
                document.add(new Paragraph("\n"));

                document.add(new Paragraph(programId[11]));
                document.add(new Paragraph("Cale: " + programPath[11]));
                document.add(new Paragraph("Tip: " + programType[11]));
                document.add(new Paragraph("Programe chemate: \n"));
                document.add(new Paragraph(programRef[5]));
                document.add(new Paragraph(programRef[6]));
                document.add(new Paragraph("\n"));


                document.close();
                writer.close();

            } catch (DocumentException e) {
                e.printStackTrace();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String getPath() {

        return path;
    }

}
