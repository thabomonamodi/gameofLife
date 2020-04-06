import static jdk.nashorn.internal.objects.NativeMath.random;

public class GameOfLife2
{
    int cells[];
    int scale = 20;
    int size;
    int width=10, height = 10;

    void setup() {
        size=width*height;
        size = width/scale;

        cells = new int[size * size];

        for(int i = 0; i < cells.length; i ++) {
            if(random(1) < size) {
                cells[i] = 1;
            } else {
                cells[i] = 0;
            }
        }
    }

    int numN(int i, int j) {
        int num = 0;

        for(int x = -1; x <= 1; x ++) {
            for(int y = -1; y <= 1; y ++) {
                if(x == 0 && y == 0) continue;
                int ni = i + x;
                int nj = j + y;
                num += cells[pos(ni, nj)];
            }
        }
        return num;
    }
    int pos(int i, int j)
    {
        i = constrain(i, 0, size-1);
        j = constrain(j, 0, size-1);
        return i+j*size;
    }

    private int constrain(int i, int i1, int i2)
    {
        return i+i1+i2;
    }

    void nextCells() {
        int[] next = cells.clone();
        for(int i = 0; i < size; i ++) {
            for(int j = 0; j < size; j ++) {
                int n = numN(i, j);
                if(cells[pos(i, j)] == 1) {
                    if(n < 2 || n > 3) {
                        next[pos(i, j)] = 0;
                    }
                } else {
                    if(n == 3) {
                        next[pos(i, j)] = 1;
                    }
                }
            }
        }
        cells = next.clone();
    }


    void zero()
    {
        for(int i = 0; i < cells.length; i ++) {
            cells[i] = 0;
        }
    }
    public static void main(String[] args)
    {
        int wid = 10, hei = 10;
        try
        {
            new GameOfLife2().setup();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }


    }
}
