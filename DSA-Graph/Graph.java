public class Graph {
    int size;
    String[] vertices;
    boolean[][] a;

    public Graph(String[] args) {
        size = args.length;
        vertices = new String[size];
        System.arraycopy(args, 0, vertices, 0, size);
        a = new boolean[size][size];
    }

    public void add(String v, String w) {
        int i = index(v), j = index(w);
        a[i][j] = a[j][i] = true;
    }

    private int index(String v) {
        for (int i = 0; i < size; i++) {
            if (vertices[i].equals(v)) {
                return i;
            }
        }
        return a.length; // or -1
    }

    public String toString(){

        if(size==0)  return "{ }";

        StringBuffer buf = new StringBuffer("{" + vertex(0));
        for (int i = 1; i <size; i++) {
            buf.append("," + vertex(i));
        }
        return buf + "}";
    }

    private String vertex(int i){

        StringBuffer buf = new StringBuffer(vertices[i] + ":");

        for(int j=0; j<size; j++){
            if(a[i][j])
                buf.append(vertices[j]);
        }

        return buf + " ";
    }

    public static void main(String[] args) {
        String[] vertices = {"A", "B", "C", "D", "E", "F", "G"};
        Graph g = new Graph(vertices);

        g.add("A", "B");
        g.add("A", "C");
        g.add("A", "D");
        g.add("A", "F");
        g.add("B", "C");
        g.add("B", "F");
        g.add("C", "C");
        g.add("C", "E");
        g.add("C", "G");
        g.add("D", "F");
        g.add("D", "G");
        g.add("E", "F");
        g.add("E", "G");

        System.out.println(g);
    }
}

