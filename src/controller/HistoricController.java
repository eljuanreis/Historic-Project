package controller;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import stackStrings.StackStrings;

public class HistoricController {

	public void validate(String text)
	{
		text = text.toLowerCase();

		String http = "http://";
		String https = "https://";
		
		if (text.contains(http) == false && text.contains(https) == false) {
			JOptionPane.showMessageDialog(null, "Endereço inválido!");
			System.out.println("a");
			return;
		}
		
		if (text.contains("www") == false) {
			JOptionPane.showMessageDialog(null, "Endereço inválido!");
			System.out.println("b");

			return;
		}
		
		String[] pontos = text.split("\\.");
		
		System.out.println(pontos.length);
		
		if (pontos.length < 2) {
			JOptionPane.showMessageDialog(null, "Endereço inválido!");
			System.out.println("c");

			return;
		}
		
	}
	
	public void addOnHistoric(StackStrings stack, String text)
	{
		this.validate(text);
	
		stack.push(text);
	}
	
	public void removeHistoric(StackStrings stack)
	{
		if (stack.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há histórico para ser removido");
			return;
		}
		
		try {
			stack.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void topHistoric(StackStrings stack)
	{
		if (stack.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Não há registro de histórico");
			return;
		}
		
		try {
			JOptionPane.showMessageDialog(null, stack.top());
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
