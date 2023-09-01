package com.br.aeroapi.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Util {

    public static Timestamp formatarData(String dataTexto) {
        //String dateTime = "01/10/2020 06:43:21";
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dataTexto));
        Timestamp ts = Timestamp.valueOf(localDateTime);

        System.out.println(ts);
        return ts;
    }

    public static Date formatarDataSemHora(String dataTexto) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = formato.parse(dataTexto);
        System.out.println(data);
        return data;
    }

    public static boolean verificaTempoEmissao(Date tempoEmissao, Date horarioVoo) {
        long diferencaEmMilissegundos = horarioVoo.getTime() - tempoEmissao.getTime();
        long limiteEmMilissegundos = 5 * 60 * 60 * 1000; // 5 horas em milissegundos

        return diferencaEmMilissegundos >= 0 && diferencaEmMilissegundos <= limiteEmMilissegundos;
    }
}

