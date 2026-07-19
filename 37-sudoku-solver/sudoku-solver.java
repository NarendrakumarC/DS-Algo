class Solution {
    private class Pair {
        int i;
        int j;
        Pair(int i, int j){
            this.i =i;
            this.j=j;
        }
    }

    public void solveSudoku(char[][] board) {
        // List of emptied cell to be fill
        List<Pair> arr = new ArrayList<>();
            for(int r=0; r<9; r++){
                for(int c=0; c<9; c++){
                    if(board[r][c] == '.'){
                            arr.add(new Pair(r,c));
                    }
                }
            }
          sudokuSolver(board, arr, 0); // index of 0th emptied cell   
    }
    // step 2 [(0,2),(0,3),(0,5),(0,6)..]
    private boolean sudokuSolver(char[][] board, List<Pair> arr, int indx){
        //base case
        if(indx == arr.size()){
            return true;
        }
        //Fetch row and col index from emptied cell
        int r = arr.get(indx).i;
        int c = arr.get(indx).j;
        //Explore all the option for current cell
        boolean rres = false;
        for(int num =1; num<=9; num++){
            if(isSafeToPlaceNumInSudoku(board, r, c, num)){
                // place
                board[r][c] =(char)(num+'0');
                rres = sudokuSolver(board, arr, indx+1);
                if(rres == true) return true;
                board[r][c] = '.';
            }
        }
        return false;
    }

    private boolean isSafeToPlaceNumInSudoku(char [][]board, int i, int j, int num){
        //for same row
        for(int r=i,c=0; c<9; c++){
            if(board[r][c] == (char)(num+'0')){
                return false;
            }
        }
        //for same col
        for(int r=0,c=j; r<9; r++){
            if(board[r][c] == (char)(num +'0')){
                return false;
            }
        }
        //for same submatrix
        int r = i - i % 3;
        int c = j - j % 3;
        for(int x=0; x<3; x++){
            for(int y=0; y<3; y++){
                int row = x + r;
                int col = y + c;
                if(board[row][col] == (char)(num+'0')){
                    return false;
                }
            }
        }
        return true; 
    }
}