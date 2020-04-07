public class conwayGameOfLife
{
        public static void main(String[] args)
        {
            int col = 10, row = 10;

            String[][] grid = {
                    {"+","+","+","#","+","+","+","+","+","#"},//1
                    {"+","+","+","+","+","+","+","+","+","+"},//2
                    {"+","+","+","#","+","+","+","+","+","#"},//3
                    {"+","+","+","#","#","+","+","+","+","+"},//4
                    {"+","+","+","#","+","#","+","+","+","+"},//5
                    {"+","+","+","+","+","+","+","+","+","+"},//6
                    {"+","+","+","+","+","+","+","+","+","+"},//7
                    {"+","+","#","#","+","+","+","+","+","+"},//8
                    {"+","+","+","+","+","+","+","+","+","+"},//9
                    {"+","+","+","+","+","+","+","#","+","#"}//1
            };
            System.out.println("Original Generation");

            for(int i = 0; i < 10; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    System.out.print(grid[i][j]);
                }
                System.out.println();
            }
            nextGeneration(grid, col, row);
        }

        public static void nextGeneration(String grid[][], int col, int row)
        {
            String[][] genGrid;
            System.out.println("Next Generation");

            for (int i = 0; i < col-1; i++)
            {
                for (int j = 0; j < row-1; j++)
                {
                    if (grid[i][j].matches("#") && (grid[i][j+1].matches("#")))
                    {
                            grid[i+1][j+1] = "#";
                    }
                    else if (grid[i][j].matches("#") && grid[i][j+1].matches("#") && grid[i][j+2].matches("#"))
                    {
                        grid[i][j+2].replace("#","+");
                    }
                }
            }
            genGrid=grid;
            for (int i = 0; i < col; i++)
            {
                for (int j = 0; j < row; j++)
                {
                    System.out.print(genGrid[i][j]);
                }
                System.out.println();
            }
        }
}
