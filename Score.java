import java.awt.*;

/**
	Esta classe representa um placar no jogo. A classe princial do jogo (Pong)
	instancia dois objeto deste tipo, cada um responsável por gerenciar a pontuação
	de um player, quando a execução é iniciada.
*/

public class Score {

	/**
		Construtor da classe Score.

		@param playerId uma string que identifica o player ao qual este placar está associado.
	*/
	String playerId;

	public Score(String playerId){
		this.playerId = playerId;
	}

	/**
		Método de desenho do placar.
	*/

	public void draw(){

		GameLib.drawText(playerId + ":", 70, GameLib.ALIGN_LEFT);		// o segundo parametro é a posição de y do placar	
	}

	/**
		Método que incrementa em 1 unidade a contagem de pontos.
	*/

	public void inc(){
		// a lógica é adicionar um contador dentro do primeiro parametro
		GameLib.drawText(playerId + ":", 70, GameLib.ALIGN_LEFT);
	}

	/**
		Método que devolve a contagem de pontos mantida pelo placar.

		@return o valor inteiro referente ao total de pontos.
	*/

	public int getScore(){

		return 0;
	}
}
