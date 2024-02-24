
public class SquarePyramid {
    private static int nextId;
    private int id;
    private double side; // also called base
    private double height;

    public SquarePyramid() {
        this.id = nextId++;
        this.side = 1.0;
        this.height = 1.0;
    }

    public SquarePyramid(double side, double height) {
        this.id = nextId++;
        this.side = side;
        this.height = height;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.pow(side, 2) * height / 3.;
    }

    public double getSurfaceArea() {
        return Math.pow(side, 2) + 2. * side * Math.sqrt(Math.pow(side, 2) / 4. + Math.pow(height, 2));
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        System.out.printf("NextId = %d\n", SquarePyramid.nextId);
        System.out.println();

        SquarePyramid sp_1 = new SquarePyramid();
        System.out.printf("NextId = %d\n", SquarePyramid.nextId);
        System.out.printf("Id = %d\n", sp_1.getId());
        System.out.printf("V = %f\n", sp_1.getVolume());
        System.out.println();

        SquarePyramid sp_2 = new SquarePyramid(3, 4);
        System.out.printf("NextId = %d\n", SquarePyramid.nextId);
        System.out.printf("Id = %d\n", sp_2.getId());
        System.out.printf("V = %f\n", sp_2.getVolume());
    }

}
