package parsing;

import justificationDiagram.JustificationDiagram;
import models.Conclusion;
import models.NodeFactory;

public class JDInitializer extends JustificationDiagramBaseVisitor<String> {
    public JustificationDiagram diagram;

    @Override
    public String visitDiagram(JustificationDiagramParser.DiagramContext ctx) {
        diagram = new JustificationDiagram();
        return super.visitDiagram(ctx);
    }

    @Override
    public String visitDeclaration(JustificationDiagramParser.DeclarationContext ctx) {
        return super.visitDeclaration(ctx);
    }

    @Override
    public String visitRelation(JustificationDiagramParser.RelationContext ctx) {
        return super.visitRelation(ctx);
    }

    @Override
    public String visitInstruction(JustificationDiagramParser.InstructionContext ctx) {
        return super.visitInstruction(ctx);
    }

    @Override
    public String visitElement(JustificationDiagramParser.ElementContext ctx) {
        diagram.nodes.put(ctx.ALIAS().getText(),
                NodeFactory.create(ctx.TYPE().getText(), ctx.ALIAS().getText(),  ctx.label.getText()));
        return super.visitElement(ctx);
    }

    @Override
    public String visitConclusion(JustificationDiagramParser.ConclusionContext ctx) {
        String alias = ctx.ALIAS().getText();
        String label = ctx.label.getText();
        String restriction = ctx.restriction != null ? ctx.restriction.getText() : null;
        Conclusion conclusion = new Conclusion(alias, label, restriction);
        diagram.nodes.put(alias, conclusion);
        return super.visitConclusion(ctx);
    }
}
