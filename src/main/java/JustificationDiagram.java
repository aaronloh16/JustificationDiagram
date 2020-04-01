import java.util.ArrayList;

public class JustificationDiagram implements Visitable {
    ArrayList<Node> nodes;
    ArrayList<Relation> relations;

    public JustificationDiagram() {
        nodes = new ArrayList<>();
        relations = new ArrayList<>();
    }

    @Override
    public void accept(JDVisitor JDVisitor) {
        JDVisitor.visitDiagram(this);
    }

}
