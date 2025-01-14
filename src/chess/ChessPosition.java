package chess;

import boardgame.Position;

public class ChessPosition {
	
	private char column;
	private int row;
	
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Error instantiating chessPosition. Valid values are from a1 to h8");
		}
		this.column = column;
		this.row = row;
	}
	public char getColumn() {
		return column;
	}
	public int getRow() {
		return row;
	}
	//O c�digo a seguir � uma implementa��o de refer�ncias, a coluna � um vetor de 7 posi��es, por isto a refer�ncia da casa
	//digitada - 8 equivale visualmente a coluna correta que digitamos assim como usar o caracter unicode para percorrer
	//matematicamente, ex: a-a=0, a-b=1...
	protected Position toPosition() {
		return new Position(8 - row, column -'a');
	}
	//**Aqui agora voc� faz um casting com o char para a manipular os caracteres e convert�los de posi��o de matriz para posi��o**//
	//**do xadrez**//
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
