package edu.wpi.cs.wpisuitetng.modules.planningpoker.view.main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListOfGames extends JPanel {
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JPanel OptionalPanel;

	/**
	 * Create the panel.
	 */
	public ListOfGames() {
		setLayout(new MigLayout("", "[][450px][grow][grow]", "[300px,grow]"));
		
		JPanel ListPanel = new JPanel();
		add(ListPanel, "cell 1 0,grow");
		ListPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEstimatesPending = new JLabel("Estimates Pending:");
		ListPanel.add(lblEstimatesPending, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		ListPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Requirement", "Status"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("No Requirements");
		ListPanel.add(lblNewLabel, BorderLayout.SOUTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		OptionalPanel = new JPanel();
		add(OptionalPanel, "cell 2 0,grow");
		OptionalPanel.setLayout(new CardLayout(0, 0));
		
		JPanel SummaryPanel = new JPanel();
		OptionalPanel.add(SummaryPanel, "name_292469201088950");
		SummaryPanel.setLayout(new MigLayout("", "[grow][]", "[][grow][grow][grow]"));
		
		JLabel lblSummary = new JLabel("Summary:");
		SummaryPanel.add(lblSummary, "cell 0 0");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		SummaryPanel.add(scrollPane_1, "cell 0 1,grow");
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"User", "Estimate"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		JPanel StatsPanel = new JPanel();
		StatsPanel.setBorder(new TitledBorder(null, "Stats", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		StatsPanel.setToolTipText("test");
		SummaryPanel.add(StatsPanel, "cell 0 2,grow");
		StatsPanel.setLayout(new MigLayout("", "[34px][]", "[16px]"));
		
		JLabel lblMean = new JLabel("Mean:");
		StatsPanel.add(lblMean, "flowy,cell 0 0,alignx right,aligny top");
		
		JLabel label = new JLabel("");
		StatsPanel.add(label, "cell 1 0,aligny center");
		
		JLabel lblMedian = new JLabel("Median:");
		StatsPanel.add(lblMedian, "cell 0 1,alignx right");
		
		JLabel label_1 = new JLabel("");
		StatsPanel.add(label_1, "cell 1 1,aligny center");
		
		JPanel Admin = new JPanel();
		Admin.setBorder(new TitledBorder(null, "Admin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SummaryPanel.add(Admin, "cell 0 3,grow");
		Admin.setLayout(new MigLayout("", "[114px][][]", "[16px][20px]"));
		
		JLabel lblSetRequirement = new JLabel("Set Requirement");
		Admin.add(lblSetRequirement, "cell 0 0,alignx center,aligny center");
		
		textField = new JTextField();
		Admin.add(textField, "cell 1 0,alignx left,aligny center");
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		Admin.add(btnOk, "cell 2 0,aligny center");
		
		JPanel Blank = new JPanel();
		OptionalPanel.add(Blank, "name_292516405624772");
		Blank.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNoRequirementSelected = new JLabel("No Requirement Selected");
		lblNoRequirementSelected.setHorizontalAlignment(SwingConstants.CENTER);
		Blank.add(lblNoRequirementSelected);

	}

	protected JPanel getOptionalPanel() {
		return OptionalPanel;
	}
	
	public void flipPanel(){
		JPanel OptionalPanel = getOptionalPanel();
		CardLayout cl = (CardLayout) OptionalPanel.getLayout();
		cl.next(OptionalPanel);
		return;
	}
}
