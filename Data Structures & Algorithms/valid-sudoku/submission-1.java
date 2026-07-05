class Solution {
    public boolean isValidSudoku(char[][] board) {
        //make hashsets for the comparison
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        //creating sets for storing nums in each roe, col, boxe
        for(int i = 0; i<9; i++){
                row[i] = new HashSet<>();
                col[i] = new HashSet<>();
                boxes[i] = new HashSet<>();
        }

        //checking the sets
        for(int r =0; r< 9 ; r++){
            for(int c = 0; c<9; c++){
                char num = board[r][c];
                
                if (num == '.') {
                    continue;
                }
                int box = (r/3)*3 + (c/3);

                if(row[r].contains(num)||
                col[c].contains(num)||
                boxes[box].contains(num)
                ){
                    return false;
                } 

                row[r].add(num);
                col[c].add(num);
                boxes[box].add(num);
            }
        }
        return true;
    }
}
