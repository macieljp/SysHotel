/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.tsi.pi.syshotel.Util;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JoaoPaulo
 */
public class Util {

     private static Component rootPane;
    private static SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");

    public static void abrirJFrameCentralizado(JFrame dialog) {

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void abrirJDialogCentralizado(JDialog dialog) {

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static String calendarParaString(Calendar cal) {
        return dataFormatada.format(cal.getTime());
    }

    public static Calendar stringParaCalendar(String data) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(dataFormatada.parse(data));
            return c;
        } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static boolean validacpf(String strCpf) { // formato XXX.XXX.XXX-XX   
        if (!strCpf.substring(0, 1).equals("")) {
            try {
                int d1, d2;
                int digito1, digito2, resto;
                int digitoCPF;
                String nDigResult;
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                d1 = d2 = 0;
                digito1 = digito2 = resto = 0;

                for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.   
                    d1 = d1 + (11 - nCount) * digitoCPF;

                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.   
                    d2 = d2 + (12 - nCount) * digitoCPF;
                }

                //Primeiro resto da divisão por 11.   
                resto = (d1 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.   
                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }

                d2 += 2 * digito1;

                //Segundo resto da divisão por 11.   
                resto = (d2 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.   
                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }

                //Digito verificador do CPF que está sendo validado.   
                String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

                //Concatenando o primeiro resto com o segundo.   
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.   
                return nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean validarEmail(String email) {

        Pattern pattern = Pattern.compile("([a-zA-Z0-9_\\-\\.]+)@((\\[a-z]{1,3}\\.[a-z]"
                + "{1,3}\\.[a-z]{1,3}\\.)|(([a-zA-Z\\-]+\\.)+))" + "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)",
                Pattern.MULTILINE);
        Matcher m = pattern.matcher(email);
        return m.matches();
    }

    public static boolean imprimirConfirmacao(String text) {
        int opcao = JOptionPane.showConfirmDialog(rootPane,
                text, "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (opcao != JOptionPane.YES_OPTION) {
            return false;

        }
        return true;
    }

    public static boolean dispayMsg(String text) {
        JOptionPane.showMessageDialog(rootPane, text, "Confirmação", JOptionPane.YES_OPTION);
        return true;
    }

    public static void sair() { //informa sistema que a aplicação esta fechado de forma correta
        System.exit(0);
    }
}