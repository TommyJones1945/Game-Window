import javax.swing.JFrame;

public class ProjectTest {
	public  static void main(String[] arg) {
		
		JFrame frame1 = new JFrame(); // frame is created
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Project project1 = 	new Project();
		frame1.add(project1);
		frame1.setSize(1000, 1000); // size
		frame1.setVisible(true); // visibility
	}

}
