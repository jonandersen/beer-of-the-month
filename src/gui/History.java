package gui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.ListModel;

import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class History extends javax.swing.JFrame {
	private JList jHistoryList;
	private JTextPane jInfoArea;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				String[] history =new String[] { "Breznak", "Carlsberg" };
				History inst = new History(history);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public History(String[] historyBeer) {
		super("History");
		initGUI(historyBeer);
	}
	
	private void initGUI(String[] historyBeer) {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jInfoArea = new JTextPane();
				getContentPane().add(jInfoArea, new AnchorConstraint(46, 970, 938, 537, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jInfoArea.setText("jTextPane1");
				jInfoArea.setPreferredSize(new java.awt.Dimension(169, 241));
				jInfoArea.setEditable(false);
				jInfoArea.setOpaque(false);
				jInfoArea.setFocusable(false);
			}
			{
				ListModel jHistoryListModel = 
					new DefaultComboBoxModel(historyBeer);
				jHistoryList = new JList();
				getContentPane().add(jHistoryList, new AnchorConstraint(46, 521, 938, 32, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jHistoryList.setModel(jHistoryListModel);
				jHistoryList.setPreferredSize(new java.awt.Dimension(191, 241));
				jHistoryList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent evt) {
						jHistoryListValueChanged(evt);
					}
				});
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void jHistoryListValueChanged(ListSelectionEvent evt) {
		if(!evt.getValueIsAdjusting()){
			
			int index = jHistoryList.getSelectedIndex();			
			jInfoArea.setText(String.valueOf(index));
		}
		
	}

}
