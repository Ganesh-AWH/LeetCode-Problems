class Spreadsheet {
    int [][]sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int column = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1))-1;

        sheet[row][column] = value;
    }
    
    public void resetCell(String cell) {
        this.setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        
        int index = formula.indexOf('+');
        String left = formula.substring(1, index);
        String right = formula.substring(index+1);

        int leftVal = Character.isLetter(left.charAt(0)) 
                        ? sheet[Integer.parseInt(left.substring(1)) - 1][left.charAt(0) - 'A']
                        : Integer.parseInt(left);

        int rightVal = Character.isLetter(right.charAt(0))
                        ? sheet[Integer.parseInt(right.substring(1)) - 1][right.charAt(0) - 'A']
                        : Integer.parseInt(right);

        return leftVal + rightVal;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */