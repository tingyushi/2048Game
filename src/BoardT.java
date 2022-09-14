/**
 * @File: BoardT.java
 * @Auther: Tingyu Shi - shit19
 * @Date: 2021 - 04 -08
 * @Description: ADT to represent the game board.
 */

package src;

import java.util.*;

/**
 * @brief This is an ADT to represent the game board.
 * @details The game board is represented as a 2D array. The size of
 * 			the game board can be decided by the user.
 */
public class BoardT {
	private int[][]  board;
	private int size;
	private int score;
	
	/**
	 * @brief This is the contructor of the game board.
	 * @param size The size of the game board.
	 * @throws exception wiil be raised if input argument is less or equal than 0.
	 */
	public BoardT(int size) {
		if (size <= 0){
			throw new IllegalArgumentException("board size should be greater than 0");
		}
        this.size = size;
		this.board = new int[this.size][this.size];	
		this.score = 0;
	}
	
	/*
	 * This function will move one row left.
	 * The return value means if the row has changed.
	 * */
	private boolean move_one_row_Left(int row_number) {
		ArrayList<Integer> non_zeros = new ArrayList<Integer>();
		int[] row_copy = new int[this.size];

		//get all non-zeros and copy the original board
		for (int i = 0; i < this.size; i++){
			row_copy[i] = board[row_number][i];
			if (this.board[row_number][i] != 0){
				non_zeros.add(this.board[row_number][i]);
			}
		}

		//merge numbers
		int[] row = new int[non_zeros.size()];
		for (int i = 0; i < row.length; i++){
			row[i] = non_zeros.get(i);
		}
		for (int i = 0; i < row.length - 1; i++){
			if (row[i] == row[i + 1]){
				row[i] *= 2;
				row[i + 1] = 0;
				this.score += row[i];
			}
		}

		// make the original array all 0
		for (int i = 0; i < this.size; i++) {
			this.board[row_number][i] = 0;
		}

		//assign results to the original board
		int board_index = 0;
		for (int i = 0; i < row.length; i++) {
			if (row[i] != 0) {
				this.board[row_number][board_index] = row[i];
				board_index++;
			}
		}

		// check if changed
		for (int i = 0; i < this.size; i++){
			if (row_copy[i] != this.board[row_number][i]){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * This function will move one row right.
	 * The return value means if the row has changed.
	 * */
	private boolean move_one_row_Right(int row_number){
		int[] row_copy = new int[this.size];
		ArrayList<Integer> non_zeros = new ArrayList<Integer>();

		//get all non-zero numbers and copy board
		for (int i = 0; i < this.size; i++){
			row_copy[i] = this.board[row_number][i];
			if (this.board[row_number][i] != 0){
				non_zeros.add(this.board[row_number][i]);
			}
		}

		//merge numbers
		int[] row = new int[non_zeros.size()];
		for (int i = 0; i < row.length; i++){
			row[i] = non_zeros.get(i);
		}
		for (int i = row.length - 1; i > 0; i--){
			if (row[i] == row[i - 1]){
				row[i] *= 2;
				row[i - 1] = 0;
				this.score += row[i];
			}
		}
		
		// make the original array all 0
		for (int i = 0; i < this.size; i++) {
			this.board[row_number][i] = 0;
		}
		
		//assign numbers back
		int board_index = this.size - 1;
		for (int i = row.length - 1; i > -1; i--) {
			if (row[i] != 0) {
				this.board[row_number][board_index] = row[i];
				board_index--;
			}
		}

		// check if changed
		for (int i = 0; i < this.size; i++){
			if (row_copy[i] != this.board[row_number][i]){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * This function will move one col up.
	 * The return value means if the col has changed.
	 * */
	private boolean move_one_col_Up(int col_number){
		int[] col_copy = new int[this.size];
		ArrayList<Integer> non_zeros = new ArrayList<Integer>();

		//get all non-zeros and copy col
		for (int i = 0; i < this.size; i++){
			col_copy[i] = this.board[i][col_number];
			if (this.board[i][col_number] != 0){
				non_zeros.add(this.board[i][col_number]);
			}
		}

		//merge numbers
		int[] col = new int[non_zeros.size()];
		for (int i = 0; i < col.length; i++){
			col[i] = non_zeros.get(i);
		}
		for (int i = 0; i < col.length - 1; i++){
			if (col[i] == col[i + 1]){
				col[i] *= 2;
				col[i + 1] = 0;
				this.score += col[i];
			}
		}
		
		// make the original array all 0
		for (int i = 0; i < this.size; i++) {
			this.board[i][col_number] = 0;
		}
		
		//assign number back
		int board_index = 0;
		for (int i = 0; i < col.length; i++) {
			if (col[i] != 0) {
				this.board[board_index][col_number] = col[i];
				board_index++;
			}
		}
		
		//check is changed
		for (int i = 0; i < this.size; i++){
			if (col_copy[i] != this.board[i][col_number]){
				return true;
			}
		}
		return false;
	}

	/*
	 * This function will move one col down.
	 * The return value means if the col has changed.
	 * */
	private boolean move_one_col_Down(int col_number){
		int[] col_copy = new int[this.size];
		ArrayList<Integer> non_zeros = new ArrayList<Integer>();

		//get all non-zeros and copy col
		for (int i = 0; i < this.size; i++){
			col_copy[i] = this.board[i][col_number];
			if (this.board[i][col_number] != 0){
				non_zeros.add(this.board[i][col_number]);
			}
		}

		//merge numbers
		int[] col = new int[non_zeros.size()];
		for (int i = 0; i < col.length; i++){
			col[i] = non_zeros.get(i);
		}
		for (int i = col.length - 1; i > 0; i--){
			if (col[i] == col[i - 1]){
				col[i] *= 2;
				col[i - 1] = 0;
				this.score += col[i];
			}
		}
		
		// make the original array all 0
		for (int i = 0; i < this.size; i++) {
			this.board[i][col_number] = 0;
		}
		
		//assign number back
		int board_index = this.size - 1;
		for (int i = col.length - 1; i > -1; i--) {
			if (col[i] != 0) {
				this.board[board_index][col_number] = col[i];
				board_index--;
			}
		}
		
		//check is changed
		for (int i = 0; i < this.size; i++){
			if (col_copy[i] != this.board[i][col_number]){
				return true;
			}
		}
		return false;
	}

	/**
	 * Move the whole board left.
	 * The reture value is if the board is changed.
	 */
	private boolean moveLeft(){
		Boolean[] is_changed = new Boolean[this.size];
		for (int i = 0; i < this.size; i++){
			is_changed[i] = move_one_row_Left(i);
		}

		for (int i = 0; i < this.size; i++){
			if (is_changed[i]){
				return true;
			}
		}
		return false;

	}

	/**
	 * Move the whole board right.
	 * The reture value is if the board is changed.
	 */
	private boolean moveRight(){
		Boolean[] is_changed = new Boolean[this.size];
		for (int i = 0; i < this.size; i++){
			is_changed[i] = move_one_row_Right(i);
		}

		for (int i = 0; i < this.size; i++){
			if (is_changed[i]){
				return true;
			}
		}
		return false;

	}

	/**
	 * Move the whole board up.
	 * The reture value is if the board is changed.
	 */
	private boolean moveUp(){
		Boolean[] is_changed = new Boolean[this.size];
		for (int i = 0; i < this.size; i++){
			is_changed[i] = move_one_col_Up(i);
		}

		for (int i = 0; i < this.size; i++){
			if (is_changed[i]){
				return true;
			}
		}
		return false;

	}

	/**
	 * Move the whole board down.
	 * The reture value is if the board is changed.
	 */
	private boolean moveDown(){
		Boolean[] is_changed = new Boolean[this.size];
		for (int i = 0; i < this.size; i++){
			is_changed[i] = move_one_col_Down(i);
		}

		for (int i = 0; i < this.size; i++){
			if (is_changed[i]){
				return true;
			}
		}
		return false;
	}

	/**
	 * @brief Perform Move operation on the game board.
	 * @param dir This is the move direction, it can be left, right, up or down.
	 * @return A boolean value to check if the board is changed after the move operation.
	 * 		   If the return value is true, the board is changed, otherwise the board is unchanged.
	 */
	public boolean move(MoveDirection dir){
		Boolean is_changed;
		if (dir == MoveDirection.UP){
			is_changed = moveUp();
		}else if(dir == MoveDirection.DOWN){
			is_changed = moveDown();
		}else if(dir == MoveDirection.LEFT){
			is_changed = moveLeft();
		}else{
			is_changed = moveRight();
		}
		return is_changed;
	}

	/**
	 * @brief Randomly choose an empty cell in the board and put a value in that cell.\n
	 * 		  If the board is full, then just return.
	 * @param value The value to put into the empty cell.
	 */
	public void put_one_random_number(int value){
		Random rand = new Random();
		int select;
		ArrayList<Integer> x_coord = new ArrayList<Integer>();
		ArrayList<Integer> y_coord = new ArrayList<Integer>();
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				if (this.board[i][j] == 0) {
					x_coord.add(i);
					y_coord.add(j);
				}
			}
		}

		//handle the situation where the board is full
		if (x_coord.size() == 0){
			return;
		}

		select = rand.nextInt(x_coord.size());
		this.board[x_coord.get(select)][y_coord.get(select)] = value;
	}
	
	/**
	 * @brief Check if any potential moves can be performed on the board.\n
	 * 		  If no more moves can be made, game is end.
	 * @return If the return value is true, then there exists moves can be performed,
	 * 			otherwise, no more moves can be made.
	 */
	public boolean is_end(){
		if (this.has_empty_cell()){
			return false;
		}
		int temp_score = this.score;
		int[][] temp_board = new int[this.size][this.size];
		for (int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++){
				temp_board[i][j] = this.board[i][j];
			}
		}

		if (moveLeft() || moveDown() || moveRight() || moveUp()){
			//recover the original board
			for (int i = 0; i < this.size; i++){
				for (int j = 0; j < this.size; j++){
					this.board[i][j] = temp_board[i][j];
				}
			}
			this.score = temp_score;
			return false;
		}
		this.score = temp_score;
		return true;
	}

	/**
	 * @brief Set a specific value to a specific cell.\n
	 * 		  This is used when testing. 
	 * @param i x-coordinate of the cell.
	 * @param j y-coordinate of the cell.
	 * @param value The value needs to be put in.
	 * @throws exception will be raised when the position represented by
	 * 			i and j is not in the board
	 */
	public void set_board(int i, int j, int value){
		if (i < 0 || i >=this.size || j < 0 || j >= this.size){
			throw new IllegalArgumentException("Please make sure that 0 <= i < this.size and 0 <= j < this.size");
		}
		this.board[i][j] = value;
	}
	
	/**
	 * @return A boolean value to check if the board has empty cells.\n
	 * 		   If the return value is true, then board has empty cells.\n
	 * 		   If the return value is false, then board has no empty cells.
	 */
	public boolean has_empty_cell() {
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[0].length; j++) {
				if (this.board[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @return The score of the game board.
	 */
	public int get_score() {
		return this.score;
	}
	
	/**
	 * @return The game board.
	 */
	public int[][] get_board() {
		return this.board;
	}

	/**
	 * @return The size of the game board.
	 */
    public int get_size(){
        return this.size;
    }

	/**
	 * @brief This method is used to compare if this.board is the same 
	 * 		  as the given 2D array.
	 * @param arr A 2D array needs to be compared with.
	 * @return If two 2D arraies are the same.
	 * @throws exception will be raised if given 2D array has different size compared with this.board
	 */
	public boolean equals(int[][] arr){
		if (arr.length != this.size || arr[0].length != this.size){
			throw new IllegalArgumentException("Given 2D array has different size compared with this.board");
		}
		for (int i = 0; i < this.size; i++){
			for (int j = 0; j < this.size; j++){
				if (this.board[i][j] != arr[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}