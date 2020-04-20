import java.awt.*;

/**
	Esta classe representa a bola usada no jogo. A classe princial do jogo (Pong)
	instancia um objeto deste tipo quando a execução é iniciada.
*/

public class Ball {

	/**
		Construtor da classe Ball. Observe que quem invoca o construtor desta classe define a velocidade da bola 
		(em pixels por millisegundo), mas não define a direção deste movimento. A direção do movimento é determinada 
		aleatóriamente pelo construtor.

		@param cx coordenada x da posição inicial da bola (centro do retangulo que a representa).
		@param cy coordenada y da posição inicial da bola (centro do retangulo que a representa).
		@param width largura do retangulo que representa a bola.
		@param height altura do retangulo que representa a bola.
		@param color cor da bola.
		@param speed velocidade da bola (em pixels por millisegundo).
	*/

	double cx;
	double cy;
	double width;
	double height;
	Color color; 
	double speed;
	double speedX;
	double speedY;

	public Ball(double cx, double cy, double width, double height, Color color, double speed){
		this.cx = cx;
		this.cy = cy;
		this.width = width;
		this.height = height;
		this.color = color;
		this.speed = speed;
		this.speedX = (this.speed);
		this.speedY = (this.speed);
	}

	/**
		Método chamado sempre que a bola precisa ser (re)desenhada.
		Detalhe: o y começa a ser contado de cima para baixo
		O meio da arena é 400 e 300
		a bola encosta na borda inferior direita quando está na posição 770 e 570
	*/

	public void draw(){

		GameLib.setColor(color);
		GameLib.fillRect(cx, cy, width, height); //nros que estavam antes: 400, 300. 20, 20
	}

	/**
		Método chamado quando o estado (posição) da bola precisa ser atualizado.
		
		@param delta quantidade de millisegundos que se passou entre o ciclo anterior de atualização do jogo e o atual.
	*/

	public void update(long delta){
		cx = cx + speedX*delta;
		cy = cy + speedY*delta;
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com um jogador.
	
		@param playerId uma string cujo conteúdo identifica um dos jogadores.
	*/

	public void onPlayerCollision(String playerId){
		this.speedX = this.speedX*(-1);
	}

	/**
		Método chamado quando detecta-se uma colisão da bola com uma parede.

		@param wallId uma string cujo conteúdo identifica uma das paredes da quadra. |
	*/

	public void onWallCollision(String wallId){   
		if((cx >= 30 && cx <= 770) && (cy <= 120)){  // cima 
			this.speedY = this.speedY*(-1);
		}else if((cx >= 30 && cx <= 770) && (cy >= 570)){  // baixo
			this.speedY = this.speedY*(-1);
		}else if((cy >= 30 && cy <= 570) && (cx >= 30 || cx <= 770)){  // direita e esquerda
			this.speedX = this.speedX*(-1);
		}
	}

	/**
		Método que verifica se houve colisão da bola com uma parede.

		@param wall referência para uma instância de Wall contra a qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/
	
	public boolean checkCollision(Wall wall){
		
		if((wall.getId().equals("Left")) && (wall.getCx() >= this.cx)){
			return true;
		}
		if((wall.getId().equals("Right")) && (wall.getCx() <= this.cx)){
			return true;
		}
		if((wall.getId().equals("Bottom")) && (wall.getCy() <= this.cy)){
			return true;
		}
		if((wall.getId().equals("Top")) && (wall.getCy() >= this.cy)){
			return true;
		}
		return false;

	}

	/**
		Método que verifica se houve colisão da bola com um jogador.

		@param player referência para uma instância de Player contra o qual será verificada a ocorrência de colisão da bola.
		@return um valor booleano que indica a ocorrência (true) ou não (false) de colisão.
	*/	

	public boolean checkCollision(Player player){
		if(player.getId().equals("Player 1") &&  
		  (player.getCx() + player.getWidth()/2.0 >= cx - width/2.0 &&
		  (cy - 1 <= player.getCy() - player.getHeight()/2.0 || cy + 1 >= player.getCy() + player.getHeight()))){
			return true;
		}else if(player.getId().equals("Player 2") && 
		  (player.getCx() - player.getWidth()/2.0 <= cx + width/2.0 &&
		  (player.getHeight()/2.0 + player.getCy() - (cy + height) >= 0 && player.getHeight()/2.0 + player.getCy() - (cy + height) <= player.getHeight()/2.0 + player.getCy() ))){
			return true;
		}
		return false;
	}

	/** player 2
	if(x da bolinha é maior ou igual a x do player  E  y da bolinha está entre as pontas do player  )
	
	*/

	/**
		Método que devolve a coordenada x do centro do retângulo que representa a bola.
		@return o valor double da coordenada x.
	*/
	
	public double getCx(){

		return cx;
	}

	/**
		Método que devolve a coordenada y do centro do retângulo que representa a bola.
		@return o valor double da coordenada y.
	*/

	public double getCy(){

		return cy;
	}

	/**
		Método que devolve a velocidade da bola.
		@return o valor double da velocidade.

	*/

	public double getSpeed(){

		return speed;
	}

}
