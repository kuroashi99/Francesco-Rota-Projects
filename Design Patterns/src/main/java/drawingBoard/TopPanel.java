package board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TopPanel extends JPanel {
	
	//This can be ignored for the moment
	private static final long serialVersionUID = 7626405727960172809L;
	private JButton backButton;
	private JButton colorButton;
	private JButton cleanButton;
	
	public TopPanel(Board board) {		
		setPreferredSize(new Dimension(Settings.WIDTH,40));
		backButton = new JButton("Change background");
		colorButton = new JButton("Change color");
		cleanButton = new JButton("Clean");
		//Choose layout
		this.setLayout(new GridLayout(1,3));
		this.add(backButton);
		this.add(colorButton);
		this.add(cleanButton);
		
		addListeners(board);
	}
	
	private void addListeners(Board board) {
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileFilter imageFilter = new FileNameExtensionFilter(
					    "Image files", ImageIO.getReaderFileSuffixes());
				JFileChooser f = new JFileChooser();
				f.setFileFilter(imageFilter);
				int res = f.showOpenDialog(null);
				if(res == JFileChooser.APPROVE_OPTION) {
					File file = f.getSelectedFile();
					try {
						BufferedImage img = ImageIO.read(file);
						board.setBackground(img);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: cannot open the image");
					}
				}
			}
		});
		
		colorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose a new color", board.getColor());
				if(color != null) {
					board.setColor(color);
				}
			}
		});
		
		cleanButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				board.clean();
			}
		});
	}
}
