import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class CalcFrame extends JFrame{
	private JButton btnEqual;
	private JTextField textFieldA, textFieldB;
	private JRadioButton rbtnAdd, rbtnSub, rbtnMul, rbtnDiv;
	private JTextArea outputArea;
	//constructor
	public CalcFrame() {
		outputArea = new JTextArea(8, 12);
		outputArea.setEditable(false);
		createTextField();
		createButton();
		createRbtn();
		createLayout();
		setSize(600, 200);
	}
		private void createTextField() {
			textFieldA = new JTextField(10);
			textFieldB = new JTextField(10);
		}
		private void createRbtn() {
			rbtnAdd = new JRadioButton("+");
			rbtnSub = new JRadioButton("-");
			rbtnMul = new JRadioButton("*");
			rbtnDiv = new JRadioButton("/");
			
			ButtonGroup group = new ButtonGroup();
			group.add(rbtnAdd);
			group.add(rbtnSub);
			group.add(rbtnMul);
			group.add(rbtnDiv);
			

		}
		private void createButton(){
			btnEqual = new JButton("=");
			
			btnEqual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Double a = Double.parseDouble(textFieldA.getText());
					Double b = Double.parseDouble(textFieldB.getText());
					
					if(rbtnAdd.isSelected()) {
						outputArea.append(getResult(a, "+", b)+"\n");
					}else if(rbtnSub.isSelected()) {
						outputArea.append(getResult(a, "-", b)+"\n");
					}else if(rbtnMul.isSelected()) {
						outputArea.append(getResult(a, "*", b)+"\n");
					}else {
						outputArea.append(getResult(a, "/", b)+"\n");
					}
				}
			});
			
			
		}
		private String getResult(double a, String op, double b) {
			double p = 0.00;
			if(op == "+") {
				p = a+b;
			}else if(op == "-") {
				p = a-b;
			}else if(op == "*") {
				p = a*b;
			}else {
				p = a/b;
			}
			String k = String.format("%.2f %s %.2f = %.2f", a, op, b, p);
			return k;
			
		}
		private void createLayout(){
			JPanel flow_panel = new JPanel();
			JPanel rbtn_panel = new JPanel(new GridLayout(4,1));
			rbtn_panel.add(this.rbtnAdd);
			rbtn_panel.add(this.rbtnSub);
			rbtn_panel.add(this.rbtnMul);
			rbtn_panel.add(this.rbtnDiv);
			flow_panel.add(this.textFieldA);
			flow_panel.add(rbtn_panel);
			flow_panel.add(this.textFieldB);
			flow_panel.add(this.btnEqual);
			flow_panel.add(new JScrollPane(outputArea));
			add(flow_panel);
		}
}

	