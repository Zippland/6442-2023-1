package Q2;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Some basic test cases are provided here for your references.
 * Note that as always, we will use a different set of marking test cases,
 * and you can always perform your own testing to increase your confidence to the robustness of your solutions.
 *
 * As an additional note, the test cases only serve to verify SOME but not all aspects of the solutions.
 * For instance, results with tokens of wrong `level`s could still pass the provided tests.
 * Submissions that pass the basic marking tests (similar to the provided tests) will be able to
 * get partial marks, but the other test cases will involve checking on the other aspects and cases.
 */
public class MDTokenizerTest {

    @Test(timeout=1000)
    public void testTokenizeData0A() {
        MDTokenizer tokenizer = new MDTokenizer("- U1\n- U2\n- U3\n");
        List<MDToken> tokens = new ArrayList<>();
        while (tokenizer.hasNext()) tokens.add(tokenizer.next());
        List<MDToken> expectedTokens = new ArrayList<>(List.of(new MDToken(MDTokenType.UNORDERED_ITEM, "U1", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U2", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U3", 0)));
        assertEquals(expectedTokens, tokens);
    }

    @Test(timeout=1000)
    public void testTokenizeData1() {
        MDTokenizer tokenizer = new MDTokenizer("\n\n- U1\n- U2\n- U3\n1. O1\n2. O2\n3. O3\n- U4\n    - U4A (EXACTLY 4 spaces)\n    - U4B\n- U5\n    1. U5A\n    2. U5B\n");
        List<MDToken> tokens = new ArrayList<>();
        while (tokenizer.hasNext()) tokens.add(tokenizer.next());
        assertEquals(new ArrayList<>(List.of(new MDToken(MDTokenType.UNORDERED_ITEM, "U1", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U2", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U3", 0), new MDToken(MDTokenType.ORDERED_ITEM, "O1", 0), new MDToken(MDTokenType.ORDERED_ITEM, "O2", 0), new MDToken(MDTokenType.ORDERED_ITEM, "O3", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U4", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U4A (EXACTLY 4 spaces)", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U4B", 0), new MDToken(MDTokenType.UNORDERED_ITEM, "U5", 0), new MDToken(MDTokenType.ORDERED_ITEM, "U5A", 0), new MDToken(MDTokenType.ORDERED_ITEM, "U5B", 0))), tokens);
    }

    @Test(timeout=1000)
    public void testTokenizeData2() {
        MDTokenizer tokenizer = new MDTokenizer("- Item 1\n    1. Subitem 1\n    2. Subitem 2\n        - Sub-subitem A\n        - Sub-subitem B\n        - Sub-subitem C\n            1. Sub-sub-subitem 1\n            2. Sub-sub-subitem 2\n- Item 2\n    - Subitem 1\n    - Subitem 2\n        1. Sub-subitem A\n        2. Sub-subitem B\n        3. Sub-subitem C\n- Item 3\n    - Subitem 1\n        - Sub-subitem A\n            - Sub-sub-subitem 1\n            - Sub-sub-subitem 2\n        - Sub-subitem B\n        - Sub-subitem C\n    - Subitem 2\n        1. Sub-subitem A\n        2. Sub-subitem B\n");
        List<MDToken> tokens = new ArrayList<>();
        while (tokenizer.hasNext()) tokens.add(tokenizer.next());
        assertEquals(List.of(new MDToken(MDTokenType.UNORDERED_ITEM, "Item 1", -1), new MDToken(MDTokenType.ORDERED_ITEM, "Subitem 1", 1), new MDToken(MDTokenType.ORDERED_ITEM, "Subitem 2", 2), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem A", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem B", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem C", -1), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-sub-subitem 1", 1), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-sub-subitem 2", 2), new MDToken(MDTokenType.UNORDERED_ITEM, "Item 2", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 1", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 2", -1), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem A", 1), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem B", 2), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem C", 3), new MDToken(MDTokenType.UNORDERED_ITEM, "Item 3", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 1", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem A", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-sub-subitem 1", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-sub-subitem 2", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem B", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Sub-subitem C", -1), new MDToken(MDTokenType.UNORDERED_ITEM, "Subitem 2", -1), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem A", 1), new MDToken(MDTokenType.ORDERED_ITEM, "Sub-subitem B", 2)), tokens);
    }





}
