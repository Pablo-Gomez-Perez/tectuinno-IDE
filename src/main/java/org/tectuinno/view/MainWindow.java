/*
 * This file is part of Tectuinno IDE.
 *
 * Tectuinno IDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 * As a special exception, you may use this file as part of a free software
 * library without restriction. Specifically, if other files instantiate
 * templates or use macros or inline functions from this file, or you compile
 * this file and link it with other files to produce an executable, this
 * file does not by itself cause the resulting executable to be covered by
 * the GNU General Public License. This exception does not however
 * invalidate any other reasons why the executable file might be covered by
 * the GNU General Public License.
 *
 * Copyright 2025 Tectuinno Team (https://github.com/tectuinno)
 */


package org.tectuinno.view;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.tectuinno.compiler.assembler.AsmLexer;
import org.tectuinno.compiler.assembler.AsmParser;
import org.tectuinno.compiler.assembler.utils.Token;
import org.tectuinno.utils.DialogResult;
import org.tectuinno.utils.FileType;
import org.tectuinno.view.assembler.AsmEditorInternalFrame;
import org.tectuinno.view.component.ResultConsolePanel;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;

import javax.swing.DebugGraphics;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu JMenuArchivo;
	private JMenu JMenuArchivoNuevo;
	private JMenuItem MenuItemNvoAsm;
	private JMenu JMenuProyecto;
	private JMenuItem MenuItemFicheroTexto;
	private JSplitPane SplitPanePrincipal;
	private JSplitPane splitPaneEditorAndConsole;
	private JPanel panelToolBar;
	private JToolBar compilerToolBar;
	private JDesktopPane desktopPane;
	private ResultConsolePanel consolePanel;
	private JButton btnAnalice;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		
	}*/

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setConsoleDividerLocationEvent();
			}
		});
		setTitle("Tectuinno IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 692);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuArchivo = new JMenu("Archivo");
		menuBar.add(JMenuArchivo);
		
		JMenuArchivoNuevo = new JMenu("Nuevo");
		JMenuArchivo.add(JMenuArchivoNuevo);
		
		MenuItemNvoAsm = new JMenuItem("Fichero ASM Risc-V");
		MenuItemNvoAsm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openNewAsmEditor();
			}
		});
		JMenuArchivoNuevo.add(MenuItemNvoAsm);
		
		MenuItemFicheroTexto = new JMenuItem("Texto");
		JMenuArchivoNuevo.add(MenuItemFicheroTexto);
		
		JMenuProyecto = new JMenu("Proyecto");
		menuBar.add(JMenuProyecto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		SplitPanePrincipal = new JSplitPane();
		SplitPanePrincipal.setBackground(new Color(105, 105, 105));
		contentPane.add(SplitPanePrincipal, BorderLayout.CENTER);
		
		splitPaneEditorAndConsole = new JSplitPane();
		splitPaneEditorAndConsole.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		splitPaneEditorAndConsole.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		splitPaneEditorAndConsole.setDividerSize(5);
		splitPaneEditorAndConsole.setContinuousLayout(false);
		splitPaneEditorAndConsole.setOrientation(JSplitPane.VERTICAL_SPLIT);
		SplitPanePrincipal.setRightComponent(splitPaneEditorAndConsole);
		
		desktopPane = new JDesktopPane();
		splitPaneEditorAndConsole.setLeftComponent(desktopPane);
		
		this.consolePanel = new ResultConsolePanel();
		this.splitPaneEditorAndConsole.setRightComponent(this.consolePanel);
		splitPaneEditorAndConsole.setDividerLocation(this.getHeight() - 250);
		
		JPanel panelLeftJTree = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelLeftJTree.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		SplitPanePrincipal.setLeftComponent(panelLeftJTree);
		
		JTree fileExplorer = new JTree();
		fileExplorer.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("colors");
						node_1.add(new DefaultMutableTreeNode("blue"));
						node_1.add(new DefaultMutableTreeNode("violet"));
						node_1.add(new DefaultMutableTreeNode("red"));
						node_1.add(new DefaultMutableTreeNode("yellow"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("sports");
						node_1.add(new DefaultMutableTreeNode("basketball"));
						node_1.add(new DefaultMutableTreeNode("soccer"));
						node_1.add(new DefaultMutableTreeNode("football"));
						node_1.add(new DefaultMutableTreeNode("hockey"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("food");
						node_1.add(new DefaultMutableTreeNode("hot dogs"));
						node_1.add(new DefaultMutableTreeNode("pizza"));
						node_1.add(new DefaultMutableTreeNode("ravioli"));
						node_1.add(new DefaultMutableTreeNode("bananas"));
					add(node_1);
				}
			}
		));
		panelLeftJTree.add(fileExplorer);
		
		panelToolBar = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelToolBar.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panelToolBar, BorderLayout.NORTH);
		
		compilerToolBar = new JToolBar();
		panelToolBar.add(compilerToolBar);
		
		btnAnalice = new JButton("Analizar");
		btnAnalice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Token> tokens = analizeCurrentLexer();
				
				new Thread() {
					@Override
					public void run() {
						consolePanel.getTerminalPanel().writteIn(">> Iniciando inspección... \n");				
						
						for(Token token : tokens) {
							consolePanel.getTerminalPanel().writteIn(token.toString() + " \n");
						}
										
						consolePanel.getTerminalPanel().writteIn(">> Inspección terminada \n");
					};					
				}.start();
				
				new Thread() {
					@Override
					public void run() {
						asmSyntaxParse(tokens);
					}
				}.start();
				
			}
		});
		compilerToolBar.add(btnAnalice);
		
		JButton btnEnviarLocal = new JButton("Enviar");
		compilerToolBar.add(btnEnviarLocal);

	}
	
	public void asmSyntaxParse(List<Token> tokens) {			
		
		AsmParser parser = new AsmParser(tokens);
		parser.setResultConsolePanel(consolePanel);
		consolePanel.getTerminalPanel().writteIn(">>Iniciando Analisis\n");
		parser.parseProgram();
		consolePanel.getTerminalPanel().writteIn(">>Analisis Terminado\n");
		
	}
	
	public List<Token> analizeCurrentLexer() {
		
		AsmLexer currentLexer = getCurrentLexer();
		List<Token> tokens = currentLexer.tokenize();						
		return tokens;
	}
	
	private AsmLexer getCurrentLexer() {
		AsmEditorInternalFrame frame = (AsmEditorInternalFrame)this.desktopPane.getSelectedFrame();
		frame.setAsmLexer();
		return frame.getLexer();
	}
	
	
	
	public void openNewAsmEditor() {
		
		try {
									
			NewEditorWizardDialog dialog = this.openEditorWizard(FileType.ASSEMBLY_FILE);
			
			if(dialog.getDialogResult() != DialogResult.OK) {
				JOptionPane.showMessageDialog(this, "Result: " + dialog.getDialogResult());
				return;
			}
			
			
			JOptionPane.showMessageDialog(this, "Result: " + dialog.getDialogResult() + "file: " + dialog.getFileModel().getName());
			
			JInternalFrame asmInternalFrame = new AsmEditorInternalFrame();
			asmInternalFrame.setTitle(dialog.getFileModel().getName());
			asmInternalFrame.setVisible(true);
			asmInternalFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			this.desktopPane.add(asmInternalFrame);
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return;
		}
		
		
	}
	
	private void openNewEditor() {
		
	}
	
	/**
	 * fix the position of the console and the file explorer before rezising the window
	 */
	private void setConsoleDividerLocationEvent() {
		this.splitPaneEditorAndConsole.setDividerLocation(this.getHeight() - 250);
		this.SplitPanePrincipal.setDividerLocation(/*700 - this.getWidth()*/ 0);
	}
	
	private NewEditorWizardDialog openEditorWizard(FileType fileType) throws Exception{
		
		NewEditorWizardDialog newEditorWizard = new NewEditorWizardDialog(fileType);
		newEditorWizard.setModal(true);
		newEditorWizard.setModalityType(ModalityType.APPLICATION_MODAL);
		newEditorWizard.setLocationRelativeTo(this);
		newEditorWizard.setVisible(true);
		return newEditorWizard;
		
	}
}
