package Q2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MDFileReaderTest {


    @Test
    public void basicTestData0() {
        // TODO - you may change the file path to [data0A.md] for testing purposes. The valid file path may depend on your system.
        String filePath = "Q2/data/data0A.md";

        assertEquals("- U1"+System.lineSeparator()+"- U2"+System.lineSeparator()+"- U3"+System.lineSeparator(), MDFileReader.read(filePath));
    }


}
