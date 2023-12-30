import node.Node;
import node.SimpleNode;
import walker.impl.BuildHierarchyNodeWalker;
import walker.impl.IteratorNodeWalker;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        SimpleNode root = new SimpleNode(1);
        root.addChild(new SimpleNode(root, 2));
        SimpleNode three = new SimpleNode(root, 3);
        root.addChild(three);
        three.addChild(new SimpleNode(three, 4));
        SimpleNode five = new SimpleNode(three, 5);
        three.addChild(five);
        five.addChild(new SimpleNode(five, 6));
        five.addChild(new SimpleNode(five, 7));

        Optional<Node> fourHierarchy = root.walk(new BuildHierarchyNodeWalker(4));
        fourHierarchy.ifPresent(System.out::println);
        System.out.println("-------------");
        fourHierarchy.ifPresent(r -> r.walk(IteratorNodeWalker.INSTANCE).forEachRemaining(System.out::println));
    }
}
