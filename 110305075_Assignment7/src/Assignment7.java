import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Assignment7 {
	static OXGameManager manager = new OXGameManager();
	static JButton[] btns = new JButton[9];
	static JLabel score = new JLabel(String.format("O: %d ; X: %d", 0, 0));
	static JButton reStart = new JButton("ReStart");
	static JButton finish = new JButton("Finish");
	public static void main(String[] args) {
		// Implement GUI Layout here //
		// The window title is “Frame” //
		JFrame f = new JFrame("Frame");
		f.setSize(600,600);
		// JFrame size is (600, 600)//
		f.setLayout(new GridLayout(4, 3));
		// JFrame sets the layout for the JFrame to be a GridLayout with 4 rows and 3 columns.//
		// if we want a JFrame with GridLayout with 5 rows and 5 columns
		// eg: f.setLayout(new GridLayout(5,5));
		score.setFont(new Font("Arial", Font.PLAIN, 40));
		reStart.setFont(new Font("Arial", Font.PLAIN, 40));
		finish.setFont(new Font("Arial", Font.PLAIN, 40));
		// Implement reStart button here //
		reStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.initialize();
				for(int i = 0; i<9; i++) {
					btns[i].setText(Integer.toString(i));
					btns[i].setEnabled(true); // 啟用按鈕
				}
			}
		});
		// Implement finish button here //
		finish.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		for (int i=0; i<9; i++) {
			JButton btn = new JButton();
			//用來判斷單雙數
			int index = i;
			btn.setText(Integer.toString(i));
			btn.setFont(new Font("Arial", Font.PLAIN, 50));
			// Implement the checkerboard button //
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String player = manager.play(index);
					btn.setText(player);
					btn.setEnabled(false); // 禁用按鈕
					String winner = manager.checkWin();

					if(manager.finish()) {
						if(winner != null) {
							score.setText(String.format("O: %d ; X: %d", manager.getScoreO(), manager.getScoreX()));
							for(int k = 0; k< 9; k++){
								if(btns[k].isEnabled()) {
									btns[k].setEnabled(false);
								}
							}
						}
					}
				}
			});
			btns[i] = btn;
		}
		f.add(score);
		f.add(reStart);
		f.add(finish);
		for (int i=0; i<9; i++) { f.add(btns[i]); }
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
