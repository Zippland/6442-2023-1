package Q2;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ListElementsTreeTest {
    /**
     * Basic Test Cases, Hardcoded Inputs
     */
    @Test(timeout=1000)
    public void testBasicPreOrderWalk0A() {
        ListElementsTree tree = new ListElementsTree();
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "U1", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "U2", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "U3", -1));
        assertEquals(List.of("U1", "U2", "U3"), tree.preOrderWalk());
    }

    @Test(timeout=1000)
    public void testBasicPreOrderWalkData1() {
        ListElementsTree tree = new ListElementsTree();
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "U1", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "U2", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "U3", -1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "O1", 1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "O2", 2));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "O3", 3));
        ListElementsTree subtree1 = new ListElementsTree("U4", List.of("U4A", "U4B"));
        tree.insertTree(subtree1);
        ListElementsTree subtree2 = new ListElementsTree("U5", List.of("U5A", "U5B"));
        tree.insertTree(subtree2);
        assertEquals(List.of("U1", "U2", "U3", "O1", "O2", "O3", "U4", "U4A", "U4B", "U5", "U5A", "U5B"), tree.preOrderWalk());
    }

    @Test(timeout=1000)
    public void testBasicPreOrderWalkData2FLAT() {
        ListElementsTree tree = new ListElementsTree();
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Item 1", -1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Subitem 1", 1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Subitem 2", 2));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem A", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem B", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem C", -1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-sub-subitem 1", 1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-sub-subitem 2", 2));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Item 2", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 1", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 2", -1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem A", 1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem B", 2));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem C", 3));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Item 3", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 1", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem A", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-sub-subitem 1", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-sub-subitem 2", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem B", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem C", -1));
        tree.insert(new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 2", -1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem A", 1));
        tree.insert(new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem B", 2));
        assertEquals(List.of("Item 1", "Subitem 1", "Subitem 2", "Sub-subitem A", "Sub-subitem B", "Sub-subitem C", "Sub-sub-subitem 1", "Sub-sub-subitem 2", "Item 2", "Subitem 1", "Subitem 2", "Sub-subitem A", "Sub-subitem B", "Sub-subitem C", "Item 3", "Subitem 1", "Sub-subitem A", "Sub-sub-subitem 1", "Sub-sub-subitem 2", "Sub-subitem B", "Sub-subitem C", "Subitem 2", "Sub-subitem A", "Sub-subitem B"), tree.preOrderWalk());
    }



}
