package src;

import java.util.Random;
import java.util.Scanner;

/**
 * @brief This is the control unit of the game.
 */
public class GameControl {

	/**
	 * @brief This is the main function. The driver of the whole game.
	 * @param args
	 */
	public static void main(String[] args) {
		BoardT model = initialize_game();
		run_game(model);
	}

	/**
	 * @brief Initialize the game board when game starts.
	 * @return The initialized game board.
	 * @details The user will enter the board size they want to use. 
	 * 			Then number 2 or 4 will be put into two random empty cells.
	 */
	public static BoardT initialize_game(){
		DisplayGame.print_game_start();
		Scanner keyboard = new Scanner(System.in);
        String size = keyboard.nextLine();
        int board_size = Integer.parseInt(size);
		
		//handle wrong board size
		while(board_size <= 0){
			DisplayGame.print_wrong_size_input();
			size = keyboard.nextLine();
			board_size = Integer.parseInt(size);
		}

		BoardT model = new BoardT(board_size);
		Random rand = new Random();

		//initialize the board		
		int temp = rand.nextInt(101);
		if (temp < 70){
			model.put_one_random_number(2);
			model.put_one_random_number(2);
		}else{
			model.put_one_random_number(2);
			model.put_one_random_number(4);
		}
		DisplayGame.print_board(model);
		return model;
	}

	/**
	 * @brief Run the game on a given game board
	 * @param model The game board to be run.
	 * @details The board will performe corresponding moves according to the user inputs.
	 * 			After each move, the game board will be printed in the terminal. The game
	 * 			will not stop until the user quits game or no more moves can be made on the 
	 * 			game board.
	 */
	public static void run_game(BoardT model){
		Scanner keyboard = new Scanner(System.in);
		String command = " ";
		Random rand = new Random();
		int temp;
		boolean is_changed;

		while (true){
			if (model.is_end()){
				DisplayGame.print_game_fail();
				break;
			}

			DisplayGame.print_game_instruction();
			command = keyboard.nextLine();
			command = command.toUpperCase();
			
			while (!command.equals("L") && !command.equals("R") && !command.equals("U") && !command.equals("D") && !command.equals("Q")){
				DisplayGame.print_invalid_command();
				command = keyboard.nextLine();
				command = command.toUpperCase();
			}

			temp = rand.nextInt(101);

			if (command.equals("R")){

				is_changed = model.move(MoveDirection.RIGHT);
				if (is_changed){
					if (temp < 90){
						model.put_one_random_number(2);
					}else{
						model.put_one_random_number(4);
					}
				}
			
			}else if (command.equals("L")){

				is_changed = model.move(MoveDirection.LEFT);
				if (is_changed){
					if (temp < 90){
						model.put_one_random_number(2);
					}else{
						model.put_one_random_number(4);
					}
				}

			}else if (command.equals("U")){

				is_changed = model.move(MoveDirection.UP);
				if (is_changed){
					if (temp < 90){
						model.put_one_random_number(2);
					}else{
						model.put_one_random_number(4);
					}
				}

			}else if (command.equals("D")){

				is_changed = model.move(MoveDirection.DOWN);
				if (is_changed){
					if (temp < 90){
						model.put_one_random_number(2);
					}else{
						model.put_one_random_number(4);
					}
				}

			}else{
				DisplayGame.print_game_ending();
				break;
			}
			DisplayGame.print_board(model);
		}
	}

}