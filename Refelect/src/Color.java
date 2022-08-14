public enum Color {
    RED("RED", 11, 1),
    BLUE("BLUE", 12, 2),
    GREEN("GREEN", 13, 3),
    YELLOW("YELLOW", 14, 4),
    BLACK("BLACK", 15, 5);

    public String colorName;
    public int colorId;
    public int ordinal;

    private Color(String colorName, int colorId, int ordinal) {
        this.colorName = colorName;
        this.colorId = colorId;
        this.ordinal = ordinal;
    }

    @Override
    public String toString() {
        return "Color{" +
                "colorName='" + colorName + '\'' +
                ", colorId=" + colorId +
                ", ordinal=" + ordinal +
                '}';
    }
}

class Test {
    public static void main(String[] args) {
        Color color = Color.BLUE;

        switch (color) {
            case RED:
                System.out.println("RED");
                break;
            case BLUE:
                System.out.println("BLUE");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
            case YELLOW:
                System.out.println("YELLOW");
                break;
            case BLACK:
                System.out.println("BLACK");
                break;
            default:
                System.out.println("OTHER");
                break;
        }
    }
}
