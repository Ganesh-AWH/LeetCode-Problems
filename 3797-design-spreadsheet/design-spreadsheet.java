class Spreadsheet {

    int [][]sheet;
    public Spreadsheet(int rows) {
        sheet= new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int []data = extract(cell);
        int row = data[0];
        int column = data[1]; 
        this.sheet[row][column] = value;
    }
    
    public void resetCell(String cell) {
        this.setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        int indx = formula.indexOf('+');
        //why 1? neglecting = symbol
        // =A1+B2
        //eg. left -> A11
        String left = formula.substring(1, indx);
        //eg right -> B278
        String right = formula.substring(indx+1);

        int valLeft = Character.isLetter(left.charAt(0))
                    ? sheet[Integer.parseInt(left.substring(1)) - 1][left.charAt(0) - 'A']
                    :Integer.parseInt(left);

        int valRight = Character.isLetter(right.charAt(0)) 
                        ? sheet[Integer.parseInt(right.substring(1)) - 1][right.charAt(0)-'A']
                        : Integer.parseInt(right); 

        return valLeft + valRight;

    }
    //this function extracts row and columns
    public int[] extract(String str){
        //fetching the column number
        int column = str.charAt(0) - 'A';
        //fetching row number
        int row = Integer.parseInt(str.substring(1)) - 1;
        return new int[]{row, column};
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
        