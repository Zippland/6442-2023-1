package Q2;

public class MDToken {
    protected MDTokenType tokenType;
    String content;
    int level;
    int number;

    public MDToken() {
        this.tokenType = MDTokenType.LIST_ROOT;
    }

    // Hint: used to create 'Ordered List' items
    public MDToken(MDTokenType tokenType, String content, int number, int level) {
        this.tokenType = tokenType;
        this.content = content;
        this.number = number;
        this.level = level;
    }


    public MDToken(MDTokenType tokenType, String content, int level) {
        this.tokenType = tokenType;
        this.content = content;
        this.level = level;
    }


    @Override
    public String toString() {
        return " ".repeat((Math.max(level, 0))*4) + "[" + tokenType +"] " + content;
    }

    public int getLevel() {
        return this.level;
    }

    public String getContent() {
        return this.content;
    }

    public MDTokenType getTokenType() {return this.tokenType;}


    // Note: Check Part of the Attributes only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MDToken mdToken = (MDToken) o;
        if (tokenType != mdToken.tokenType) return false;
        return content.equals(mdToken.content);
    }

}
