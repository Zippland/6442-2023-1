package Q2;

public class MDTokenizer {
    String buffer;
    MDToken current = null;

    public MDTokenizer(String mdContent) {
        this.buffer = mdContent;
    }

    public boolean hasNext() {
        return this.buffer.length()>0; // You may make changes to this line if needed
    }


    public MDToken next() {
        // TODO - Your Code Starts Here



         return null;      // You may make changes to this line
        // TODO - Your Code Ends Here
    }


    public MDToken getCurrent() {
        return this.current;
    }



}
