    class Solution {
        private List<List<String>> ans;
        public List<List<String>> solveNQueens(int n) {
            ans = new ArrayList<>();
            char[][] board = new char[n][n]; // where is n board dimensions
            // fill '.' initially in board
            for(char[] arr : board){
                Arrays.fill(arr, '.');
            }
            nQueen(board, 0); // where 0 is row index
            return ans;
        }
        private void nQueen(char[][] board, int i){
            // base case
            if(i==board.length){
                // set our answer
            //    [[. Q . .] -> ".Q.."
            //    [. . . Q] -> "...Q"
            //    [Q . . .] -> "Q..."
            //    [. . Q .] -> "..Q."
            //    ]
            List<String> bres = new ArrayList<>();
            for(int r=0;r<board.length;r++){
                String str ="";
                for(int c=0;c<board.length;c++){
                    str += board[r][c];
                }
                bres.add(str);
            }
            ans.add(bres);
            return;
            }
    
        for(int j=0;j<board.length;j++){
            if(isSafeToPlaceQueen(board, i, j)){
                //marking i, j index
                board[i][j] = 'Q';
                nQueen(board, i+1);
                // unmarking i,j to trigger backtracking
                board[i][j] = '.';
            }
        }
    }
        public boolean isSafeToPlaceQueen(char[][] board, int r, int c){
            // check top -> row decrement
            for(int i=r,j=c;i>=0;i--){
                if(board[i][j]=='Q') return false;
            }
            // check top right -> row decrement, col increment 
            for(int i=r, j=c; i>=0 && j<board.length;i--,j++){
                if(board[i][j]=='Q') return false;
            }
            // check top left -> row decrement , col decrement
            for(int i=r,j=c; i>=0 && j>=0; i--,j--){
                if(board[i][j]=='Q') return false;
            }
            return true;
        }

    }