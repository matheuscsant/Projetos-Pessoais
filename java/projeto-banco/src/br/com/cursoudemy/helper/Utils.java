package br.com.cursoudemy.helper;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

  private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy")
	  .withZone(ZoneId.systemDefault());
  private static NumberFormat nf = new DecimalFormat("R$ #,##0.00",
	  new DecimalFormatSymbols(new Locale("pt", "BR")));
  private static Pattern ptnCpf = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
  private static Pattern ptnCnpj = Pattern.compile("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})");

  /**
   * @param data
   *          valor em date para ser convertido em string (dd/MM/yyyy)
   * @return String formata em data
   */
  public static String dateParaString(LocalDate data) {
	return Utils.dtf.format(data);
  }

  /**
   * @param valor
   *          double
   * @return String formata em real (R$ 2.000,00)
   */
  public static String doubleParaString(Double valor) {
	return Utils.nf.format(valor);
  }

  /**
   * @param valor
   *          transforma valor de String para Double (R$ 2.000,0 -> 2000,0)
   * @return Double
   */
  public static Double stringParaDouble(String valor) {
	try {
	  return (Double) Utils.nf.parse(valor);
	} catch (ParseException e) {
	  return null;
	}
  }

  /**
   * @param segundos
   */
  public static void pausar(int segundos) {
	try {
	  TimeUnit.SECONDS.sleep(segundos);
	} catch (InterruptedException e) {
	  System.out.println("Erro ao pausar por " + segundos + " segundos.");
	}
  }

  /**
   * @param data
   * @return Date
   */
  public static LocalDate stringParaDate(String data) {
	return LocalDate.parse(data);
  }

  /**
   * @param cpf
   *          String com cpf não formatado ###########
   * @return String formatada para cpf ###.###.###-##
   */
  public static String formatarStringParaCPF(String cpf) {
	Matcher matcher = ptnCpf.matcher(cpf);
	if (matcher.matches()) {
	  cpf = matcher.replaceAll("$1.$2.$3-$4");
	}
	return cpf;
  }

  /**
   * @param cnpj
   *          String com cnpj não formatado ##############
   * @return String formatada para cnpj ##.###.###/####-##
   */
  public static String formatarStringParaCNPJ(String cnpj) {
	Matcher matcher = ptnCnpj.matcher(cnpj);
	if (matcher.matches()) {
	  cnpj = matcher.replaceAll("$1.$2.$3/$4-$5");
	}
	return cnpj;
  }

}
