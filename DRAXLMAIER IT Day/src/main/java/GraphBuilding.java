import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;


// Clasa care construieste graful abstract
public class GraphBuilding {
    // Graph<V, E> where V is the type of the vertices
    // and E is the type of the edges
    public Graph<String, String> g = new SparseGraph<String, String>();

    // Vectorii cu datele din XML pt proceduri
    private ReadProcedure rp = new ReadProcedure();
    private String[] procedureId = rp.returtnId();
    private String[] procedureRef = rp.returnIdRef();

    // Vectorii cu datele din XML pt programe
    private ReadProgram rpg = new ReadProgram();
    private String[] programId = rpg.returtnId();
    private String[] programRef = rpg.returnIdRef();

    // Vectorii cu datele din XML pt interfete grafice
    private ReadGraphicInterface rgi = new ReadGraphicInterface();
    private String[] grapInterId = rgi.returtnId();
    private String[] graphInterRef = rgi.returnIdRef();

    // // Vectorii cu datele din XML pt leadcarduri
    private ReadLeadcards rl = new ReadLeadcards();
    private String[] leadcardsId = rl.returtnId();
    private String[] leadcardsRef = rl.returnIdRef();


    public GraphBuilding() {

        // PROCEDURE VERTEX
        g.addVertex(procedureId[0]);
        g.addVertex(procedureId[1]);
        g.addVertex(procedureId[2]);

        // PROCEDURE EDGES
        g.addEdge(procedureId[0] + procedureRef[0], procedureId[0], procedureRef[0], EdgeType.DIRECTED); // Note that Java 1.5 auto-boxes primitives
        g.addEdge(procedureId[0] + procedureRef[1], procedureId[0], procedureRef[1], EdgeType.DIRECTED);

        g.addEdge(procedureId[1] + procedureRef[2], procedureId[1], procedureRef[2], EdgeType.DIRECTED);
        g.addEdge(procedureId[1] + procedureRef[3], procedureId[1], procedureRef[3], EdgeType.DIRECTED);

        g.addEdge(procedureId[2] + procedureRef[4], procedureId[2], procedureRef[4], EdgeType.DIRECTED);

        // PROGRAM VERTEX
        g.addVertex(programId[0]);
        g.addVertex(programId[1]);
        g.addVertex(programId[2]);
        g.addVertex(programId[3]);
        g.addVertex(programId[4]);
        g.addVertex(programId[5]);
        g.addVertex(programId[6]);
        g.addVertex(programId[7]);
        g.addVertex(programId[8]);
        g.addVertex(programId[9]);
        g.addVertex(programId[10]);
        g.addVertex(programId[11]);

        // PROGRAM EDGES
        g.addEdge(programId[1] + programRef[0], programId[1], programRef[0], EdgeType.DIRECTED);
        g.addEdge(programId[1] + programRef[1], programId[1], programRef[1], EdgeType.DIRECTED);

        g.addEdge(programId[2] + programRef[2], programId[2], programRef[2], EdgeType.DIRECTED);

        g.addEdge(programId[5] + programRef[3], programId[5], programRef[3], EdgeType.DIRECTED);

        g.addEdge(programId[10] + programRef[4], programId[10], programRef[4], EdgeType.DIRECTED);

        g.addEdge(programId[11] + programRef[5], programId[11], programRef[5], EdgeType.DIRECTED);
        g.addEdge(programId[11] + programRef[6], programId[11], programRef[6], EdgeType.DIRECTED);

        // GRAPHIC INTERFACE VERTEX
        g.addVertex(grapInterId[0]);
        g.addVertex(grapInterId[1]);
        g.addVertex(grapInterId[2]);

        // GRAPHIC INTERFACE EDGES
        g.addEdge(grapInterId[0] + graphInterRef[0], grapInterId[0], graphInterRef[0], EdgeType.DIRECTED);
        g.addEdge(grapInterId[1] + graphInterRef[1], grapInterId[1], graphInterRef[1], EdgeType.DIRECTED);
        g.addEdge(grapInterId[2] + graphInterRef[2], grapInterId[2], graphInterRef[2], EdgeType.DIRECTED);

        // LEADCARDS EDGES
        g.addVertex(leadcardsId[0]);
        g.addVertex(leadcardsId[1]);
        g.addVertex(leadcardsId[2]);
        g.addVertex(leadcardsId[3]);
        g.addVertex(leadcardsId[4]);

        // LEADCARDS EDGES
        g.addEdge(leadcardsId[0] + leadcardsRef[0], leadcardsId[0], leadcardsRef[0], EdgeType.DIRECTED);
        g.addEdge(leadcardsId[1] + leadcardsRef[1], leadcardsId[1], leadcardsRef[1], EdgeType.DIRECTED);
        g.addEdge(leadcardsId[2] + leadcardsRef[2], leadcardsId[2], leadcardsRef[2], EdgeType.DIRECTED);
        g.addEdge(leadcardsId[3] + leadcardsRef[3], leadcardsId[3], leadcardsRef[3], EdgeType.DIRECTED);
        g.addEdge(leadcardsId[4] + leadcardsRef[4], leadcardsId[4], leadcardsRef[4], EdgeType.DIRECTED);

    }
}

