package com.framework;

import java.awt.image.BufferedImage;

import com.window.BufferedImageLoader;

public class Texture {

	SpriteSheet bs, ps;
	private BufferedImage block_sheet = null;
	private BufferedImage player_sheet = null;
	
	public BufferedImage[] block = new BufferedImage[4];
	public BufferedImage[] player = new BufferedImage[64];
	public BufferedImage[] player_jump = new BufferedImage[10];
	
	public Texture() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			block_sheet = loader.loadImage("/MZTiles.png");
			player_sheet = loader.loadImage("/88042.png");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		bs = new SpriteSheet(block_sheet);
		ps = new SpriteSheet(player_sheet);
		
		getTextures();
		
	}
	
	private void getTextures() {
		block[0] = bs.grabImage(335,545,30,30);
		block[1] = bs.grabImage(2,1,16,16);
		block[2] = bs.grabImage(3,1,32,32);
		block[3] = bs.grabImage(4,1,32,32);
		
		player[0] = ps.grabPlayer(6, 1692, 25, 36);// idle facing right 1
		player[1] = ps.grabPlayer(34, 1692, 25, 36);// idle facing right 2
		player[2] = ps.grabPlayer(62, 1692, 25, 36);// idle facing right 3
		player[3] = ps.grabPlayer(90, 1692, 25, 36);// idle facing right 4
		player[4] = ps.grabPlayer(90 + 28, 1692, 25, 36);// idle facing right 5
		player[5] = ps.grabPlayer(90, 1692, 25, 36);// idle facing right 6
		player[6] = ps.grabPlayer(62, 1692, 25, 36);// idle facing right 7
		player[7] = ps.grabPlayer(34, 1692, 25, 36);// idle facing right 8
		player[8] = ps.grabPlayer(6, 1692, 25, 36);// idle facing right 9
		
		player[11] = ps.grabPlayer(10, 1355, 22, 36);// moving right frame 1
		player[12] = ps.grabPlayer(44, 1355, 24, 36);// moving right frame 2
		player[13] = ps.grabPlayer(75, 1355, 32, 36);// moving right frame 3
		player[14] = ps.grabPlayer(111, 1355, 32, 36);// moving right frame 4
		player[15] = ps.grabPlayer(144, 1355, 32, 36);// moving right frame 5
		player[16] = ps.grabPlayer(184, 1355, 22, 36);// moving right frame 6
		player[17] = ps.grabPlayer(217, 1355, 22, 36);// moving right frame 7
		player[18] = ps.grabPlayer(252, 1355, 23, 36);// moving right frame 8
		player[19] = ps.grabPlayer(284, 1355, 30, 36);// moving right frame 9
		player[20] = ps.grabPlayer(320, 1355, 27, 36);// moving right frame 10
		
		player[21] = ps.grabPlayer(6, 1565, 25, 36);// idle facing left 1
		player[22] = ps.grabPlayer(34, 1565, 25, 36);// idle facing left 2
		player[23] = ps.grabPlayer(60, 1565, 25, 36);// idle facing left 3 
		player[24] = ps.grabPlayer(88, 1565, 25, 36);// idle facing left 4
		player[25] = ps.grabPlayer(88 + 26, 1565, 25, 36);// idle facing left 5
		player[26] = ps.grabPlayer(88, 1565, 25, 36);// idle facing left 6
		player[27] = ps.grabPlayer(60, 1565, 25, 36);// idle facing left 7
		player[28] = ps.grabPlayer(34, 1565, 25, 36);// idle facing left 8
		player[29] = ps.grabPlayer(6, 1565, 25, 36);// idle facing left 9
		
		player[30] = ps.grabPlayer(318, 1179, 22, 36);// moving left frame 10
		player[31] = ps.grabPlayer(282, 1178, 24, 37);// moving left frame 9
		player[32] = ps.grabPlayer(245, 1177, 32, 36);// moving left frame 8
		player[33] = ps.grabPlayer(212, 1178, 30, 37);// moving left frame 7
		player[34] = ps.grabPlayer(180, 1178, 28, 37);// moving left frame 6
		player[35] = ps.grabPlayer(148, 1179, 22, 36);// moving left frame 5
		player[36] = ps.grabPlayer(112, 1178, 24, 37);// moving left frame 4
		player[37] = ps.grabPlayer(72, 1177, 32, 37);// moving left frame 3
		player[38] = ps.grabPlayer(42, 1177, 30, 36);// moving left frame 2
		player[39] = ps.grabPlayer(10, 1178, 27, 36);// moving left frame 1
		
		player[41] = ps.grabPlayer(3, 1520, 22, 39);// looking up facing right frame 11
		player[42] = ps.grabPlayer(26, 1520, 22, 39);// looking up facing right frame 10
		player[43] = ps.grabPlayer(48, 1520, 22, 39);// looking up facing right frame 9
		player[44] = ps.grabPlayer(70, 1520, 22, 39);// looking up facing right frame 8
		player[45] = ps.grabPlayer(92, 1520, 22, 39);// looking up facing right frame 7
		player[46] = ps.grabPlayer(114, 1520, 22, 39);// looking up facing right frame 6
		player[47] = ps.grabPlayer(136, 1520, 22, 39);// looking up facing right frame 5
		player[48] = ps.grabPlayer(158, 1520, 22, 39);// looking up facing right frame 4
		player[49] = ps.grabPlayer(180, 1520, 22, 39);// looking up facing right frame 3
		player[50] = ps.grabPlayer(202, 1520, 22, 39);// looking up facing right frame 2
		player[51] = ps.grabPlayer(223, 1520, 22, 39);// looking up facing right frame 1
		
		player[52] = ps.grabPlayer(244, 1520, 22, 39);// looking up facing left frame 1
		player[53] = ps.grabPlayer(266, 1520, 22, 39);// looking up facing left frame 2
		player[54] = ps.grabPlayer(288, 1520, 22, 39);// looking up facing left frame 3
		player[55] = ps.grabPlayer(310, 1520, 22, 39);// looking up facing left frame 4
		player[56] = ps.grabPlayer(332, 1520, 22, 39);// looking up facing left frame 5
		player[57] = ps.grabPlayer(354, 1520, 22, 39);// looking up facing left frame 6
		player[58] = ps.grabPlayer(376, 1520, 22, 39);// looking up facing left frame 7
		player[59] = ps.grabPlayer(398, 1520, 22, 39);// looking up facing left frame 8
		player[60] = ps.grabPlayer(398 + 22, 1520, 22, 39);// looking up facing left frame 9
		player[61] = ps.grabPlayer(398 + 44, 1520, 22, 39);// looking up facing left frame 10
		player[62] = ps.grabPlayer(398 + 66, 1520, 22, 39);// looking up facing left frame 11
		
		player[63] = ps.grabPlayer(10, 15, 16, 34);//climbing frame
		
		player_jump[0] = ps.grabImage(104, 798, 22, 38);// jumping straight up facing right
		player_jump[1] = ps.grabImage(127, 798, 22, 38);// jumping straight up
		player_jump[2] = ps.grabImage(151, 798, 22, 38);// jumping straight up
		player_jump[3] = ps.grabImage(175, 798, 22, 38);// jumping straight up
		player_jump[4] = ps.grabImage(199, 798, 22, 38);// jumping straight up
		player_jump[5] = ps.grabImage(230, 850, 22, 38);// jumping straight up facing left
		player_jump[6] = ps.grabImage(254, 850, 22, 38);// jumping straight up
		player_jump[7] = ps.grabImage(278, 850, 22, 38);// jumping straight up
		player_jump[8] = ps.grabImage(302, 850, 22, 38);// jumping straight up
		player_jump[9] = ps.grabImage(326, 850, 22, 38);// jumping straight up
		
	}
}
