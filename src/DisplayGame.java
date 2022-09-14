/**
 * @File DisplayGame.java 
 * @Auther Tingyu Shi - shit19
 * @Date 2021 - 04 - 08
 * @Description This module is for viewing the game board.
 */

package src;


/**
 * @brief This module is for viewing the game board.(View unit)
 */
public class DisplayGame {

	/**
	 * @brief Print board as text character in the terminal.
	 * @param board The board to be printed.
	 */
	public static void print_board(BoardT board) {
		String [][] str_board = new String[board.get_size()][board.get_size()];
		int max_string_size = 0;
		
		for (int i = 0; i < board.get_size(); i++){
			for (int j = 0; j < board.get_size(); j++){
				str_board[i][j] = Integer.toString(board.get_board()[i][j]);
			}
		}

		for (int i = 0; i < board.get_size(); i++){
			for (int j = 0; j < board.get_size(); j++){
				if (str_board[i][j].length() > max_string_size){
					max_string_size = str_board[i][j].length();
				}
			}
		}
		System.out.println(get_repeat_string("-", board.get_size() + 1 + max_string_size * board.get_size()));
		for (int i = 0; i < board.get_size(); i++) {
			for (int j = 0; j < board.get_size(); j++){
				String temp_string = Integer.toString(board.get_board()[i][j]);
				if (board.get_board()[i][j] == 0){
					System.out.print("|" + get_repeat_string(" ", max_string_size));
				}else{
					System.out.print("|" + temp_string + get_repeat_string(" ", max_string_size - temp_string.length()));
				}
			}
			if (i == 0){
				System.out.print('|');
				System.out.println("        Score: " + Integer.toString(board.get_score()));
				System.out.println(get_repeat_string("-", board.get_size() + 1 + max_string_size * board.get_size()));
			}else{
				System.out.println('|');
				System.out.println(get_repeat_string("-", board.get_size() + 1 + max_string_size * board.get_size()));
			}
		}
	}

	private static String get_repeat_string(String s, int times){
		String ans = "";
		for (int i = 0; i < times; i++){
			ans += s;
		}
		return ans;
	}

	/**
	 * @brief Print the message at the beginning of the game.
	 */
	public static void print_game_start(){
		System.out.println("--------------------------------");
		System.out.println("           GAME START           ");
		System.out.println("--------------------------------");
		System.out.print("Please enter the Board Size(only numbers are allowed) and then press \"Enter\":");
	}

	/**
	 * @brief Print the information of how to play the game.
	 */
	public static void print_game_instruction(){
		System.out.println("Enter \"R\" to move right");
		System.out.println("Enter \"L\" to move left");
		System.out.println("Enter \"U\" to move up");
		System.out.println("Enter \"D\" to move down");
		System.out.println("Enter \"Q\" to finish the game");
		System.out.print("Please enter your choice and then press \"Enter\":");
	}

	/**
	 * @brief Print the ending message when the user exits the game.
	 */
	public static void print_game_ending(){
		System.out.println("--------------------------------");
		System.out.println("       Thanks for playing!!     ");
		System.out.println("--------------------------------");
		System.out.println("To start a new game, please type \"make expt\" in the terminal");
	}

	/**
	 * @brief Print message to remind the user that the input command is incorrect.\n
	 * 		  Also, tell the user to enter a new command.
	 */
	public static void print_invalid_command(){
		System.out.println("The command is incorrect.");
		System.out.print("Please enter again and then press \"Enter\":");
	}

	/**
	 * @brief Print the message when game fails.
	 */
	public static void print_game_fail(){
		System.out.println("--------------------------------");
		System.out.println("   No more moves can be made!!  ");
		System.out.println("           Game Over!!          ");
		System.out.println("--------------------------------");
		System.out.println("To start a new game, please type \"make expt\" in the terminal");
	}

	/**
	 * @brief Print the message when input Board Size is less or equal zero.
	 */
	public static void print_wrong_size_input(){
		System.out.println("The Board Size should be greater than zero.");
		System.out.print("Please enter again and then press \"Enter\":");
	}
}
